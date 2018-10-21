package com.yaleshop.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Chitiethoadon {
	@EmbeddedId
	Chitiethoadonid chitiethoadonid;
	
	private int soluong;
	
	private int giatien;

	public Chitiethoadonid getChitiethoadonid() {
		return chitiethoadonid;
	}

	public void setChitiethoadonid(Chitiethoadonid chitiethoadonid) {
		this.chitiethoadonid = chitiethoadonid;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getGiatien() {
		return giatien;
	}

	public void setGiatien(int giatien) {
		this.giatien = giatien;
	}
	
	
}
