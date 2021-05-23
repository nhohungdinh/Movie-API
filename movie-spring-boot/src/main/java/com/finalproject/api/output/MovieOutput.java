package com.finalproject.api.output;

import java.util.ArrayList;
import java.util.List;

import com.finalproject.dto.MovieDTO;

public class MovieOutput {
	private List<MovieDTO> movieResult = new ArrayList<>();

	public List<MovieDTO> getMovieResult() {
		return movieResult;
	}

	public void setMovieResult(List<MovieDTO> movieResult) {
		this.movieResult = movieResult;
	}
}
