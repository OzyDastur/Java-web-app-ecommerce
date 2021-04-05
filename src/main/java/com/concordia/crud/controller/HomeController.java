package com.concordia.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String root() {
        return "index";
    }

//    @GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }
//    
//    @GetMapping("/register")
//    public String register() {
//        return "register";
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//    
    @GetMapping("/about")
    public String about() {
        return "about";
    }
//    
//    @GetMapping("/product")
//    public String products() {
//        return "product";
//    }
//    
    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }
    
    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }
    
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}
