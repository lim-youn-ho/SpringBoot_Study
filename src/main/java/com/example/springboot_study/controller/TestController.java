package com.example.springboot_study.controller;

import com.example.springboot_study.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.List;

@RestController
public class TestController {

   @Autowired
    TestService testService;

    @GetMapping("/test")
    public List<Member> test(){

    List<Member> members = testService.getAllMembers();


        return members;

    }


}
