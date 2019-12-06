package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BookingRepository bookingRepository;

    //instance methods

    public List<Restaurant> getSortedRestaurantList(int pageNr, int itemsPerPage, boolean onlyStrollerFriendly, boolean onlyWheelchairFriendly) {

        //get restaurants from database and store them in RestaurantRepositorys instance variable restaurantList
        restaurantRepository.getRestaurants();

        return restaurantRepository.getSortedRestaurantList(pageNr, itemsPerPage, onlyStrollerFriendly, onlyWheelchairFriendly);
    }

    public Restaurant getRestaurant(Integer id) {
        return restaurantRepository.getRestaurant(id);
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.addRestaurant(restaurant);
    }

    public void addBooking(Booking booking) {
        bookingRepository.addBooking(booking);
    }

    public void addMember(Member member) {
        memberRepository.addMember(member);
    }

    public Member getMember(String username) {
        return memberRepository.getMemberByUsername(username);
    }

  public Booking getMyBooking (String username) {
        return bookingRepository.getMyBooking(username);
    }

}
