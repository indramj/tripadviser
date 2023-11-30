package com.first.tripadviser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long reviewNum;
    private Long contentId;
    private String memberId;
    private String password;
    private String review;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

}
