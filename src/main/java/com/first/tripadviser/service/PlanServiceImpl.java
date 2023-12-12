package com.first.tripadviser.service;

import com.first.tripadviser.dto.PlanDTO;
import com.first.tripadviser.entity.Plan;
import com.first.tripadviser.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{

    private final PlanRepository planRepository;

    public Long addPlan(PlanDTO planDTO){
        Plan plan = dtoToEntity(planDTO);

        return (planRepository.save(plan)).getPlanNo();
    }

    public List<PlanDTO> readPlansbyId(String memberId){
        List<Plan> planList = planRepository.findAllByMember_MemberId(memberId);
        List<PlanDTO> dtoList = new ArrayList<>();
        for (Plan plan : planList) {
            PlanDTO dto = entityToDTO(plan);
            dtoList.add(dto);
        }
        return dtoList;
    }


}
