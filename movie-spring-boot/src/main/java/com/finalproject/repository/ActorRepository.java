package com.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.entity.ActorEntity;

public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
	ActorEntity findById(Long id);
	List<ActorEntity> findAllByName(String name);
}
