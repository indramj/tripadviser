package com.first.tripadviser.service;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.dto.PageRequestDTO;
import com.first.tripadviser.dto.PageResultDTO;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.entity.MemberRole;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {

    public void registMember(MemberDTO memberDTO);

    public List<MemberDTO> getMemberList();

    public MemberDTO getMemberById(String memberId);

    public void deleteMemberById(String memberId);

    public void modifyMember(MemberDTO memberDTO);

    public void addRole(String memberId);

    public void delRole(String memberId);

    public void changeActive(String memberId);


    List<Member> searchMembers(String keyword);

    public boolean checkPassword(MemberDTO memberDTO);

    public void deleteAllReviewsByMemberId(String memberId);

    public PageResultDTO<MemberDTO, Member> findMemberByStr(String str, PageRequestDTO dto);

    public PageResultDTO<MemberDTO, Member> getMemberListWithPaging(PageRequestDTO pageDTO);


    default Member dtoToEntity(MemberDTO memberDTO){
        return Member.builder()
                .memberId(memberDTO.getMemberId())
                .memberName(memberDTO.getMemberName())
                .memberEmail(memberDTO.getMemberEmail())
                .memberPw(memberDTO.getMemberPw()).build();
    }

    default MemberDTO entityToDTO(Member member){
        MemberRole lastRole = null;
        if(member.getRoleSet().contains(MemberRole.ADMIN)){
            lastRole = MemberRole.ADMIN;
        }
        else{
            lastRole = MemberRole.MEMBER;
        }

        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(member.getMemberId())
                .memberName(member.getMemberName())
                .memberEmail(member.getMemberEmail())
                .memberPw(member.getMemberPw())
                .memberRole(lastRole)
                .active(member.isActive())
                .regDate(member.getRegDate())
                .updateDate(member.getUpdateDate())
                .build();

        return memberDTO;
    }

}
