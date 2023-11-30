package com.first.tripadviser.service;

import com.first.tripadviser.dto.ReviewDTO;
import com.first.tripadviser.entity.Review;

import java.util.List;

public interface ReviewService {

    public void registReview(ReviewDTO review);

    List<ReviewDTO> reviewListByContentId(Long contentId);



    default ReviewDTO entityToDTO(Review review){
        ReviewDTO dto = ReviewDTO.builder()
                .reviewNum(review.getReviewNum())
                .name(review.getName())
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
                .name(dto.getName())
                .password(dto.getPassword())
                .contentId(dto.getContentId())
                .review(dto.getReview())
                .build();
        return review;
    }

}
