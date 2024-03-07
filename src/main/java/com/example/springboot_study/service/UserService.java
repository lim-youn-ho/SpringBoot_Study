package com.example.springboot_study.service;

import com.example.springboot_study.dto.UserDTO;
import com.example.springboot_study.entity.UserEntity;

public interface UserService {


    default UserEntity dtoToEntity(UserDTO dto){
        UserEntity entity = UserEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
        return entity;
    }
}
