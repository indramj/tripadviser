package com.first.tripadviser.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class LoginController {

    @GetMapping("/login")
    public void login(){
    }

    @GetMapping("/logout")
    public void openLoginPage(){
        log.info("---GeTLOGOUT-------------------------------------");
    }

    @PostMapping("/logout.do")
    public void logout(){



    }


}
