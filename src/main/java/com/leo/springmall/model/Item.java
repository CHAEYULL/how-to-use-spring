package com.leo.springmall.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

@Entity
@ToString
public class Item {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer price;
	
	
	
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	
}
