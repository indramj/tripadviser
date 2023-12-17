package com.first.tripadviser.service;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.dto.PageRequestDTO;
import com.first.tripadviser.dto.PageResultDTO;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.entity.MemberRole;
import com.first.tripadviser.repository.MemberRepository;
import com.first.tripadviser.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final ReviewRepository reviewRepository;

    public void registMember(MemberDTO memberDTO){
        String encodedPw = passwordEncoder.encode(memberDTO.getMemberPw());
        Member member = dtoToEntity(memberDTO);
        member.changePw(encodedPw);
        member.addRole(MemberRole.MEMBER);
        member.active();
        memberRepository.save(member);
    }

    public List<MemberDTO> getMemberList() {
        List<Member> memberList = memberRepository.findAll(Sort.by("memberId").ascending());
        List<MemberDTO> dtoList = new ArrayList<MemberDTO>();
        for (Member member : memberList) {
            dtoList.add(entityToDTO(member));
        }
        return dtoList;
    }

    public MemberDTO getMemberById(String memberId){
        Optional<Member> entity = memberRepository.findById(memberId);
        if(entity.isPresent()){
            Member member = entity.get();
            MemberDTO memberDTO = entityToDTO(member);
            return memberDTO;
        }
        return null;
    }

    @Override
    public void deleteAllReviewsByMemberId(String memberId){
//        Optional<Member> result = memberRepository.findById(memberId);
//        if(result.isPresent()) {
//            Member member = result.get();
//            member.getReviews().clear();
//            memberRepository.save(member);
//        }
    }


    @Override
    @Transactional
    public void deleteMemberById(String memberId) {
        deleteAllReviewsByMemberId(memberId);
        memberRepository.deleteById(memberId);
    }

    public void modifyMember(MemberDTO memberDTO){
        Optional<Member> entity = memberRepository.findById(memberDTO.getMemberId());
        if(entity.isPresent()){
            Member member = entity.get();
            member.changeEmail(memberDTO.getMemberEmail());
            if(!memberDTO.getMemberPw().isEmpty()) {
                member.changePw(passwordEncoder.encode(memberDTO.getMemberPw()));
            }
            memberRepository.save(member);
        }
    }

    public void addRole(String memberId){
        Optional<Member> entity = memberRepository.findById(memberId);
        if(entity.isPresent()){
            Member member = entity.get();
            member.addRole(MemberRole.ADMIN);
            memberRepository.save(member);
        }
    }

    public void delRole(String memberId){
        Optional<Member> entity = memberRepository.findById(memberId);
        if(entity.isPresent()){
            Member member = entity.get();
            member.delAdmin();
            memberRepository.save(member);
        }
    }

    public void changeActive(String memberId){
        Optional<Member> entity = memberRepository.findById(memberId);
        if(entity.isPresent()){
            Member member = entity.get();
            if(member.isActive())
                member.block();
            else
                member.active();
            memberRepository.save(member);
        }
    }

    @Override
    public List<Member> searchMembers(String keyword) {
        return memberRepository.searchMembers(keyword);
    }


    public boolean checkPassword(MemberDTO memberDTO){
        Optional<Member> entity = memberRepository.findById(memberDTO.getMemberId());
        Member member = entity.get();

        return passwordEncoder.matches(memberDTO.getMemberPw(), member.getMemberPw());
    }

    public PageResultDTO<MemberDTO, Member> findMemberByStr(String str, PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("memberId"));
        Page<Member> result = memberRepository.findMemberByStr(str, pageable);

        Function<Member, MemberDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO(result, fn);
    };

    public PageResultDTO<MemberDTO, Member> listMemberByStr(String str, PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("memberId"));
        Page<Member> result = memberRepository.listMemberByStr(str, pageable);

        Function<Member, MemberDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO(result, fn);
    };

    public PageResultDTO<MemberDTO, Member> getMemberListWithPaging(PageRequestDTO pageDTO) {
        Pageable pageable = pageDTO.getPageable(Sort.by("memberId"));
        Page<Member> result = memberRepository.findAll(pageable);
        Function<Member, MemberDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO(result, fn);
    }


}
