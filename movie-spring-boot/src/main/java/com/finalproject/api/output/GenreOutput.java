package com.finalproject.api.output;

import java.util.ArrayList;
import java.util.List;

import com.finalproject.dto.GenreDTO;

public class GenreOutput {
	private List<GenreDTO> genreResult = new ArrayList<>();

	public List<GenreDTO> getGenreResult() {
		return genreResult;
	}

	public void setGenreResult(List<GenreDTO> genreResult) {
		this.genreResult = genreResult;
	}
	
}
