package com.example.springboot_study.service;

import com.example.springboot_study.entity.Member;
import com.example.springboot_study.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMembers(){

        return memberRepository.findAll(); //멤버목록

    }
    

}
