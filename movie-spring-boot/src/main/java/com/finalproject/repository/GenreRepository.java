package com.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.entity.GenreEntity;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
	GenreEntity findOneByCode(String code);
	GenreEntity findOneByName(String name);
}
