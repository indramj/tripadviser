package com.first.tripadviser.controller;

import com.first.tripadviser.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Log4j2
public class MemberController {

    //private final UserService userService;

    @PostMapping("/join")
    public void joinConfirm(@RequestBody MemberDTO member){
        log.info("memberDTO : " + member);




    }


}
