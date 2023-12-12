package com.first.tripadviser.controller;


import com.first.tripadviser.dto.PlanDTO;
import com.first.tripadviser.entity.Plan;
import com.first.tripadviser.service.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Controller("")
@Log4j2
@RequiredArgsConstructor
public class HomeController {

    private final PlanService planService;

    @GetMapping("")
    public String openMain(HttpSession session){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()){
            String memberId = authentication.getName();
            session.setAttribute("memberId" , memberId);
        }
        return "/main";

    }

    @GetMapping("/dest")
    public void openMap(){

    }

    @GetMapping("/join")
    public void openJoinPage() {

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/myPlan")
    public void openMyPlan(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String memberId = authentication.getName();
        List<PlanDTO> dtoList = planService.readPlansbyId(memberId);
        model.addAttribute("plans" , dtoList);
    }



}
