package com.example.springboot_study.controller;

import com.example.springboot_study.dto.UserDTO;
import com.example.springboot_study.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserServiceImpl userService;
    @PostMapping(value = "/saveUser")
    public Long saveUser(@RequestBody UserDTO userDto){
        return userService.save(userDto);
    }


}
