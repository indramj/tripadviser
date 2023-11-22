package com.first.tripadviser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor

public class MemberDTO {

    private String memberId;
    private String memberName;
    private String memberPw;
    private String memberEmail;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;


}
