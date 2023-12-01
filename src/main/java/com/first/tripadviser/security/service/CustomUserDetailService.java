package com.first.tripadviser.security.service;

import com.first.tripadviser.entity.Member;
import com.first.tripadviser.repository.MemberRepository;
import com.first.tripadviser.security.dto.MemberSecurityDTO;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> result = memberRepository.findById(username);
        if (!result.isPresent())
            throw new UsernameNotFoundException("user not found");
        Member member = result.get();
        MemberSecurityDTO memberDTO = new MemberSecurityDTO(
                member.getMemberId() , member.getMemberPw() , member.getMemberEmail(),
                member.getMemberName() , member.getRegDate() , member.getUpdateDate(),
                member.getRoleSet().stream().map(memberRole ->
                        new SimpleGrantedAuthority("ROLE_" + memberRole.name())).collect(Collectors.toList())
        );
        log.info(memberDTO);
        return memberDTO;
    }

}
