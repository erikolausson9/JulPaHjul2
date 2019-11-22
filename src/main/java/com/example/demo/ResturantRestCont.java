package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResturantRestCont {

    @Autowired
    RestaurantRepository repository;

    @GetMapping("/resturantData")
    List<Restaurant> getDataList (){

        return repository.getRestaurantList();
    }


}
