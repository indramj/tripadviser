package com.first.tripadviser;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.dto.ReviewDTO;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.entity.MemberRole;
import com.first.tripadviser.repository.MemberRepository;
import com.first.tripadviser.service.MemberService;
import com.first.tripadviser.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootTest
class TripadviserApplicationTests {
	@Autowired
	private MemberService memberService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberRepository memberRepository;

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

	@Test
	void modifyReview(){
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setReviewNum(2L);
		reviewDTO.setMemberId("test1");
		reviewDTO.setPassword("test1");
		reviewDTO.setContentId(754003L);
		reviewDTO.setReview("비밀번호 체크함");
		boolean result = reviewService.checkPassword(reviewDTO);
		if(result){
			reviewService.modifyReview(reviewDTO);
		}
	}

	@Test
	void deleteReview(){
		Long reviewNum = 2L;
		reviewService.deleteReview(reviewNum);
	}

	@Test
	void createAccountWithPwEncoder(){
		for ( int i = 0 ; i < 300; i++){
			String mid = String.format("test%03d" , i);
			String name = String.format("name%03d" , i);
			String email = String.format("test%03d@test.com" , i );
			Member member = Member.builder()
					.memberId(mid)
					.memberPw(passwordEncoder.encode(mid))
					.memberName(name)
					.memberEmail(email)
					.build();
			member.addRole(MemberRole.MEMBER);
			if( i <= 100){
				member.addRole(MemberRole.ADMIN);
			}
			memberRepository.save(member);
		}

	}

	@Test
	public void readTest(){
		String mid = "member000";
		Optional<Member> result = memberRepository.getWithRoles(mid);
		if(result.isPresent()){
			Member member = result.get();
			System.out.println(member);
			System.out.println(member.getRoleSet());

		}



	}


}

