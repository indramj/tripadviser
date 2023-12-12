package com.first.tripadviser.repository;

import com.first.tripadviser.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    List<Plan> findAllByMember_MemberId(String memberId);
}
