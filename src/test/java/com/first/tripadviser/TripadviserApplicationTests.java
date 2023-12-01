package com.first.tripadviser;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.dto.ReviewDTO;
import com.first.tripadviser.service.MemberService;
import com.first.tripadviser.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TripadviserApplicationTests {
	@Autowired
	MemberService memberService;
	@Autowired
	ReviewService reviewService;


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


}

