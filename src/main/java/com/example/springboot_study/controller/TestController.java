package com.example.springboot_study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //java17에서 변한점
    record Item(String name, int price){
        //이렇게 record 설정해 두면 private final 로 정의됨
    }
    Item juice = new Item("juice",3000);

    @GetMapping("/test")
    public Integer test(){



        return juice.price(); //3000 리턴

    }


}
