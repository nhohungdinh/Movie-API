package com.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
	MovieEntity findByGenre_Id(long genreId);
	List<MovieEntity> findByActor_Id(long actorId);
	List<MovieEntity> findByTitle(String title);
}
