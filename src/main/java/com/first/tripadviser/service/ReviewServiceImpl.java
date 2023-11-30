package com.first.tripadviser.service;

import com.first.tripadviser.dto.MemberDTO;
import com.first.tripadviser.dto.ReviewDTO;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.entity.Review;
import com.first.tripadviser.repository.MemberRepository;
import com.first.tripadviser.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    @Override
    public void registReview(ReviewDTO reviewDTO){

        Review review = dtoToEntity(reviewDTO);
        reviewRepository.save(review);
    }
    @Override
    public List<ReviewDTO> reviewListByContentId(Long contentId){
        List<Review> reviewList = reviewRepository.findByContentId(contentId);
        List<ReviewDTO> dtoList = new ArrayList<>();
        for (Review review : reviewList) {
            dtoList.add(entityToDTO(review));
        }
        return dtoList;
    }

    @Override
    public void modifyReview(ReviewDTO reviewDTO){
        Optional<Review> result =  reviewRepository.findById(reviewDTO.getReviewNum());
        if(result.isPresent()){
            Review review = result.get();
            review.changeReview(reviewDTO.getReview());
            reviewRepository.save(review);
        }
    }

    @Override
    public Boolean checkPassword(ReviewDTO reviewDTO){
        Optional<Review> result = reviewRepository.findById(reviewDTO.getReviewNum());
        if(result.isPresent()){
            Review review = result.get();
            return review.getPassword().equals(reviewDTO.getPassword());
        }
        return false;
    }

    @Override
    public void deleteReview(Long reviewNum){
        reviewRepository.deleteById(reviewNum);
    }


}
