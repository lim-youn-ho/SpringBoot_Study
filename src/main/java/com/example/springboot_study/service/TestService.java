package com.example.springboot_study.service;

import org.hibernate.metamodel.internal.MemberResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class TestService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll(); //멤버목록
    }
}
