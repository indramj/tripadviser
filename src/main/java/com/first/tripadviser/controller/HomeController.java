package com.first.tripadviser.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/main")
    public void openMain(){

    }

    @GetMapping("/map")
    public void opemMap(){

    }

}
