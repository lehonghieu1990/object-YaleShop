package com.yaleshop.controller;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaleshop.entity.Chitietsanpham;
import com.yaleshop.entity.Danhmucsanpham;
import com.yaleshop.entity.Mausanpham;
import com.yaleshop.entity.Sanpham;
import com.yaleshop.entity.Sizesanpham;
import com.yaleshop.service.DanhmucService;
import com.yaleshop.service.MausanphamService;
import com.yaleshop.service.SanphamService;
import com.yaleshop.service.SizesanphamService;

@Controller
@RequestMapping("/admin")
public class DashboardController {
	
	@Autowired
	private SanphamService sanphamservice;
	
	@Autowired
	private SizesanphamService sizesanphamService;
	
	@Autowired
	private MausanphamService mausanphamService;
	
	@Autowired
	private DanhmucService danhmucService;
	
	@GetMapping
	public String admin(ModelMap modelMap, HttpSession httpSession) {

		List<Sanpham> sanphams = sanphamservice.danhsachsanphamPhantrag(0, 8);
		modelMap.addAttribute("sanphams", sanphams);
		
		List<Sanpham> AllSanpham = sanphamservice.danhsachsanphamPhantrag(-1, 8);
		
		double AllPage = Math.ceil((double)AllSanpham.size()/8);
		modelMap.addAttribute("AllPage", AllPage);
		
		List<Danhmucsanpham> listDanhmucsanpham = danhmucService.danhsachdanhmuc();
		modelMap.addAttribute("listDanhmucsanpham", listDanhmucsanpham);
		
		List<Sizesanpham> listSizesanpham = sizesanphamService.danhsachSizesanpham();
		modelMap.addAttribute("listSizesanpham", listSizesanpham);
		
		List<Mausanpham> listMausanpham = mausanphamService.danhsachMausanpham();
		modelMap.addAttribute("listMausanpham", listMausanpham);
		

		return "dashboard";
		
	}
	
	@GetMapping(path="/laysanphamphantrang", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String laysanphamphantrang(ModelMap modelMap, HttpSession httpSession, @RequestParam int positon) {
		String html = "";
		List<Sanpham> sanphams = sanphamservice.danhsachsanphamPhantrag(positon, 8);
		for(Sanpham sanpham : sanphams) {
			html += "<tr>";
			html += "<td><div class='checkbox'><label><input class='checkboxsanpham' type='checkbox' value='" +sanpham.getId() + "'></label></td>";
			html += "<td class='tensanpham' data-masp = " + sanpham.getId() + ">" + sanpham.getTensanpham() + "</td>";
			html += "<td class='giatien' >" + sanpham.getGiatien() +"</td>";
			html += "<td class='gianhcho'>" + sanpham.getGianhcho() + "</td>";
			html += "</tr>";
		}
		return html;
	}
	
	@GetMapping(path="/xoasanpham", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String xoasanpham(ModelMap modelMap, HttpSession httpSession, @RequestParam int masanpham) {
		String html = "";
		System.out.println(masanpham);
		return html;
	}
	@Autowired
	ServletContext context;
	
	@PostMapping(path="/updatefile")
	@ResponseBody
	public String updatefile(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		String path_save_file = context.getRealPath("/resources/image/");
		Iterator<String> listName = request.getFileNames();
		MultipartFile mpf = request.getFile(listName.next());
		
		File file_save = new File(path_save_file + mpf.getOriginalFilename());
		mpf.transferTo(file_save);
		System.out.println(path_save_file);
		return "true";
	}
	
	@PostMapping(path="/themsanphamadmin")
	@ResponseBody
	public String themsanpham(@RequestParam String datajson) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject = objectMapper.readTree(datajson);
//		System.out.println(jsonObject.get("chitietsanpham"));
		Sanpham sanpham = objectMapper.readValue(datajson, Sanpham.class);

			System.out.println(sanpham.getDanhmucsanpham().getId() + " - " + sanpham.getDanhmucsanpham().getTendanhmuc());

		sanphamservice.saveSanpham(sanpham);
		
		return "true";
	}
}
