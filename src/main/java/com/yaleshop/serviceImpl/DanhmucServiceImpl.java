package com.yaleshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaleshop.entity.Danhmucsanpham;
import com.yaleshop.repository.DanhmucRepository;
import com.yaleshop.service.DanhmucService;

@Service("danhmucService")
public class DanhmucServiceImpl implements DanhmucService{
	
	@Autowired
	private DanhmucRepository danhmucRepository;
	
	public List<Danhmucsanpham> danhsachdanhmuc() {
		return danhmucRepository.danhsachdanhmuc();
	}

}
