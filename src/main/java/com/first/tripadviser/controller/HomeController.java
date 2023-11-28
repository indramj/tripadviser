package com.first.tripadviser.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller("")
@Log4j2
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("")
    public String openMain(){
        return "/main";

    }

    @GetMapping("/dest")
    public void openMap(){

    }

    @GetMapping("/join")
    public void openJoinPage() {

    }

    @GetMapping("/mytrip")
    public void openMyTrip(){

    }



}
