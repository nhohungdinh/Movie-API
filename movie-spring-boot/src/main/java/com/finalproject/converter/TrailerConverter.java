package com.finalproject.converter;

import org.springframework.stereotype.Component;

import com.finalproject.dto.TrailerDTO;
import com.finalproject.entity.TrailerEntity;

@Component
public class TrailerConverter {
	public TrailerEntity toEntity(TrailerDTO dto) {
		TrailerEntity entity = new TrailerEntity();
		entity.setTrailerUrl(dto.getTrailerUrl());
		entity.setTrailerName(dto.getTrailerName());
		return entity;
	}
	
	public TrailerDTO toDTO(TrailerEntity entity) {
		TrailerDTO dto = new TrailerDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setTrailerUrl(entity.getTrailerUrl());
		dto.setTrailerName(entity.getTrailerName());
		return dto;
	}
	
	public TrailerEntity toEntity(TrailerDTO dto, TrailerEntity entity) {
		entity.setTrailerUrl(dto.getTrailerUrl());
		entity.setTrailerName(dto.getTrailerName());
		return entity;
	}
}
