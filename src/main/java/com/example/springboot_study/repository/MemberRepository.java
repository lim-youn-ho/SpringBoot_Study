package com.example.springboot_study.repository;

import com.example.springboot_study.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    //복잡한 쿼리 사용할 경우
    @Query("select m from Member m where m.name = ?1")
    Optional<Member> findByName(String name);

}
