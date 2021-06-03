package com.finalproject.dto;

import java.util.List;

public class SignupRequest {
	
	private String username;
	private String email;
	private String password;
	private List<String> role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> role) {
		this.role = role;
	}
	public SignupRequest(String username, String email, String password, List<String> role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public SignupRequest() {
		super();
	}
	
	
	
}
