package com.first.tripadviser.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@Getter
@ToString
@Table(name = "tb_userdest")
public class MemberDest {
    @Id
    private String memberId;
    private Long destinationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;




}
