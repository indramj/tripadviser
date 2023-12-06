package com.first.tripadviser.repository;

import com.first.tripadviser.entity.Destination;
import com.first.tripadviser.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination , Long> {
}
