package com.example.springboot_study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private ObjectMapper objectMapper; //객체,json간의 변환처리 objectMapper
    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @DisplayName("quiz():GET /quiz?code=1 응답코드201,본문은 Created!리턴")
    @Test
    public void getQuiz1() throws Exception{

        //given
        final String url = "/quiz";

        //when
        final ResultActions result = mockMvc.perform(get(url)
                .param("code","1")
        );

        //then
        result .andExpect(status().isCreated())
                .andExpect(content().string("Created!"));

    }

    @DisplayName("quiz():POST /quiz?code=13 응답코드200,본문은 ok!리턴")
    @Test
    public void postQuiz13() throws Exception{

        //given
        final String url = "/quiz";

        //when
        final ResultActions result = mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(objectMapper.writeValueAsString(new QuizController.Code(13)))
        );

        //then
        result .andExpect(status().isOk())
                .andExpect(content().string("ok!"));

    }

}