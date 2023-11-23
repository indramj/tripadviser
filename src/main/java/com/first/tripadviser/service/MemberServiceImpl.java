package com.first.tripadviser.service;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public void registMember(MemberDTO memberDTO){
        memberRepository.save(dtoToEntity(memberDTO));

    }

    public List<MemberDTO> getMemberList() {
        List<Member> memberList = memberRepository.findAll();
        List<MemberDTO> dtoList = new ArrayList<MemberDTO>();
        for (Member member : memberList) {
            dtoList.add(entityToDTO(member));
        }

        return dtoList;

    }



}
