package com.first.tripadviser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class DestDTO {
    private Long destId;
    private String contentId;
    private String destTitle;
    private String mapX;
    private String mapY;
    private LocalDate date;
    private String memberId;
}
