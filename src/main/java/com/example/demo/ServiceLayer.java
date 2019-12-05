package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getSortedRestaurantList(int pageNr, int itemsPerPage, boolean onlyStrollerFriendly, boolean onlyWheelchairFriendly) {
        restaurantRepository.getRestaurants();
        return restaurantRepository.getSortedRestaurantList(pageNr, itemsPerPage, onlyStrollerFriendly, onlyWheelchairFriendly);
    }

    public Restaurant getRestaurant(Integer id) {
        return restaurantRepository.getRestaurant(id);
    }
}
