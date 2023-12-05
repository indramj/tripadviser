package com.first.tripadviser.controller;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.dto.MemberDestDTO;
import com.first.tripadviser.dto.PageRequestDTO;
import com.first.tripadviser.dto.PageResultDTO;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public String joinConfirm(@RequestBody MemberDTO memberDTO){
        log.info("memberDTO : " + memberDTO);
        memberService.registMember(memberDTO);
        return "redirect:/";
    }

    @GetMapping("/list")
    public void getMemberList(Model  model , PageRequestDTO requestDTO){
        model.addAttribute("members" , memberService.getMemberListWithPaging(requestDTO));

    }


    @PostMapping("/delete")
    public String deleteMember(@RequestParam(value = "checkList" , required=false) List<String> checkList  )
    {
        log.info("DeleteMember");
        if ( checkList != null) {
            for (int i = 0; i < checkList.size(); i++) {
                memberService.deleteMemberById(checkList.get(i));
            }
        }
        return "redirect:/member/list";
    }

    @GetMapping("/modify")
    public void modifyMemberInfo(@RequestParam String memberId , Model model)
    {
        MemberDTO dto = memberService.getMemberById(memberId);
        model.addAttribute("member" , dto);
    }

    @PostMapping("/modify")
    public ResponseEntity<String> confirmMemberModify(@RequestBody MemberDTO memberDTO){
        memberService.modifyMember(memberDTO);
        return new ResponseEntity<>("result" , HttpStatus.OK);
    }



    @GetMapping("/find")
    public void findMemberByIdPart(@RequestParam("IdPart") String str, Model model, PageRequestDTO requestDTO) {
        log.info("findMemberList");
        model.addAttribute("members", memberService.findMemberByStr(str, requestDTO));
        model.addAttribute("IdPart", str);
    };

    @PostMapping("/passwordCheck")
    public ResponseEntity<Boolean> checkPassword(@RequestBody MemberDTO memberDTO){
        log.info("memberDTO : " + memberDTO);
        boolean result = memberService.checkPassword(memberDTO);

        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/deleteById")
    public String deleteById(@RequestParam String memberId){
        memberService.deleteMemberById(memberId);
        return "redirect:/member/list";
    }

    @GetMapping("/search")
    public ResponseEntity<List<Member>> searchMembers(@RequestParam String keyword) {
        List<Member> searchResult = memberService.searchMembers(keyword);
        return ResponseEntity.ok(searchResult);
    }





}
