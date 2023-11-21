package com.first.tripadviser.repository;


import com.first.tripadviser.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
