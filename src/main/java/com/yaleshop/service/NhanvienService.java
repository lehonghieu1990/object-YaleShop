package com.yaleshop.service;

import com.yaleshop.entity.Nhanvien;


public interface NhanvienService {
	public boolean kiemtradangnhap(String email, String matkhau);
	public boolean saveNhanvien(Nhanvien nhanvien);

}
