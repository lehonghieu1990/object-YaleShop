package com.yaleshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaleshop.entity.Sanpham;
import com.yaleshop.repository.SanphamRepository;
import com.yaleshop.service.SanphamService;

@Repository("sanphamService")
public class SanphamServiceImpl implements SanphamService{
	
	@Autowired
	private SanphamRepository SanphamRepository;
	
	public List<Sanpham> danhsachsanpham() {
		return SanphamRepository.danhsachsanpham();
	}
	
	public List<Sanpham> danhsachsanphamPhantrag(int positon, int spMax) {
		return SanphamRepository.danhsachsanphamPhantrag(positon, spMax);
	}

	public Sanpham getSanpham(int id) {
		return SanphamRepository.getSanpham(id);
	}

	public int saveSanpham(Sanpham sanpham) {
		return SanphamRepository.saveSanpham(sanpham);
	}

	
}
