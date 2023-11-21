package com.first.tripadviser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor

public class UserDTO {

    private String userId;
    private String userPw;
    private String userEmail;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;


}
