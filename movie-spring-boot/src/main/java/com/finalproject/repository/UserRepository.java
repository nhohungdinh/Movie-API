package com.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserName(String username);
}
