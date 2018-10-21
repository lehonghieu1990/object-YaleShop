package com.yaleshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yaleshop.entity.Chitietsanpham;
import com.yaleshop.entity.Danhmucsanpham;
import com.yaleshop.entity.Giohang;
import com.yaleshop.entity.Sanpham;
import com.yaleshop.service.DanhmucService;
import com.yaleshop.service.SanphamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")
public class ChitietsanphamController {
	
	@Autowired
	private SanphamService sanphamService;
	
	@Autowired
	private DanhmucService danhmucService;
	
	@GetMapping("/{masanpham}")
	public String chitiet(HttpSession httpSession,@PathVariable int masanpham, ModelMap modelMap) {

		if (null != httpSession.getAttribute("giohang")) {
			List<Giohang> listGiohang = (List<Giohang>) httpSession.getAttribute("giohang");
			int soluong = listGiohang.size();
			modelMap.addAttribute("soluongAll", soluong);
		}
		
		List<Danhmucsanpham> listDanhmucsanpham = danhmucService.danhsachdanhmuc();
		modelMap.addAttribute("listDanhmucsanpham", listDanhmucsanpham);
		Sanpham sanpham = sanphamService.getSanpham(masanpham);
		modelMap.addAttribute("sanpham", sanpham);
		
		return "chitiet";
	}
	
	
}
