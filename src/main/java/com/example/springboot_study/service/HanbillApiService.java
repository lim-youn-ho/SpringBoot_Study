package com.example.springboot_study.service;

import com.example.springboot_study.domain.Hanbill;
import com.example.springboot_study.repository.HanbillRepository;

import java.util.List;

public class HanbillApiService {
    private  final HanbillRepository hanbillRepository;

    public HanbillApiService(HanbillRepository hanbillRepository) {
        this.hanbillRepository = hanbillRepository;
    }

    public List<Hanbill> findAll(){
        return hanbillRepository.findAll();
    }
}
