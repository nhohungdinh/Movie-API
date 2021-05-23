package com.finalproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class MovieEntity extends BaseEntity {
	@Column
	private String overview;
	
	@Column
	private String posterPath;
	
	@Column
	private String releaseDate;
	
	@Column
	private String title;
	
	@Column
	private String videoUrl;
	
	@Column
	private Float voteAverage;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private GenreEntity genre;
	
	@ManyToMany
	@JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private List<ActorEntity> actor = new ArrayList<>();
	
	@OneToMany(mappedBy = "movie", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	private List<TrailerEntity> trailers = new ArrayList<>();

	public List<ActorEntity> getActor() {
		return actor;
	}

	public void setActor(List<ActorEntity> actor) {
		this.actor = actor;
	}

	public List<TrailerEntity> getTrailers() {
		return trailers;
	}

	public void setTrailers(List<TrailerEntity> trailers) {
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

	public GenreEntity getGenre() {
		return genre;
	}

	public void setGenre(GenreEntity genre) {
		this.genre = genre;
	}


}
