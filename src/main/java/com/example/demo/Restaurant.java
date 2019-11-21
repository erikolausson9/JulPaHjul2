package com.example.demo;


public class Restaurant {

    //instance variables
    private Integer id;
    private String name;
    private String description;
    private double tomterating;
//<<<<<<< HEAD
    private String adress;
    private String stadsdel;
    private String oppettider;
    private String priskategori;
    private String linkToWebsite;

//=======
    private boolean strollerOk;
    private boolean wheelchairOk;
//>>>>>>> da3c8e67095f6c717d83c196f96b0e4d9957e047

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

//<<<<<<< HEAD
    public Restaurant(String name, String description, String adress, String stadsdel, String oppettider, String priskategori, String linkToWebsite, double tomterating){
        this.name=name;
        this.description = description;
        this.adress = adress;
        this.stadsdel = stadsdel;
        this.oppettider = oppettider;
        this.priskategori = priskategori;
        this.linkToWebsite = linkToWebsite;
        this.tomterating = tomterating;
    }

//=======
    public Restaurant(String name, String description, double tomterating, boolean strollerOk, boolean wheelchairOk){
        this.name=name;
        this.description = description;
        this.tomterating = tomterating;
        this.strollerOk = strollerOk;
        this.wheelchairOk = wheelchairOk;
    }


//>>>>>>> da3c8e67095f6c717d83c196f96b0e4d9957e047
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

    public String getStadsdel() {
        return stadsdel;
    }

    public void setStadsdel(String stadsdel) {
        this.stadsdel = stadsdel;
    }

    public String getOppettider() {
        return oppettider;
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
}


