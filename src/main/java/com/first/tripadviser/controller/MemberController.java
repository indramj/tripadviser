package com.first.tripadviser.controller;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.dto.PageRequestDTO;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


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

    @GetMapping("/idCheck/{memberId}")
    public Boolean idCheck(@PathVariable String memberId){
        return memberService.getMemberById(memberId) != null;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/list")
    public void getMemberList(Model  model , PageRequestDTO requestDTO){
        model.addAttribute("members" , memberService.getMemberListWithPaging(requestDTO));

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addRole/{memberId}")
    public ResponseEntity<String> addRole(@PathVariable("memberId") String memberId){
        memberService.addRole(memberId);
        return new ResponseEntity<>("result" , HttpStatus.OK);
    }

    @PutMapping("/delAdmin/{memberId}")
    @ResponseBody
    public ResponseEntity<String> delRole(@PathVariable("memberId") String memberId){
        memberService.delRole(memberId);
        return new ResponseEntity<>("result" , HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/changeActive/{memberId}")
    public ResponseEntity<MemberDTO> changeActive(@PathVariable("memberId") String memberId){
        memberService.changeActive(memberId);
        MemberDTO dto = memberService.getMemberById(memberId);
        return new ResponseEntity<MemberDTO>( dto, HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
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

    @PreAuthorize("isAuthenticated() && #memberId == principal.username || hasRole('ROLE_ADMIN')")
    @GetMapping("/modify")
    public void modifyMemberInfo(@RequestParam String memberId , HttpSession session, Model model)
    {
        boolean isMe = memberId.equals(session.getAttribute("memberId"));
        model.addAttribute("isMe" , isMe);
    }

    @GetMapping("/getMember/{memberId}")
    @ResponseBody
    public ResponseEntity<MemberDTO> getMemberDTO(@PathVariable("memberId") String memberId) {
        MemberDTO memberDTO = memberService.getMemberById(memberId);
        if(memberDTO != null){
            return new ResponseEntity<>(memberDTO , HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }





    @PreAuthorize("isAuthenticated()")
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
