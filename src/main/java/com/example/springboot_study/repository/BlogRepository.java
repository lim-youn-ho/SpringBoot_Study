package com.example.springboot_study.repository;

import com.example.springboot_study.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
