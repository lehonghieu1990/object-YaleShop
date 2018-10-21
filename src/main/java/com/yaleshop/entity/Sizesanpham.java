package com.yaleshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sizesanpham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tenkichthuoc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenkichthuoc() {
		return tenkichthuoc;
	}

	public void setTenkichthuoc(String tenkichthuoc) {
		this.tenkichthuoc = tenkichthuoc;
	}
	
	
}
