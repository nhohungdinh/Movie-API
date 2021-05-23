package com.finalproject.service;

import java.util.List;

import com.finalproject.dto.ActorDTO;

public interface IActorService {
	ActorDTO save(ActorDTO actorDTO);
	void delete(long[] ids);
	List<ActorDTO> findAllActorByName(String name);
	List<ActorDTO> findAll();
	ActorDTO findActorById(long id);
	List<ActorDTO> findAllActorByMovieId(long id);
	int totalItem();
}
