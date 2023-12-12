package com.first.tripadviser.controller;

import com.first.tripadviser.dto.PlanDTO;
import com.first.tripadviser.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;


    @PostMapping("/add")
    public void addPlan(@RequestBody PlanDTO planDTO , HttpSession session){
        String memberId = (String)session.getAttribute("memberId");
        planDTO.setMemberId(memberId);
        Long planNo = planService.addPlan(planDTO);
        session.setAttribute("planNo" , planNo);
    }

}
