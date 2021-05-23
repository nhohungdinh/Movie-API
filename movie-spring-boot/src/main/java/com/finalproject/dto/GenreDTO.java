package com.finalproject.dto;

import java.util.ArrayList;
import java.util.List;

public class GenreDTO extends BaseDTO<GenreDTO> {
	
	private String name;
	private String code;
	private List<MovieDTO> movies = new ArrayList<>();
	public List<MovieDTO> getMovies() {
		return movies;
	}
	public void setMovies(List<MovieDTO> movies) {
		this.movies = movies;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
