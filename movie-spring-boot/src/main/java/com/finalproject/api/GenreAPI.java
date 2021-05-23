package com.finalproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.api.output.GenreOutput;
import com.finalproject.dto.GenreDTO;
import com.finalproject.service.IGenreService;

@RestController
public class GenreAPI {

	@Autowired
	private IGenreService genreService;
	
	@GetMapping(value = "/genre")
	public GenreOutput showAllGenre() {
		GenreOutput result = new GenreOutput();
		result.setGenreResult(genreService.findAll());
		return result;
	}
	
	@GetMapping(value = "genre/{id}")
	public GenreDTO showGenreByGenreId(@PathVariable long id) {
		return genreService.findByGenreId(id);
	}
}
