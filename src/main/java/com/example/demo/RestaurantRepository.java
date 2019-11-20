package com.example.demo;

import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantRepository {

    //instance variables
    private List<Restaurant> restaurantList;

    //constructor
    public RestaurantRepository(){

        restaurantList = new ArrayList<Restaurant>();

        create20FakeRestaurants(); //TODO: should be replaced by real restaurants
    }





    //instance methods
    public List<Restaurant> getRestaurantList(int pageNr, int itemsPerPage) {
        //return sublist whose size depends on parameter itemsPerPage
        return restaurantList.subList(pageNr*itemsPerPage, (pageNr)*itemsPerPage+itemsPerPage);
    }
    public void addRestaurant(Restaurant restaurantToAdd){
        restaurantList.add(restaurantToAdd);
    }

    public void create20FakeRestaurants(){
        for(int ii=0; ii<20; ii++){
            Restaurant newRestaurant = new Restaurant("Restaurant" + ii, "Description" + ii, 2.0+ii*0.1);
            addRestaurant(newRestaurant);
        }
    }

    public Restaurant getRestaurant(int id) {
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getId() == id) {
                return restaurant;
            }
        }
        return null;
    }




}
