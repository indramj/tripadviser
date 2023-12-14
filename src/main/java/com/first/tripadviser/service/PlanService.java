package com.first.tripadviser.service;

import com.first.tripadviser.dto.PlanDTO;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.entity.Plan;

import java.util.List;

public interface PlanService {

    public Long addPlan(PlanDTO planDTO);

    public List<PlanDTO> readPlansbyId(String memberId);

    public void deletePlan(Long planNo);

    default PlanDTO entityToDTO(Plan plan){
        PlanDTO planDTO = PlanDTO.builder()
                .planNo(plan.getPlanNo())
                .startDate(plan.getStartDate())
                .endDate(plan.getEndDate())
                .memberId(plan.getMember().getMemberId())
                .build();
        return planDTO;
    }

    default Plan dtoToEntity(PlanDTO planDTO){
        Plan plan = Plan.builder()
                .planNo(planDTO.getPlanNo())
                .member(Member.builder().memberId(planDTO.getMemberId()).build())
                .startDate(planDTO.getStartDate())
                .endDate(planDTO.getEndDate())
                .build();
        return plan;
    }
}
