package com.first.tripadviser.dto;

import com.first.tripadviser.entity.Destination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private Long planNo;
    private LocalDate startDate;
    private LocalDate endDate;
    private String memberId;

}
