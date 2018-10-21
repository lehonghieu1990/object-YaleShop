package com.yaleshop.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Chitiethoadonid implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idhoadon;
	
	private int idchitietsanpham;

	public int getIdhoadon() {
		return idhoadon;
	}

	public void setIdhoadon(int idhoadon) {
		this.idhoadon = idhoadon;
	}

	public int getIdchitietsanpham() {
		return idchitietsanpham;
	}

	public void setIdchitietsanpham(int idchitietsanpham) {
		this.idchitietsanpham = idchitietsanpham;
	}
	
	
}
