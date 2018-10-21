package com.yaleshop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaleshop.entity.Nhanvien;
import com.yaleshop.repository.NhanvienRepository;
import com.yaleshop.service.NhanvienService;

@Service("nhanvienService")
public class NhanvienServiceImpl implements NhanvienService{
	@Autowired
	private NhanvienRepository nhanvienRepository;
	
	public boolean kiemtradangnhap(String email, String matkhau) {
		return nhanvienRepository.getNhanvien(email, matkhau);
	}

	public boolean saveNhanvien(Nhanvien nhanvien) {
		return nhanvienRepository.saveNhanvien(nhanvien);
	}
}
