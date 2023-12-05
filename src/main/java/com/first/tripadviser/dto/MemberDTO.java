package com.first.tripadviser.dto;

import com.first.tripadviser.entity.MemberRole;
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
    private Boolean active;
    private MemberRole memberRole;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;


}
