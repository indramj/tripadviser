package com.first.tripadviser.dto;

import com.first.tripadviser.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class DestDTO {
    private Long destId;
    private String contentId;
    private String destTitle;
    private double mapX;
    private double mapY;
    private LocalDateTime date;
    private String memberId;
}
