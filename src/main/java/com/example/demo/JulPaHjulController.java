package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JulPaHjulController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/")
    String goToIndexPage(Model model, @RequestParam(required = false, defaultValue = "0") String page){

        int pageNr = Integer.parseInt(page);

        ArrayList<Restaurant> selectedRestaurants = serviceLayer.getRestaurantList(pageNr, 10);
        model.addAttribute("restaurants", selectedRestaurants);
        return "index";
    }


//    @GetMapping("/")
//    String getBooks(Model model, @RequestParam(required = false, defaultValue = "0") String page){
//
//        int pageNr = Integer.parseInt(page);
//        //bookRepository = new BookRepository();
//        List<Book> selectedBooks = bookRepository.getPage(pageNr, 10);
//        model.addAttribute("selection", selectedBooks);
//        model.addAttribute("currentPage", pageNr);
//        int numberOfPages = bookRepository.numberOfPages(10);
//        ArrayList<Integer> pages = new ArrayList<Integer>(numberOfPages);
//        for(int ii=0; ii<numberOfPages; ii++){
//            pages.add(ii);
//        }
//
//        model.addAttribute("pages", pages);
//        model.addAttribute("numberOfPages", numberOfPages);
//        return "bookViewer";
//    }
}
