package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceLayer {

    @Autowired
    RestaurantRepository restaurantRepository;

    public ArrayList<Restaurant> getRestaurantList(int pageNr, int itemsPerPage) {
        return (ArrayList<Restaurant>) restaurantRepository.getRestaurantList(pageNr, itemsPerPage);
    }
}
