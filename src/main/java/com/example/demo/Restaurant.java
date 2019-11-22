package com.example.demo;


import java.util.ArrayList;

public class Restaurant implements Comparable {

    private int id;
    private String name;
    private String description;
    private Double tomterating;
    private int numberOfVotes;

    private String adress;
    private String stadsdel;
    private String oppettider;
    private String priskategori;
    private String linkToWebsite;

    private ArrayList<String> tomtar;

    private boolean strollerOk;
    private boolean wheelchairOk;
    private double lat;
    private double lng;

    public Restaurant() {
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Restaurant(String name, String description, Double tomterating) {
        this.name = name;
        this.description = description;
        this.tomterating = tomterating;
    }


    public Restaurant(String name, String description, String adress, String stadsdel, String oppettider, String priskategori, String linkToWebsite, Double tomterating) {
        this.name = name;
        this.description = description;
        this.adress = adress;
        this.stadsdel = stadsdel;
        this.oppettider = oppettider;
        this.priskategori = priskategori;
        this.linkToWebsite = linkToWebsite;
        this.tomterating = tomterating;
    }

    public Restaurant(String name, String description, Double tomterating, boolean strollerOk, boolean wheelchairOk, double lat, double lng) {
        this.name = name;
        this.description = description;
        this.tomterating = tomterating;
        this.strollerOk = strollerOk;
        this.wheelchairOk = wheelchairOk;
        this.tomtar = new ArrayList<String>();
        this.lat = lat;
        this.lng = lng;
    }


    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTomterating() {
        return tomterating;
    }

    public void setTomterating(Double tomterating) {
        this.tomterating = tomterating;
    }

    public boolean isStrollerOk() {
        return strollerOk;
    }

    public boolean isWheelchairOk() {
        return wheelchairOk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLinkToWebsite() {
        return linkToWebsite;
    }

    public void setLinkToWebsite(String linkToWebsite) {
        this.linkToWebsite = linkToWebsite;
    }

    public double getLat() {
        return lat;

    }

    public ArrayList<String> getTomtar() {
        return tomtar;
    }

    public double getLng() {
        return lng;
        //instance methods
    }

    public void addTomte() {
        tomtar.add("\\uD83C\\uDF85");
    }

    public void setLatLng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public void clearTomteList() {
        tomtar.clear();
    }


    public void setOppettider(String oppettider) {
        this.oppettider = oppettider;
    }

    public String getPriskategori() {
        return priskategori;
    }

    public void setPriskategori(String priskategori) {
        this.priskategori = priskategori;
    }

    public void setStrollerOk(boolean strollerOk) {
        this.strollerOk = strollerOk;
    }

    public void setWheelchairOk(boolean wheelchairOk) {
        this.wheelchairOk = wheelchairOk;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    @Override
    public int compareTo(Object o) {
        Restaurant restaurant = (Restaurant) o;
        if (this.tomterating < restaurant.tomterating) {
            return 1;
        } else if (this.tomterating > restaurant.tomterating) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getStadsdel() {
        return stadsdel;
    }

    public void setStadsdel(String stadsdel) {
        this.stadsdel = stadsdel;
    }

    public String getOppettider() {
        return oppettider;
    }

    public void setTomtar(ArrayList<String> tomtar) {
        this.tomtar = tomtar;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}


