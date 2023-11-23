package com.first.tripadviser.service;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.entity.Member;

import java.util.List;

public interface MemberService {

    public void registMember(MemberDTO memberDTO);

    public List<MemberDTO> getMemberList();

    default Member dtoToEntity(MemberDTO memberDTO){
        return Member.builder()
                .memberId(memberDTO.getMemberId())
                .memberName(memberDTO.getMemberName())
                .memberEmail(memberDTO.getMemberEmail())
                .memberPw(memberDTO.getMemberPw()).build();
    }

    default MemberDTO entityToDTO(Member member){
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(member.getMemberId())
                .memberName(member.getMemberName())
                .memberEmail(member.getMemberEmail())
                .memberPw(member.getMemberPw())
                .regDate(member.getRegDate())
                .updateDate(member.getUpdateDate())
                .build();

        return memberDTO;
    }

}
