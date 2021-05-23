package com.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.entity.TrailerEntity;

public interface TrailerRepository extends JpaRepository<TrailerEntity, Long> {
	List<TrailerEntity> findByMovie_Id(long id);
	TrailerEntity findOneByTrailerUrl(String url);
}
