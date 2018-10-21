package com.yaleshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaleshop.entity.Mausanpham;
import com.yaleshop.repository.MausanphamRepository;
import com.yaleshop.service.MausanphamService;

@Service("mausanphamService")
public class MausanphamServiceImpl implements MausanphamService{
	
	@Autowired
	private MausanphamRepository mausanphamRepository;
	
	public List<Mausanpham> danhsachMausanpham(){
		return mausanphamRepository.danhsachMausanpham();
	}
}
