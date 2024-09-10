package com.example.springboot_study.service;

import com.example.springboot_study.domain.Article;
import com.example.springboot_study.repository.BlogRepository;

import java.util.List;

public class HanbillApiService {
    private  final BlogRepository blogRepository;

    public HanbillApiService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }
}