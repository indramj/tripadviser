package com.first.tripadviser.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@Getter
@ToString
@Table(name = "tb_memberdest")
public class MemberDest {
    @Id
    private String memberId;
    private Long destinationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;




}
