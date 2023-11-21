package com.first.tripadviser.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String openMain(){
        return "/main";

    }

    @GetMapping("/map")
    public void openMap(){

    }

    @GetMapping("/join")
    public void openJoin() {

    }
}
