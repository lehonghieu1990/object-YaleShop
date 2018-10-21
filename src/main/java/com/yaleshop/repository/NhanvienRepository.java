package com.yaleshop.repository;

import com.yaleshop.entity.Nhanvien;

public interface NhanvienRepository {
	public boolean getNhanvien(String email, String matkhau);
	public boolean saveNhanvien(Nhanvien nhanvien);
}
