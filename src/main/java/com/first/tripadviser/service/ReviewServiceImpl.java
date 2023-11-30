package com.first.tripadviser.service;

import com.first.tripadviser.dto.ReviewDTO;
import com.first.tripadviser.entity.Review;
import com.first.tripadviser.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
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

}
