package com.example.springboot_study.controller;

import com.example.springboot_study.domain.Article;
import com.example.springboot_study.dto.AddArticleRequest;
import com.example.springboot_study.dto.ArticleResponse;
import com.example.springboot_study.dto.UpdateArticleRequest;
import com.example.springboot_study.service.BlogService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // http response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {



    private  final BlogService blogService;
    //http메서드가 post일 때 전달받은 url과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){//@RequestBody로 요청 본문 값 매칭

        Article savedArticle = blogService.save(request);

                //요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(savedArticle);

    }



    @GetMapping("/api/getArticles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){

        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();


        return ResponseEntity.ok()
                .body(articles);

    }

    @GetMapping("/api/articles/{id}") //url 경로에서 값 추출
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findById(id);
        //특정 글만 조회해오기
        return ResponseEntity.ok()
                .body(new ArticleResponse(article));

    }

    @DeleteMapping("/api/delArticles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();

    }
    //특정 글 수정
    @PutMapping("/api/updArticles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request){
        Article updateArticle = blogService.update(id,request);

        return ResponseEntity.ok()
                .body(updateArticle);

    }


}
