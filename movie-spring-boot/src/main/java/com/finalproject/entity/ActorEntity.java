package com.finalproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class ActorEntity extends BaseEntity {
	@Column
	private String name;
	
	@Column
	private String gender;
	
	@Column
	private String profilePathUrl;
	
	@Column
	private String birthOfDate;
	
	@Column
	private String biography;
	
	@ManyToMany(mappedBy = "actor")
	private List<MovieEntity> movies = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfilePathUrl() {
		return profilePathUrl;
	}

	public void setProfilePathUrl(String profilePathUrl) {
		this.profilePathUrl = profilePathUrl;
	}

	public String getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(String birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieEntity> movies) {
		this.movies = movies;
	}
}
