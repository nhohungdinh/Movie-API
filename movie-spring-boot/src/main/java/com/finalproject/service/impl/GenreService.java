package com.finalproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.converter.GenreConverter;
import com.finalproject.dto.GenreDTO;
import com.finalproject.entity.GenreEntity;
import com.finalproject.repository.GenreRepository;
import com.finalproject.service.IGenreService;

@Service
public class GenreService implements IGenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private GenreConverter genreConverter;
	
	@Override
	public List<GenreDTO> findAll() {
		List<GenreDTO> result = new ArrayList<>();
		List<GenreEntity> entities = genreRepository.findAll();
		for(GenreEntity item : entities) {
			GenreDTO dto = genreConverter.toDTO(item);
			result.add(dto);
		}
		return result;
	}

	@Override
	public GenreDTO findByGenreId(long id) {
		GenreEntity entity = genreRepository.findOne(id);
		GenreDTO dto = genreConverter.toDTO(entity);
		return dto;
	}

}
