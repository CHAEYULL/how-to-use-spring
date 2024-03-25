package com.leo.springmall.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String displayName;
	
	@Column(nullable = false)
	private String password;
	
	
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getDisplayName() {
		return displayName;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
