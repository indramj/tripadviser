package com.first.tripadviser.controller;

import com.first.tripadviser.dto.DestDTO;
import com.first.tripadviser.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/dest")
@RequiredArgsConstructor
@Controller
public class DestinationController {

    private final DestinationService destService;

    @GetMapping("/info")
    public void showInfo(@RequestParam("contentId") Long contentId , Model model){
        model.addAttribute("contentId" , contentId);

    }
    @PostMapping("/addList")
    public ResponseEntity<String> addDestList(@RequestBody List<DestDTO> dtoList){

        destService.addDestList(dtoList);
        return new ResponseEntity<>("result" , HttpStatus.OK);
    }

    @PostMapping("/addDest")
    public ResponseEntity<String> addDest(@RequestBody DestDTO destDTO){
        destService.addDest(destDTO);
        return new ResponseEntity<>("result" , HttpStatus.OK);
    }

//    @GetMapping("/read/{memberId}")
//    public ResponseEntity<List<DestDTO>> readDest(@PathVariable("memberId") String memberId){
//
//    }


}
