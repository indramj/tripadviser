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

    private Long rno;
    private String name;
    private String password;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

}
