package com.first.tripadviser.controller;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.dto.MemberDestDTO;
import com.first.tripadviser.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Log4j2
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public void joinConfirm(@RequestBody MemberDTO memberDTO){
        log.info("memberDTO : " + memberDTO);
        memberService.registMember(memberDTO);
    }

    @GetMapping("/list")
    public void getMemberList(Model model)
    {
        log.info("memberList");
        model.addAttribute("members" , memberService.getMemberList());
    }

    @GetMapping("/delete")
    public void deleteMember(List<String> memberList)
    {
        log.info("DeleteMember");



    }





}
