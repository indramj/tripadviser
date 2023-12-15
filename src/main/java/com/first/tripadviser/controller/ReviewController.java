package com.first.tripadviser.controller;

import com.first.tripadviser.dto.ReviewDTO;
import com.first.tripadviser.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@Log4j2
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/regist")
    public ResponseEntity<String> registReview(@RequestBody ReviewDTO reviewDTO){
        log.info("review Regist");
        reviewService.registReview(reviewDTO);
        return new ResponseEntity<>("result" , HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<List<ReviewDTO>> readReviews(@RequestParam("contentId") Long contentId){
        log.info("review Read");
        List<ReviewDTO> dtoList = reviewService.reviewListByContentId(contentId);
        return new ResponseEntity<>(dtoList , HttpStatus.OK);
    }

    @GetMapping("/pwCheck")
    public ResponseEntity<Boolean> checkPassword(@RequestBody ReviewDTO reviewDTO){
        log.info("checkPassword");
        Boolean result = reviewService.checkPassword(reviewDTO);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyReview(@RequestBody ReviewDTO reviewDTO){
        log.info("modify Review");
        reviewService.modifyReview(reviewDTO);
        return new ResponseEntity<>("result" , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{reviewNum}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewNum) {
        log.info("delete Review");
        reviewService.deleteReview(reviewNum);
        return new ResponseEntity<>("result", HttpStatus.OK);
    }
}
