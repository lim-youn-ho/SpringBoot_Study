package com.example.springboot_study.controller;

import com.example.springboot_study.entity.Member;
import com.example.springboot_study.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest//테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc//MockMvc 생성 및 자동 구성
class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }
    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers : 아티클 조회에 성공")
    @Test
    public void getAllMembers() throws Exception {

        //given
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L,"홍길동"));

        //when
        final ResultActions result = mockMvc.perform(get(url) // .perform 메서드는 요청을 전송하는 메서드
                .accept(MediaType.APPLICATION_JSON)); //요청을 보낼 때 무슨 타입으로 응답을 받을지 결정 메서드

        //then
        result .andExpect(status().isOk())  //응답을 검증 .isOk 는 200값 인지 확인메서드
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));




    }

}