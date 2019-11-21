package com.example.demo;


import java.util.ArrayList;

public class Restaurant {

    //instance variables
    private Integer id;
    private String name;
    private String description;
    private double tomterating;

    private String adress;
    private String linkToWebsite;

    private ArrayList<String> tomtar;

    private boolean strollerOk;
    private boolean wheelchairOk;


    //constructors with 0 ore more arguments
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
        this.linkToWebsite = linkToWebsite;
    }


    public Restaurant(String name, String description, double tomterating, boolean strollerOk, boolean wheelchairOk){
        this.name=name;
        this.description = description;
        this.tomterating = tomterating;
        this.strollerOk = strollerOk;
        this.wheelchairOk = wheelchairOk;
        this.tomtar = new ArrayList<String>();
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

    public ArrayList<String> getTomtar() {
        return tomtar;
    }

    //instance methods
    public void addTomte(){
        tomtar.add("\\uD83C\\uDF85");
    }

    public void clearTomteList(){
        tomtar.clear();
    }
}
