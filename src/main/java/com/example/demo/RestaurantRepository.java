package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        Random r = new Random();

        for(int ii=0; ii<20; ii++){
            boolean strollerOk = true;
            boolean wheelchairOk = true;
            if(ii%2==0){
                strollerOk = false;
            }

            if(ii%3==0){
                wheelchairOk = false;
            }

            int latlow = 55_588_250;
            int lathigh = 55_603_297;
            int latResult = r.nextInt(lathigh-latlow) + latlow;

            int lnglow = 12_973_141;
            int lnghigh = 13_023_436;
            int lngResult = r.nextInt(lnghigh-lnglow) + lnglow;

            double lat = (double)latResult / 1000000;
            double lng = (double)lngResult / 1000000;

            Restaurant newRestaurant = new Restaurant("Restaurant" + ii, "Description" + ii, 2.0+ii*0.1, strollerOk, wheelchairOk, lat, lng);
            addRestaurant(newRestaurant);
        }
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
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
