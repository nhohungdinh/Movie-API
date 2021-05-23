package com.finalproject.dto;

public class TrailerDTO extends BaseDTO<TrailerDTO> {

	private String trailerUrl;
	private String trailerName;
	private Long movieId;
	public String getTrailerUrl() {
		return trailerUrl;
	}
	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getTrailerName() {
		return trailerName;
	}
	public void setTrailerName(String trailerName) {
		this.trailerName = trailerName;
	}
	
	
}
