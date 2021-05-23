package com.finalproject.converter;

import org.springframework.stereotype.Component;

import com.finalproject.dto.MovieDTO;
import com.finalproject.entity.MovieEntity;

@Component
public class MovieConverter {
	public MovieEntity toEntity(MovieDTO dto) {
		MovieEntity entity = new MovieEntity();
		entity.setOverview(dto.getOverview());
		entity.setPosterPath(dto.getPosterPath());
		entity.setReleaseDate(dto.getReleaseDate());
		entity.setTitle(dto.getTitle());
		entity.setVideoUrl(dto.getVideoUrl());
		entity.setVoteAverage(dto.getVoteAverage());
		return entity;
	}
	
	public MovieDTO toDTO(MovieEntity entity) {
		MovieDTO dto = new MovieDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setOverview(entity.getOverview());
		dto.setPosterPath(entity.getPosterPath());
		dto.setReleaseDate(entity.getReleaseDate());
		dto.setTitle(entity.getTitle());
		dto.setVideoUrl(entity.getVideoUrl());
		dto.setVoteAverage(entity.getVoteAverage());
		return dto;
	}
	
	public MovieEntity toEntity(MovieDTO dto, MovieEntity entity) {
		entity.setOverview(dto.getOverview());
		entity.setPosterPath(dto.getPosterPath());
		entity.setReleaseDate(dto.getReleaseDate());
		entity.setTitle(dto.getTitle());
		entity.setVideoUrl(dto.getVideoUrl());
		entity.setVoteAverage(dto.getVoteAverage());
		return entity;
	}
}
