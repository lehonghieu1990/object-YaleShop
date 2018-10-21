package com.yaleshop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaleshop.repository.SanphamRepository;
import com.yaleshop.service.PageService;

@Service("pageService")
public class PageServiceImpl implements PageService{
	
	@Autowired
	private SanphamRepository sanphamRepository;
	
	public int pageAll(int spAll, int spmax) {
		
		int kt = spAll%spmax;
		int pageAll = spAll/spmax;
		if(spAll <= spmax) {
			return 1;
		}else if(kt != 0){
			return pageAll + 1;
		}
		
		return pageAll;
	}
	
	public int positon(int page, int spmax) {
		return (page * spmax) - spmax;
	}
	

}
