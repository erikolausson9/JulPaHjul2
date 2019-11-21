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
    public List<Restaurant> getRestaurantList(int pageNr, int itemsPerPage, boolean onlyStrollerFriendly, boolean onlyWheelchairFriendly ) {
        //return sublist whose size depends on parameter itemsPerPage
        List<Restaurant> subList = new ArrayList<Restaurant>();
        for(int ii=0; ii<itemsPerPage; ii++){

            Restaurant restaurant = restaurantList.get(pageNr+ii);

            //update the list of tomtar used for displaying the tomte rating on the front page
            restaurant.clearTomteList();
            for(int jj=0; jj<(int)Math.round(restaurant.getTomterating()); jj++){
             restaurant.addTomte();
            }


            if(onlyStrollerFriendly&&onlyWheelchairFriendly){//if this flag is set, only restaurants that are both stroller- and wheelchairfriendly
                if(restaurant.isStrollerOk()&&restaurant.isWheelchairOk()){
                    subList.add(restaurant);
                }
            }else if(onlyStrollerFriendly){
                if(restaurant.isStrollerOk()){
                    subList.add(restaurant);
                }
            }else if(onlyWheelchairFriendly){
                if(restaurant.isWheelchairOk()){
                    subList.add(restaurant);
                }
            }
            else {
                subList.add(restaurant);
            }


        }
        return subList;
    }
    public void addRestaurant(Restaurant restaurantToAdd){
        restaurantList.add(restaurantToAdd);
    }

    public void create20FakeRestaurants(){
        for(int ii=0; ii<20; ii++){
            boolean strollerOk = true;
            boolean wheelchairOk = true;
            if(ii%2==0){
                strollerOk = false;
            }

            if(ii%3==0){
                wheelchairOk = false;
            }


            Restaurant newRestaurant = new Restaurant("Restaurant" + ii, "Description" + ii, 2.0+ii*0.1, strollerOk, wheelchairOk);
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
