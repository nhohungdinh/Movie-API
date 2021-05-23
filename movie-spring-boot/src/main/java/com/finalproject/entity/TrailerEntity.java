package com.finalproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trailer")
public class TrailerEntity extends BaseEntity {
	@Column
	private String trailerUrl;
	
	@Column
	private String trailerName;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private MovieEntity movie;

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public String getTrailerName() {
		return trailerName;
	}

	public void setTrailerName(String trailerName) {
		this.trailerName = trailerName;
	}
	
}
