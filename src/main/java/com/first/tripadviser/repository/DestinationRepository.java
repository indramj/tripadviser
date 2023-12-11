package com.first.tripadviser.repository;

import com.first.tripadviser.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination , Long> {

    List<Destination> findAllByMember_MemberId(String memberId);
}
