package com.example.springboot_study.repository;

import com.example.springboot_study.entity.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    //조회
    @Sql("/insert-members.sql")
    @Test
    void getMemberByName(){

        Member member = memberRepository.findByName("C").get();

        assertThat(member.getId()).isEqualTo(3);

    }

    //저장
    @Test
    void saveMember(){

        Member member = new Member(1L,"A");

        memberRepository.save(member);

        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");

    }

    //삭제
    @Sql("/insert-members.sql")
    @Test
    @AfterEach//deleteAll 사용시 AfterEach어노테이션 사용
    void deleteMemberById(){
        //단건
        memberRepository.deleteById(2L);
        assertThat(memberRepository.findById(2L).isEmpty()).isTrue();

        //전체(테스트 코드에서만 실행)
        memberRepository.deleteAll();
        assertThat(memberRepository.findAll().size()).isZero();

    }

    //업데이트
    @Sql("/insert-members.sql")
    void update(){
        Member member = memberRepository.findById(2L).get();

        member.changeName("BC");

        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");

    }



}