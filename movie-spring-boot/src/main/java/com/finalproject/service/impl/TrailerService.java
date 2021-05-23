package com.finalproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.converter.TrailerConverter;
import com.finalproject.dto.TrailerDTO;
import com.finalproject.entity.MovieEntity;
import com.finalproject.entity.TrailerEntity;
import com.finalproject.repository.MovieRepository;
import com.finalproject.repository.TrailerRepository;
import com.finalproject.service.ITrailerService;

@Service
public class TrailerService implements ITrailerService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private TrailerConverter trailerConverter;
	
	@Autowired
	private TrailerRepository trailerRepository;
	
	@Override
	public TrailerDTO save(TrailerDTO trailerDTO) {
		TrailerEntity trailerEntity = new TrailerEntity();
		if (trailerDTO.getId() != null) {
			TrailerEntity oldEntity = trailerRepository.findOne(trailerDTO.getId());
			trailerEntity = trailerConverter.toEntity(trailerDTO, oldEntity);
		}else {
			trailerEntity = trailerConverter.toEntity(trailerDTO);
		}
		MovieEntity movieEntity = movieRepository.findOne(trailerDTO.getMovieId());
		trailerEntity.setMovie(movieEntity);
		trailerRepository.save(trailerEntity);
		return trailerConverter.toDTO(trailerEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item : ids) {
			trailerRepository.delete(item);
		}
	}

	@Override
	public List<TrailerDTO> findAllTrailerByMovie(long id) {
		List<TrailerDTO> results = new ArrayList<>();
		MovieEntity movieEntity = movieRepository.findOne(id);
		List<TrailerEntity> entities = movieEntity.getTrailers();
		for (TrailerEntity trailer : entities) {
			TrailerDTO trailerDTO = trailerConverter.toDTO(trailer);
			results.add(trailerDTO);
		}
		return results;
	}
	
}
