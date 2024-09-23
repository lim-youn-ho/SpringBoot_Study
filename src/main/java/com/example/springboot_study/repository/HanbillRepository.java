package com.example.springboot_study.repository;

import com.example.springboot_study.domain.Article;
import com.example.springboot_study.domain.Hanbill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HanbillRepository extends JpaRepository<Hanbill,Long> {

}
