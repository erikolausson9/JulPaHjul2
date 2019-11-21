package com.example.demo;


import java.util.ArrayList;

public class Restaurant implements Comparable {

    private Integer id;
    private String name;
    private String description;
    private double tomterating;

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

    public Restaurant(){
    }

    public Restaurant(String name){
        this.name=name;
    }

    public Restaurant(String name, String description){
        this.name=name;
        this.description = description;
    }

    public Restaurant(String name, String description, double tomterating){
        this.name=name;
        this.description = description;
        this.tomterating = tomterating;
    }


    public Restaurant(String name, String description, String adress, String linkToWebsite){
        this.name=name;
        this.description = description;
        this.adress = adress;
        this.stadsdel = stadsdel;
        this.oppettider = oppettider;
        this.priskategori = priskategori;
        this.linkToWebsite = linkToWebsite;
        this.tomterating = tomterating;
    }

    public Restaurant(String name, String description, double tomterating, boolean strollerOk, boolean wheelchairOk, double lat, double lng){
        this.name=name;
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

    public double getTomterating() {
        return tomterating;
    }

    public void setTomterating(double tomterating) {
        this.tomterating = tomterating;
    }

    public boolean isStrollerOk() {
        return strollerOk;
    }

    public boolean isWheelchairOk() {
        return wheelchairOk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public void addTomte(){
        tomtar.add("\\uD83C\\uDF85");
    }

    public void setLatLng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
    public void clearTomteList(){
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


    @Override
    public int compareTo(Object o){
        Restaurant restaurant = (Restaurant)o;
        if(this.tomterating<restaurant.tomterating){
            return 1;
        }
        else if(this.tomterating>restaurant.tomterating){
        return -1;
        }
        else{
            return 0;
        }
    }

}


