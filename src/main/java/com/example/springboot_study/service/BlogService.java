package com.example.springboot_study.service;

import com.example.springboot_study.domain.Article;
import com.example.springboot_study.dto.AddArticleRequest;
import com.example.springboot_study.dto.UpdateArticleRequest;
import com.example.springboot_study.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor//final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service//빈으로 등록
public class BlogService {
    private  final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }
    //블로그 글 단건 조회
    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //블로그 글 단건 삭제
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found :" + id));

        article.update(request.getTitle(), request.getContent());

        return article;

    }


}
