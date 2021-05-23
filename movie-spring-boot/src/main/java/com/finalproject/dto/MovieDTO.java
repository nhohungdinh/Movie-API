package com.finalproject.dto;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO extends BaseDTO<MovieDTO> {
	
	private String overview;
	private String posterPath;
	private String releaseDate;
	private String title;
	private String videoUrl;
	private Float voteAverage;
	private String genreCode;
	private List<ActorDTO> actors = new ArrayList<>();
	private List<TrailerDTO> trailers = new ArrayList<>();
	public List<ActorDTO> getActors() {
		return actors;
	}
	public void setActors(List<ActorDTO> actors) {
		this.actors = actors;
	}
	public List<TrailerDTO> getTrailers() {
		return trailers;
	}
	public void setTrailers(List<TrailerDTO> trailers) {
		this.trailers = trailers;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getPosterPath() {
		return posterPath;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public Float getVoteAverage() {
		return voteAverage;
	}
	public void setVoteAverage(Float voteAverage) {
		this.voteAverage = voteAverage;
	}
	public String getGenreCode() {
		return genreCode;
	}
	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}
}
