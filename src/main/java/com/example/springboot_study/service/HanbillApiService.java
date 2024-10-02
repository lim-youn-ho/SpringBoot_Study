package com.example.springboot_study.service;

import com.example.springboot_study.domain.Article;
import com.example.springboot_study.repository.HanbillRepository;

import java.util.List;

public class HanbillApiService {
    private  final HanbillRepository hanbillRepository;
    //repository 부분 수정
    public HanbillApiService(HanbillRepository hanbillRepository) {
        this.hanbillRepository = hanbillRepository;
    }

    public List<Article> findAll(){
        return null;
    }
}
