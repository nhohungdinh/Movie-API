package com.finalproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.finalproject.common.ERole;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users = new ArrayList<>();

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public RoleEntity(ERole name, List<UserEntity> users) {
		super();
		this.name = name;
		this.users = users;
	}

	public RoleEntity() {
		
	}
	
	
}
