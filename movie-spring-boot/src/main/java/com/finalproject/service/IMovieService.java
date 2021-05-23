package com.finalproject.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.finalproject.dto.MovieDTO;

public interface IMovieService {
	MovieDTO save(MovieDTO movieDTO);
	void delete(long[] ids);
	List<MovieDTO> findAll(Pageable pageable);
	List<MovieDTO> findAllMovieByGenre(long id);
	List<MovieDTO> findAllMovieByActorName(String actorName);
	List<MovieDTO> findAllMovieByTitle(String title);
	MovieDTO findMovieById(long id);
//	List<ActorDTO> findAllMovieByActor(String actorName);
	int totalItem();
}
