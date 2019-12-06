package com.example.demo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class Booking {
    private int bookingId;
    private int people;
    private String day;
    private String time;
    @Email
    private String email;
    @Size(min=2, max=15)
    private String firstname;
    @Size(min=2, max=15)
    private String lastname;
    @Size(min=9, max=15)
    private String phonenumber;

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
}
