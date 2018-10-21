package com.yaleshop.service;

import java.util.List;

import com.yaleshop.entity.Sanpham;

public interface SanphamService {
	public List<Sanpham> danhsachsanpham();
	public List<Sanpham> danhsachsanphamPhantrag(int positon, int spMax);
	public Sanpham getSanpham(int id);
	public int saveSanpham(Sanpham sanpham);
}
