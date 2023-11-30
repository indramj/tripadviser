package com.first.tripadviser.service;

import com.first.tripadviser.dto.ReviewDTO;

public interface ReviewService {

    public void registReview(ReviewDTO review);


    default void entityToDTO(){


    }

}
