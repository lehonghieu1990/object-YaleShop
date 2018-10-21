package com.yaleshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yaleshop.entity.Sizesanpham;
import com.yaleshop.repository.SizesanphamRepository;
import com.yaleshop.service.SizesanphamService;

@Service("sizesanphamService")
public class SizesanphamServiceImpl implements SizesanphamService{
	@Autowired
	private SizesanphamRepository sizesanphamRepository;

	public List<Sizesanpham> danhsachSizesanpham() {
		return sizesanphamRepository.danhsachSizesanpham();

	}
	
	
}
