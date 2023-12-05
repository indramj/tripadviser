package com.first.tripadviser.repository;


import com.first.tripadviser.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, String> {
    @Query("SELECT m FROM Member m WHERE m.memberId LIKE %:keyword%")
    List<Member> searchMembers(@Param("keyword") String keyword);

    @Query("select m from Member m where m.memberId like concat('%',:str, '%')")
    Page<Member> findMemberByStr(@Param("str") String str, Pageable pageable);

    @Query("select m from Member m where m.memberId like concat('%',:str, '%')")
    Page<Member> listMemberByStr(@Param("str") String str, Pageable pageable);

    @EntityGraph(attributePaths = "roleSet")
    @Query("select m from Member m where m.memberId=:mid")
    Optional<Member> getWithRoles(String mid);

}
