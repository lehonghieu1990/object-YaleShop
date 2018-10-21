package com.yaleshop.repository;

import java.util.List;

import com.yaleshop.entity.Sanpham;

public interface SanphamRepository {
	public List<Sanpham> danhsachsanpham();
	public List<Sanpham> danhsachsanphamPhantrag(int positon, int spMax);
	public Sanpham getSanpham(int id);
	public int saveSanpham(Sanpham sanpham);
 }
