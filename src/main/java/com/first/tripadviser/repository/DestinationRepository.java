package com.first.tripadviser.repository;

import com.first.tripadviser.entity.Destination;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination , Long> {

    List<Destination> findAllByPlan_PlanNo(Long planNo);
    List<Destination> findAllByPlan_PlanNoAndDate(Long planNo , LocalDate date , Sort sort);

}
