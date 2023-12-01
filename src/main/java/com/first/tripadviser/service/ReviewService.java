package com.first.tripadviser.service;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.dto.ReviewDTO;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.entity.Review;

import java.util.List;

public interface ReviewService {

    public void registReview(ReviewDTO review);

    public List<ReviewDTO> reviewListByContentId(Long contentId);

    public void modifyReview(ReviewDTO reviewDTO);

    public Boolean checkPassword(ReviewDTO reviewDTO);

    public void deleteReview(Long reviewNum);






    default ReviewDTO entityToDTO(Review review){
        ReviewDTO dto = ReviewDTO.builder()
                .reviewNum(review.getReviewNum())
                .memberId(review.getMember().getMemberId())
                .review(review.getReview())
                .password(review.getPassword())
                .contentId(review.getContentId())
                .regDate(review.getRegDate())
                .updateDate(review.getUpdateDate())
                .build();
        return dto;
    }

    default Review dtoToEntity(ReviewDTO dto){

        Review review = Review.builder()
                .reviewNum(dto.getReviewNum())
                .member(Member.builder().memberId(dto.getMemberId()).build())
                .password(dto.getPassword())
                .contentId(dto.getContentId())
                .review(dto.getReview())
                .build();
        return review;
    }

}
