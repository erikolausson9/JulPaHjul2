package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    String goToIndexPage(Model model, @RequestParam(required = false, defaultValue = "0") String page){

        int pageNr = Integer.parseInt(page);

        List<Restaurant> selectedRestaurants = serviceLayer.getRestaurantList(pageNr, 10, false, false);
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
    String addRestaurant(HttpSession session) {
        String username = (String)session.getAttribute("username");
            if (username != null) {
                return "addRestaurant";
            }
            return "login";
        }


    @PostMapping("/filter_restaurants")
    String filterRestaurants(Model model, @RequestParam(required = false, defaultValue = "false") String stroller, @RequestParam(required = false, defaultValue = "false") String wheelchair){

        boolean onlyStrollerFriendly = Boolean.parseBoolean(stroller);
        boolean onlyWheelchairFriendly = Boolean.parseBoolean(wheelchair);

        List<Restaurant> selectedRestaurants = serviceLayer.getRestaurantList(0, 10, onlyStrollerFriendly,onlyWheelchairFriendly);

        model.addAttribute("restaurants", selectedRestaurants);


    return "index";
    }

}
