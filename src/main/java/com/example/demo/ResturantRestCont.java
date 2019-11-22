package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResturantRestCont {

    @Autowired
    RestaurantRepository repository;

    @GetMapping("/resturantData")
    List<Restaurant> getDataList (){

        return repository.getRestaurantList();
    }

    @PostMapping("/mapChange")
    Position focusMap(@RequestParam String mapChange){
        switch(mapChange){
            case "GamlaVaster":
                return(new Position(55.604640, 12.996836));
            case "Carolikvarteren":
                return(new Position(55.606245, 13.009344));
            case "Davidshall":
                return(new Position(55.598955, 12.998516));
            case "Slottsstaden":
                return(new Position(55.597246, 12.976060));
            case "Mollevangen":
                return(new Position(55.591482, 13.008791));
            case "Radmansvangen":
                return(new Position(55.593009, 13.001743));
            case "Slussen":
                return(new Position(55.607810, 13.016972));
            case "Varnhem":
                return(new Position(55.605576, 13.022763));
            default:
                System.out.println("Switch case funkade inte i rest-controller");
                return(new Position(55.604640, 12.996836));

        }

    }


}
