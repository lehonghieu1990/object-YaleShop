package com.yaleshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Chitietsanpham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="idsanpham")
//	private Sanpham sanpham;
	
	@OneToOne
	@JoinColumn(name="idsizesanpham")
	private Sizesanpham sizesanpham;
	
	@OneToOne
	@JoinColumn(name="idmausanpham")
	private Mausanpham mausanpham;
	
	private int soluong;
	
	private String ngaynhap;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public Sanpham getSanpham() {
//		return sanpham;
//	}
//	public void setSanpham(Sanpham sanpham) {
//		this.sanpham = sanpham;
//	}
	public Sizesanpham getSizesanpham() {
		return sizesanpham;
	}
	public void setSizesanpham(Sizesanpham sizesanpham) {
		this.sizesanpham = sizesanpham;
	}
	public Mausanpham getMausanpham() {
		return mausanpham;
	}
	public void setMausanpham(Mausanpham mausanpham) {
		this.mausanpham = mausanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	
	
}
