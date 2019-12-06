package com.example.demo;

public class Booking {
    private int bookingId;
    private int userId;
    private int restaurantId;
    private int people;
    private String day;
    private String time;
    private String email;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String restaurant;
    private String restaurantLank;

    public Booking() {
    }

    public Booking(int bookingId, int people, String day, String time, String email, String firstname, String lastname, String phonenumber) {
        this.bookingId = bookingId;
        this.people = people;
        this.day = day;
        this.time = time;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }

    public Booking(int bookingId, int userId, int restaurantId, int people, String day, String time, String email, String firstname, String lastname, String phonenumber) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.people = people;
        this.day = day;
        this.time = time;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getRestaurantLank() {
        return restaurantLank;
    }

    public void setRestaurantLank(String restaurantLank) {
        this.restaurantLank = restaurantLank;
    }
}
