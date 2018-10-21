package com.yaleshop.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yaleshop.entity.Nhanvien;
import com.yaleshop.service.NhanvienService;
import com.yaleshop.utills.StringUtill;

@Controller
@RequestMapping("dangnhap/")
@SessionAttributes("email")
public class DangnhapDangkyController {
	
	@Autowired
	private NhanvienService  nhanvienService;
	
	@GetMapping
	public String dangnhap() {
		return "dangnhap";
	}
	
//	@PostMapping
//	@Transactional
//	public String xulydangnhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap) {
//		if(nhanvienService.kiemtradangnhap(email, matkhau)) {
//			modelMap.addAttribute("kiemtradangnhap", "Dang nhap thanh cong");
//		}else {
//			modelMap.addAttribute("kiemtradangnhap", "Dang nhap that bai");
//		}
//		return "dangnhap";
//	}
	@PostMapping
	@Transactional
	public String xulydangky(@RequestParam String emaildangky, @RequestParam String matkhaudangky, 
			@RequestParam String nhaplaimatkhau, ModelMap modelMap) {
		boolean kt = StringUtill.checkEmail(emaildangky);
		if(kt) {
			if(matkhaudangky.equals(nhaplaimatkhau)) {
				Nhanvien nhanvien = new Nhanvien();
				nhanvien.setEmail(emaildangky);
				nhanvien.setTendangnhap(emaildangky);
				nhanvien.setMatkhau(matkhaudangky);
				nhanvienService.saveNhanvien(nhanvien);
				modelMap.addAttribute("dangkythanhcong", "* Đăng ký thành công");
			}else {
				modelMap.addAttribute("kiemtradangnhapmatkhau", "* Mật khẩu không trùng khớp !");
			}
		}else {
			modelMap.addAttribute("kiemtradangnhapemail", "* Email không hợp lệ !");
		}
		return "dangnhap";
	}
	@GetMapping
	@RequestMapping("")
	public String dangxuat(ModelMap modelMap, HttpSession httpSession, @SessionAttribute("email") String emailString) {
		httpSession.setAttribute("email", null);
		return "dangnhap";
	}
}
