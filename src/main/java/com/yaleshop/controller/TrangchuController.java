package com.yaleshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yaleshop.contant.IntContants;
import com.yaleshop.entity.Giohang;
import com.yaleshop.entity.Sanpham;
import com.yaleshop.service.PageService;
import com.yaleshop.service.SanphamService;

@Controller
@SessionAttributes("giohang")
public class TrangchuController {

	@Autowired
	private SanphamService sanphamservice;

	@Autowired
	private PageService pageService;

	@GetMapping
	@Transactional
	@RequestMapping("/")
	public String index(ModelMap modelMap, HttpSession httpSession) {
		if (null != httpSession.getAttribute("giohang")) {
			List<Giohang> listGiohang = (List<Giohang>) httpSession.getAttribute("giohang");
			int soluong = listGiohang.size();
			modelMap.addAttribute("soluongAll", soluong);
		}
		
		int spAll = sanphamservice.danhsachsanpham().size();
		int page = 1;
		modelMap.addAttribute("pageView", page);

		int pageAll = pageService.pageAll(spAll, IntContants.Intpage.SANPHAM_MAX);
		modelMap.addAttribute("pageAll", pageAll);
		modelMap.addAttribute("spAll", spAll);
		List<Sanpham> listSanpham = sanphamservice.danhsachsanphamPhantrag(0, IntContants.Intpage.SANPHAM_MAX);
		modelMap.addAttribute("listSanpham", listSanpham);
		return "index";
	}

	@GetMapping
	@Transactional
	@RequestMapping("/pageIndex")
	public String pageIndex(ModelMap modelMap, @RequestParam(name = "page", required = false) int page,
			HttpSession httpSession) {
		int soluong = 0;
		if (null != httpSession.getAttribute("giohang")) {
			List<Giohang> listGiohang = (List<Giohang>) httpSession.getAttribute("giohang");

			for (Giohang giohang : listGiohang) {
				soluong = soluong + giohang.getSoluong();
			}

		}
		modelMap.addAttribute("soluongAll", soluong);
		int spAll = sanphamservice.danhsachsanpham().size();
		int positon = pageService.positon(page, IntContants.Intpage.SANPHAM_MAX);
		int pageAll = pageService.pageAll(spAll, IntContants.Intpage.SANPHAM_MAX);
		modelMap.addAttribute("pageAll", pageAll);
		modelMap.addAttribute("spAll", spAll);
		modelMap.addAttribute("pageView", page);
		List<Sanpham> listSanpham = sanphamservice.danhsachsanphamPhantrag(positon, IntContants.Intpage.SANPHAM_MAX);
		modelMap.addAttribute("listSanpham", listSanpham);
		return "index";
	}
}
