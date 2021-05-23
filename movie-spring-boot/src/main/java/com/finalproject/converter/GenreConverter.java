package com.finalproject.converter;

import org.springframework.stereotype.Component;

import com.finalproject.dto.GenreDTO;
import com.finalproject.entity.GenreEntity;

@Component
public class GenreConverter {
	public GenreDTO toDTO(GenreEntity entity) {
		GenreDTO dto = new GenreDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		return dto;
	}
}
