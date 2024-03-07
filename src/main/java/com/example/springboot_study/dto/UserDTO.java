package com.example.springboot_study.dto;

import com.example.springboot_study.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private String name;

    private String email;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .email(email)
                .build();
    }

}
