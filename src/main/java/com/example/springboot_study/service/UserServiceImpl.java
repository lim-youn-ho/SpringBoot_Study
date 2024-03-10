package com.example.springboot_study.service;

import com.example.springboot_study.dto.UserDTO;
import com.example.springboot_study.entity.UserEntity;
import com.example.springboot_study.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserDTO userDto) {
        UserEntity entity = dtoToEntity(userDto);
        userRepository.save(entity);
        return entity.getId();
    }
}
