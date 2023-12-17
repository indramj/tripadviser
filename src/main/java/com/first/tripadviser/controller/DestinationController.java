package com.first.tripadviser.controller;

import com.first.tripadviser.dto.DestDTO;
import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.service.DestinationService;
import com.first.tripadviser.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@RequestMapping("/dest")
@RequiredArgsConstructor
@Controller
public class DestinationController {

    private final DestinationService destService;
    private final MemberService memberService;


    @GetMapping("/info")
    public void showInfo(@RequestParam("contentId") Long contentId , Model model , HttpSession session){
        model.addAttribute("contentId" , contentId);
        String logineduser = (String)session.getAttribute("memberId");
        MemberDTO memberDTO = memberService.getMemberById(logineduser);

        model.addAttribute("logineduser" , memberDTO);

    }

    @GetMapping("/getDest/{planNo}")
    public ResponseEntity<List<DestDTO>> getDestinations(@PathVariable("planNo") Long planNo){
        List<DestDTO> destList = destService.getDestinationsByPlanNo(planNo);
        return new ResponseEntity<>(destList , HttpStatus.OK);
    }
    @GetMapping("/getDestByDate/{planNo}/{date}")
    public ResponseEntity<List<DestDTO>> getDestByPnoAndDate(@PathVariable Long planNo , @PathVariable String date){
        LocalDate localDate = LocalDate.parse(date , DateTimeFormatter.ISO_LOCAL_DATE);
        List<DestDTO> destList = destService.getDestByPnoAndDate(planNo , localDate);
        return new ResponseEntity<>(destList , HttpStatus.OK);
    }

    @PostMapping("/addList")
    public ResponseEntity<String> addDestList(@RequestBody List<DestDTO> dtoList){

        destService.addDestList(dtoList);
        return new ResponseEntity<>("result" , HttpStatus.OK);
    }

    @PostMapping("/addDest")
    public ResponseEntity<String> addDest(@RequestBody DestDTO destDTO , HttpSession session){
        Long planNo = (Long)session.getAttribute("planNo");
        destDTO.setPlanNo(planNo);
        LocalTime startTime = destDTO.getStartTime();
        Duration stayTime = destDTO.getStayTime();
        destDTO.setEndTime(startTime.plus(stayTime));
        destService.addDest(destDTO);
        return new ResponseEntity<>("result" , HttpStatus.OK);
    }


    @DeleteMapping("/delete/{destId}")
    public ResponseEntity<String> deleteDest(@PathVariable("destId") Long destId){
        destService.deleteDest(destId);
        return new ResponseEntity<>("result" , HttpStatus.OK);
    }


}
