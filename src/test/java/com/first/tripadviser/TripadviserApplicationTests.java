package com.first.tripadviser;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TripadviserApplicationTests {
	@Autowired
	MemberService memberService;


	@Test
	void contextLoads() {
	}

	@Test
	void createAccounts(){
		for ( int i = 1 ; i <= 300 ; i++) {
			String mid = String.format("test%03d" , i);
			String name = String.format("name%03d" , i);
			String tPw = mid;
			String email = String.format("test%03d@test.com" , i );

			memberService.registMember(MemberDTO.builder()
					.memberId(mid)
					.memberName(name)
					.memberPw(tPw)
					.memberEmail(email)
					.build());
		}
	}
	@Test
	void deleteMemberById(){
		String memberId = "test300";
		memberService.deleteMemberById(memberId);
	}

}
