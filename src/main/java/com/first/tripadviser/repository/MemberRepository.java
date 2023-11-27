package com.first.tripadviser.repository;


import com.first.tripadviser.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    @Query("select m from Member m where m.memberId like concat('%',:str, '%')")
    Page<Member> findMemberByStr(@Param("str") String str, Pageable pageable);
}
