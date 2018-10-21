package com.yaleshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yaleshop.entity.Giohang;
import com.yaleshop.service.NhanvienService;

@Controller
@RequestMapping("api/")
@SessionAttributes({ "email", "giohang" })
public class ApiController {
	
	
	private int count;

	@Autowired
	private NhanvienService nhanvienService;

	@PostMapping("kiemtradangnhap")
	@ResponseBody
	public String kiemtradangnhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap) {
		boolean boo = nhanvienService.kiemtradangnhap(email, matkhau);
		modelMap.addAttribute("email", email);
		modelMap.addAttribute("matkhau", matkhau);
		System.out.println(boo);
		return "" + boo;
	}

	@PostMapping("themgiohang")
	@ResponseBody
	public String themgiohang(HttpSession httpSession, @RequestParam int masanpham, @RequestParam String tensanpham,
			@RequestParam int mamau, @RequestParam String tenmau, @RequestParam int masize,
			@RequestParam String tensize, @RequestParam int soluong, @RequestParam String giatien) {

		if (null == httpSession.getAttribute("giohang")) {
			System.out.println("gio hang khong ton tai");
			List<Giohang> listGiohang = new ArrayList();
			Giohang giohang = new Giohang();
			giohang.setMasanpham(masanpham);
			giohang.setTensanpham(tensanpham);
			giohang.setMamau(mamau);
			giohang.setTenmau(tenmau);
			giohang.setMasize(masize);
			giohang.setTensize(tensize);
			giohang.setSoluong(1);
			giohang.setGiatien(giatien);
			listGiohang.add(giohang);
			httpSession.setAttribute("giohang", listGiohang);
		} else {
			List<Giohang> listGiohang = (List<Giohang>) httpSession.getAttribute("giohang");
			int vitri = kiemtraSanpham(listGiohang, masanpham, mamau, masize);
			
			if (vitri == -1) {
				Giohang giohang = new Giohang();
				giohang.setMasanpham(masanpham);
				giohang.setTensanpham(tensanpham);
				giohang.setMamau(mamau);
				giohang.setTenmau(tenmau);
				giohang.setMasize(masize);
				giohang.setTensize(tensize);
				giohang.setSoluong(1);
				giohang.setGiatien(giatien);
				listGiohang.add(giohang);
				httpSession.setAttribute("giohang", listGiohang);
				
			} else {
				int soluongmoi = listGiohang.get(vitri).getSoluong() + 1;
				listGiohang.get(vitri).setSoluong(soluongmoi);
				
			}
			
		}
		int soluongsanpham = 0;
		if (null != httpSession.getAttribute("giohang")) {
			List<Giohang> listGiohang = (List<Giohang>) httpSession.getAttribute("giohang");
			for (Giohang giohang : listGiohang) {
				soluongsanpham = listGiohang.size();
			}
		}
		return soluongsanpham + "";

	}
	
	
	public int kiemtraSanpham(List<Giohang> listGiohang, int masanpham, int mamau, int masize) {
		for (int i = 0; i < listGiohang.size(); i++) {
			if (listGiohang.get(i).getMasanpham() == masanpham && listGiohang.get(i).getMamau() == mamau
					&& listGiohang.get(i).getMasize() == masize) {
				return i;
			}
		}
		return -1;
	}
	
	@ResponseBody
	@GetMapping("laysoluongsanpham")
	public String LaySoluongsanpham(HttpSession httpSession, ModelMap modelMap) {
		if (null != httpSession.getAttribute("giohang")) {
			
			List<Giohang> listGiohang = (List<Giohang>) httpSession.getAttribute("giohang");
			return listGiohang.size() + "";
			
		}

		return "";
	}
}
