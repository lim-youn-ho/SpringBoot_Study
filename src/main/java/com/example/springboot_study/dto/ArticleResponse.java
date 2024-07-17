package com.example.springboot_study.dto;

import com.example.springboot_study.domain.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {

    private final  String title;
    private final  String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }



}
