package com.example.springboot_study.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 자동으로1씩 증가
    @Column(name = "id" , updatable = false)
    private Long id;

    @Column(name = "name" , nullable = false)
    private  String name;

    public void changeName(String name){
        this.name = name;
    }
}
