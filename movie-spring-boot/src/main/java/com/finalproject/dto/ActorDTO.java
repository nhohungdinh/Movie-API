package com.finalproject.dto;

public class ActorDTO extends BaseDTO<ActorDTO> {
	
	private String name;
	private String gender;
	private String profilePathUrl;
	private String birthOfDate;
	private String biography;
	
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
	
}
