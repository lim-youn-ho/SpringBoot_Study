package com.example.springboot_study.controller;

import com.example.springboot_study.domain.Article;
import com.example.springboot_study.dto.ArticleListViewResponse;
import com.example.springboot_study.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){

        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles",articles);

        return "articleList";// resource/templates/articleList.html 찾게 리턴

    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id , Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleListViewResponse(article));

        return "article";
    }

}
