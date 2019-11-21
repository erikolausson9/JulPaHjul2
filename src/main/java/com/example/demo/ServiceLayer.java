package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurantList(int pageNr, int itemsPerPage, boolean onlyStrollerFriendly, boolean onlyWheelchairFriendly) {
        return restaurantRepository.getRestaurantList(pageNr, itemsPerPage, onlyStrollerFriendly, onlyWheelchairFriendly);
    }
}
