package com.example.springboot_study.controller;

import com.example.springboot_study.dto.UserDTO;
import com.example.springboot_study.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Component // UserController클래스 를 빈으로 등록해주는 어노테이션
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping(value = "/api/saveUser")
    public Long saveUser(@RequestBody UserDTO userDto){

        return userService.save(userDto);
    }



}
