package com.example.springboot_study.controller;

import com.example.springboot_study.dto.ArticleResponse;
import com.example.springboot_study.service.HanbillApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class HanbillApiController {
    HanbillApiService hanbillApiService;
    @GetMapping("/api/getArticles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){

        List<ArticleResponse> articles = hanbillApiService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();


        return ResponseEntity.ok()
                .body(articles);

    }


}
