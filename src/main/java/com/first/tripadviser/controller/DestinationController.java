package com.first.tripadviser.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/dest")
@RequiredArgsConstructor
@Controller
public class DestinationController {

    @GetMapping("/info")
    public void showInfo(@RequestParam("contentid") String contentid ,  Model model){
        model.addAttribute("contentid" , contentid);

    }
    @PostMapping("/addDest")
    public void addDest(){

    }


}
