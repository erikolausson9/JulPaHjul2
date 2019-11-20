package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {

    //instance variables
    private List<Restaurant> restaurantList;

    //constructor
    public RestaurantRepository(){
        restaurantList = new ArrayList<Restaurant>();
    }


    //getters and setters
    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    //instance methods
    public void addRestaurant(Restaurant restaurantToAdd){
        restaurantList.add(restaurantToAdd);
    }


}
