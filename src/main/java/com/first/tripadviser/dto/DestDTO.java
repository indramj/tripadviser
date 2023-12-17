package com.first.tripadviser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration stayTime;
    private Long planNo;
}
