package com.yaleshop.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sanpham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="iddanhmucsanpham")
	private Danhmucsanpham danhmucsanpham;
	
	private String tensanpham;
	
	private String giatien;
	
	private String mota;
	
	private String hinhsanpham;
	
	private String gianhcho;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="idsanpham")
	private Set<Chitietsanpham> chitietsanpham;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Chitietkhuyenmai",
	joinColumns= {@JoinColumn(name="idsanpham", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="idkhuyenmai",referencedColumnName="id")})
	private Set<Khuyenmai> danhsachkhuyenmai;
	
	public String getGianhcho() {
		return gianhcho;
	}

	public void setGianhcho(String gianhcho) {
		this.gianhcho = gianhcho;
	}

	public Set<Khuyenmai> getDanhsachkhuyenmai() {
		return danhsachkhuyenmai;
	}

	public void setDanhsachkhuyenmai(Set<Khuyenmai> danhsachkhuyenmai) {
		this.danhsachkhuyenmai = danhsachkhuyenmai;
	}

	public Set<Chitietsanpham> getChitietsanpham() {
		return chitietsanpham;
	}

	public void setChitietsanpham(Set<Chitietsanpham> chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}

	public Sanpham() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Danhmucsanpham getDanhmucsanpham() {
		return danhmucsanpham;
	}

	public void setDanhmucsanpham(Danhmucsanpham danhmucsanpham) {
		this.danhmucsanpham = danhmucsanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhsanpham() {
		return hinhsanpham;
	}

	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}
	
	
}
