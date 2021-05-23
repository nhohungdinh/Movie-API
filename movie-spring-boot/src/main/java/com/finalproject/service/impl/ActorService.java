package com.finalproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.converter.ActorConverter;
import com.finalproject.dto.ActorDTO;
import com.finalproject.entity.ActorEntity;
import com.finalproject.entity.MovieEntity;
import com.finalproject.repository.ActorRepository;
import com.finalproject.repository.MovieRepository;
import com.finalproject.service.IActorService;

@Service
public class ActorService implements IActorService {

	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private ActorConverter actorConverter;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public ActorDTO save(ActorDTO actorDTO) {
		ActorEntity actorEntity = new ActorEntity();
		if (actorDTO.getId() != null) {
			ActorEntity oldEntity = actorRepository.findOne(actorDTO.getId());
			actorEntity = actorConverter.toEntity(actorDTO, oldEntity);
		}else {
			actorEntity = actorConverter.toEntity(actorDTO);
		}
		actorRepository.save(actorEntity);
		return actorConverter.toDTO(actorEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item : ids) {
			actorRepository.delete(item);;
		}
	}

	@Override
	public List<ActorDTO> findAllActorByName(String name) {
		List<ActorEntity> actorEntities = actorRepository.findAllByName(name);
		List<ActorDTO> results = new ArrayList<>();
		for(ActorEntity item : actorEntities) {
			ActorDTO actorDTO = actorConverter.toDTO(item);
			results.add(actorDTO);
		}
		return results;
	}

	@Override
	public List<ActorDTO> findAll() {
		List<ActorEntity> actorEntities = actorRepository.findAll();
		List<ActorDTO> results = new ArrayList<>();
		for(ActorEntity item : actorEntities) {
			ActorDTO actorDTO = actorConverter.toDTO(item);
			results.add(actorDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ActorDTO findActorById(long id) {
		ActorEntity actorEntity = actorRepository.findOne(id);
		ActorDTO actorDTO = actorConverter.toDTO(actorEntity);
		return actorDTO;
	}

	@Override
	public List<ActorDTO> findAllActorByMovieId(long id) {
		MovieEntity movieEntity = movieRepository.findOne(id);
		List<ActorEntity> actorEntities = movieEntity.getActor();
		List<ActorDTO> actorDTOs = new ArrayList<>();
		for(ActorEntity actorEntity : actorEntities) {
			ActorDTO actorDTO = actorConverter.toDTO(actorEntity);
			actorDTOs.add(actorDTO);
		}
		return actorDTOs;
	}

}
