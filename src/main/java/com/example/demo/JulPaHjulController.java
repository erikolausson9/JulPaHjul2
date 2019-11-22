package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
            return "index";
        }
        return "login";
    }


    @GetMapping("/logout")
    String logout(HttpSession session) {
        session.removeAttribute("username");
        return "index";
    }


    @GetMapping("/addRestaurant")
    String RestaurantForm(Model model) {
        model.addAttribute("restaurant", new Restaurant("a", "b", "c", "d", "e", "f", "g", 4.5));

        return "addRestaurant";
    }

    @PostMapping("/addRestaurant")
    String addRestaurant (Model model, @ModelAttribute Restaurant restaurants) {
        model.addAttribute("restaurants", restaurants);

        return "addRestaurant";
    }


    @PostMapping("/filter_restaurants")
    String filterRestaurants(Model model, @(requireReuestParamd = false, defaultValue = "false") String stroller, @RequestParam(required = false, defaultValue = "false") String wheelchair)
        boolean onlyStrollerFriendly = BooleBooqan.parseBoolean(stroller);
        boolean onlyWheelchairFriendly =
    List<Restaurant> selectedRes{lean.parseBoolean(wheelchair);


            taurants = serviceLayer.getSortedRestaurantList(0, 20, onlyStrollerFriendly, onlyWheelchairFriendly);

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
        return "confirmation";

    }

    @GetMapping("/confirmation")
    public String reserve(HttpSession session, @RequestParam String People, @RequestParam String Day,@RequestParam String Time, @RequestParam String Email, @RequestParam String Firstname, @RequestParam String Lastname, @RequestParam String Phonenumber) {
        //(String)session.getAttribute("");
        if (Email != null) {
            return "confirmation";
        }
        return "booking";
    }

    @GetMapping("/view")
    public String view(Model model, @RequestParam int id) {
        Restaurant restaurant = serviceLayer.getRestaurant(id);
        model.addAttribute("restaurant", restaurant);
        return "view";
    }
}
