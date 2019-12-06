package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class RestaurantRepository {
    @Autowired
    DataSource dataSource;

    //instance variables
    private List<Restaurant> restaurantList;

    //constructor
    public RestaurantRepository(){

        restaurantList = new ArrayList<Restaurant>();

        //restaurantList = getRestaurants();
        //create20FakeRestaurants();
    }

    public boolean testDB() throws SQLException {
        int two = 0;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1+1")) {
            rs.next();
            two = rs.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return two == 2;
    }




    //instance methods
    public List<Restaurant> getSortedRestaurantList(int pageNr, int itemsPerPage, boolean onlyStrollerFriendly, boolean onlyWheelchairFriendly ) {
        //return sorted sublist whose size depends on parameter itemsPerPage
        List<Restaurant> subList = new ArrayList<Restaurant>();

        Collections.sort(restaurantList);

        for(int ii=0; ii< Math.min(itemsPerPage, restaurantList.size()); ii++){

            Restaurant restaurant = restaurantList.get(pageNr+ii);

            //update the list of tomtar used for displaying the tomterating on the front page
            restaurant.clearTomteList();
            for(int jj=0; jj<(int)Math.round(restaurant.getTomterating()); jj++){
             restaurant.addTomte();
            }


            if(onlyStrollerFriendly&&onlyWheelchairFriendly){//if this flag is set, only include restaurants that are both stroller- and wheelchairfriendly
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
        //Collections.sort(subList);
        return subList;
    }

    public void addRestaurant(Restaurant restaurantToAdd){
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Restaurang (RestaurangNamn, RestaurangBeskrivning, RestaurangLongitud, RestaurangLatitutd, TomteRating, RestaurangOppettider, Prisklass, Lank, Barnvagnsvanligt, Rullstolsvanligt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, restaurantToAdd.getName());
            preparedStatement.setString(2, restaurantToAdd.getDescription());
            preparedStatement.setDouble(3, restaurantToAdd.getLng());
            preparedStatement.setDouble(4, restaurantToAdd.getLat());
            preparedStatement.setDouble(5, restaurantToAdd.getTomterating());
            preparedStatement.setString(6, restaurantToAdd.getOppettider());
            preparedStatement.setString(7, restaurantToAdd.getPriskategori());
            preparedStatement.setString(8, restaurantToAdd.getLinkToWebsite());
            preparedStatement.setBoolean(9,restaurantToAdd.isStrollerOk());
            preparedStatement.setBoolean(10,restaurantToAdd.isWheelchairOk());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }

    public List<Restaurant> getRestaurants(){
        restaurantList.clear();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM RESTAURANG")){
            while(rs.next()){
                    restaurantList.add(rsRestaurant(rs));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //restaurants.add(new Restaurant("hej", "h", 2.5, true, true, 1,1));
        return restaurantList;
    }

    public Restaurant rsRestaurant(ResultSet rs) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(rs.getInt("RestaurangId"));
        restaurant.setName(rs.getString("RestaurangNamn"));
        restaurant.setDescription(rs.getString("RestaurangBeskrivning"));
        restaurant.setLatLng(rs.getFloat("RestaurangLatitutd"), rs.getFloat("RestaurangLongitud"));
        restaurant.setTomterating(rs.getDouble("TomteRating"));
        restaurant.setOppettider(rs.getString("RestaurangOppettider"));
        restaurant.setPriskategori(rs.getString("Prisklass"));
        restaurant.setLinkToWebsite(rs.getString("Lank"));
        restaurant.setStrollerOk(rs.getBoolean("Barnvagnsvanligt"));
        restaurant.setWheelchairOk(rs.getBoolean("Rullstolsvanligt"));

        return restaurant;
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

            double tomterating = 1.0 + r.nextInt(16)*0.25;

            Restaurant newRestaurant = new Restaurant("Restaurang " + ii, "Serverar traditionellt julbord varje dag" , tomterating, strollerOk, wheelchairOk, lat, lng);
            newRestaurant.setId(ii);
            newRestaurant.setNumberOfVotes(10);
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
