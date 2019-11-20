package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class JulPaHjulController {

    @GetMapping("/")
    String goToIndexPage(){

        return "index";
    }






    @GetMapping("/login")
    String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    String postLogin(HttpSession session, @RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("12345")) {
            session.setAttribute("username", username);
            return "index";
        }
        return "login";
    }

}
