package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;

@Controller
public class JulPaHjulController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/")
    String goToIndexPage(Model model){

        ArrayList<Restaurant> restaurants = serviceLayer.getRestaurantList();
        model.addAttribute("restaurants", restaurants);
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
        String username = (String)session.getAttribute("username") {
            if (username != null) {
                return "addRestaurant";
            }
            return "login";
        }

    }

    
}
