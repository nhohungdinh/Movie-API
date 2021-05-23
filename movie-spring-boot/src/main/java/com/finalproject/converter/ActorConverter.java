package com.finalproject.converter;

import org.springframework.stereotype.Component;

import com.finalproject.dto.ActorDTO;
import com.finalproject.entity.ActorEntity;

@Component
public class ActorConverter {
	public ActorEntity toEntity(ActorDTO dto) {
		ActorEntity entity = new ActorEntity();
		entity.setBiography(dto.getBiography());
		entity.setBirthOfDate(dto.getBirthOfDate());
		entity.setGender(dto.getGender());
		entity.setName(dto.getName());
		entity.setProfilePathUrl(dto.getProfilePathUrl());
		return entity;
	}
	
	public ActorDTO toDTO(ActorEntity entity) {
		ActorDTO dto = new ActorDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setBiography(entity.getBiography());
		dto.setBirthOfDate(entity.getBirthOfDate());
		dto.setGender(entity.getGender());
		dto.setName(entity.getName());
		dto.setProfilePathUrl(entity.getProfilePathUrl());
		return dto;
	}
	
	public ActorEntity toEntity(ActorDTO dto, ActorEntity entity) {
		entity.setBiography(dto.getBiography());
		entity.setBirthOfDate(dto.getBirthOfDate());
		entity.setGender(dto.getGender());
		entity.setName(dto.getName());
		entity.setProfilePathUrl(dto.getProfilePathUrl());
		return entity;
	}
}
