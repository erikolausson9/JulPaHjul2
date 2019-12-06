package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JulPaHjulController {

    @Autowired
    ServiceLayer serviceLayer;


    @GetMapping("/")
    String goToIndexPage(Model model, @RequestParam(required = false, defaultValue = "0") String page) {

        int pageNr = Integer.parseInt(page);

        List<Restaurant> selectedRestaurants = serviceLayer.getSortedRestaurantList(pageNr, 20, false, false);


        model.addAttribute("restaurants", selectedRestaurants);

        return "index";
    }


    @GetMapping("/login")
    String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    String postLogin(HttpSession session, @RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("12345")) {
            session.setAttribute("username", username);
            System.out.println("You are now logged in");
            return "redirect:/";
        }
        return "login";
    }


    @GetMapping("/logout")
    String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/addMember")
    String addMember(Model model){
        model.addAttribute("member", new Member());

        return "addMember";
    }

    @PostMapping("/addMember")
    String addMember(HttpSession session, Model model, @Valid Member member, BindingResult result) {
        if (result.hasErrors()) {
            return "addMember";
        }
        model.addAttribute("member", member);
            serviceLayer.addMember(member);

        List<Member> members = (List<Member>)session.getAttribute("members");
        if (members == null) {
            members = new ArrayList<>();
            session.setAttribute("members", members);
        }
        members.add(member);

        return "addMember";
    }

    @GetMapping("/addRestaurant")
    String form(Model model) {
        model.addAttribute("restaurant", new Restaurant());

        return "addRestaurant";
    }

    @PostMapping("/addRestaurant")
    String addRestaurant (HttpSession session, Model model, @Valid Restaurant restaurant, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addRestaurant";
        }
        model.addAttribute("restaurant", restaurant);

            serviceLayer.addRestaurant(restaurant);

        List<Restaurant> restaurants = (List<Restaurant>)session.getAttribute("restaurants");
        if (restaurants == null) {
            restaurants = new ArrayList<>();
            session.setAttribute("restaurants", restaurants);
        }

        restaurants.add(restaurant);

        return "addRestaurant";
    }


    @PostMapping("/filter_restaurants")
    String filterRestaurants(Model model, @RequestParam(required = false, defaultValue = "false") String stroller, @RequestParam(required = false, defaultValue = "false") String wheelchair){
        boolean onlyStrollerFriendly = Boolean.parseBoolean(stroller);
        boolean onlyWheelchairFriendly = Boolean.parseBoolean(wheelchair);
    List<Restaurant> selectedRestaurants = serviceLayer.getSortedRestaurantList(0, 20, onlyStrollerFriendly, onlyWheelchairFriendly);

        model.addAttribute("restaurants", selectedRestaurants);

        return "index";
    }

    @GetMapping("/booking")
    String getbooking(Model model, @ModelAttribute Booking booking) {
        model.addAttribute("booking", booking);
        return "booking";
    }

    @PostMapping("/booking")
    String reserve(Model model, @ModelAttribute Booking booking) {
        model.addAttribute("booking", booking);
        serviceLayer.addBooking(booking);
        return "confirmation";
    }


    @GetMapping("/view")
    public String view(Model model, @RequestParam int id) {
        Restaurant restaurant = serviceLayer.getRestaurant(id);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("id", id);
        return "view";
    }


    @PostMapping("/newRating")
    String newRating(Model model, @RequestParam int id, @RequestParam String rating){
        double tomterating= serviceLayer.getRestaurant(id).getTomterating();
        int numberOfVotes = serviceLayer.getRestaurant(id).getNumberOfVotes();
        double newRating = Double.parseDouble(rating);
        //calculate new tomterating for the restaurant in question and round to two decimal places
        tomterating = ((tomterating*numberOfVotes)+newRating)/(numberOfVotes+1);
        int tempTomterating = (int)(tomterating*100);
        tomterating = (double)tempTomterating/100;
      
        serviceLayer.getRestaurant(id).setNumberOfVotes(numberOfVotes+1);
        serviceLayer.getRestaurant(id).setTomterating(tomterating);
        model.addAttribute("restaurant", serviceLayer.getRestaurant(id));
        model.addAttribute("id", id);
    return "view";
    }

    @GetMapping("/myBookings/{username}")
    String getBookings (@PathVariable String username){

        return "myBookings";
    }

}
