package com.yaleshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yaleshop.entity.Giohang;

@Controller
@RequestMapping("/giohang")
@SessionAttributes("giohang")
public class GiohangController {
	
	@GetMapping
	public String giohang(HttpSession httpSession, ModelMap modelMap) {
		if (null != httpSession.getAttribute("giohang")) {
			List<Giohang> listGiohang = (List<Giohang>) httpSession.getAttribute("giohang");
			int soluong = listGiohang.size();
			modelMap.addAttribute("soluongAll", soluong);
			modelMap.addAttribute("giohang", listGiohang);
		}
		return "giohang";
	}
}
