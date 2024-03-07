package com.example.springboot_study.repository;

import com.example.springboot_study.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends CrudRepository <UserEntity,Long>{
}
