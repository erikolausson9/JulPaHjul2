package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
