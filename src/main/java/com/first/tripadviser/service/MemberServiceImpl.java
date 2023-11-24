package com.first.tripadviser.service;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public void registMember(MemberDTO memberDTO){
        memberRepository.save(dtoToEntity(memberDTO));
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
        return entity.isPresent()? entityToDTO(entity.get()) : null;

    }


    public void deleteMemberById(String memberId) {
        memberRepository.deleteById(memberId);

    }

    public void modifyMember(MemberDTO memberDTO){
        Optional<Member> entity = memberRepository.findById(memberDTO.getMemberId());
        Member member = entity.get();
        member.changeEmail(memberDTO.getMemberEmail());
        if(!memberDTO.getMemberPw().isEmpty()) {
            member.changePw(memberDTO.getMemberPw());
        }
        memberRepository.save(member);

    }


    public boolean checkPassword(MemberDTO memberDTO){
        Optional<Member> entity = memberRepository.findById(memberDTO.getMemberId());
        Member member = entity.get();
        if(member.getMemberPw().equals(memberDTO.getMemberPw())){
            return true;
        }
        else
            return false;
    }

}
