package com.finalproject.service;

import java.util.List;

import com.finalproject.dto.GenreDTO;

public interface IGenreService {
	List<GenreDTO> findAll();
	GenreDTO findByGenreId(long id);
}
