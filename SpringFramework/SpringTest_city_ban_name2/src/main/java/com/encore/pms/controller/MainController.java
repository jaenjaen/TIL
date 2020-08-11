package com.encore.pms.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.encore.pms.dto.Company;
import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;
import com.encore.pms.service.IPhoneService;

@Controller
public class MainController {	
	
	@Autowired
	private IPhoneService service;
	
	@GetMapping("showReg.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title","핸드폰 관리 - 핸드폰 등록폼");
		return "PhoneReg";
	}
	
	@PostMapping("savePhone.do")
	public String doRegPhone(Phone phone, Model model){
		try {
			service.phoneRegister(phone);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 등록 성공");
			return "result";
		}catch(Exception e){
			model.addAttribute("title","핸드폰 관리 - 에러");
			return "error";
		}
	}
	
	@GetMapping("searchPhone.do")
	public String doList(Model model) {
		try {
			List<Phone> list = service.getAllPhone();
			model.addAttribute("title","핸드폰 관리 - 리스트");
			return "PhoneList";
		}catch(Exception e) {
			model.addAttribute("title","핸드폰 관리 - 에러");
			model.addAttribute("msg","문제내용 - 목록 조회중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Phone phone, Model model) {
		try {
			Phone selected = service.getPhone(phone.getNum());
			model.addAttribute("title","핸드폰 관리 - 핸드폰 상세조회");
			model.addAttribute("Phone",selected);
			return "PhoneView";
		}catch(Exception e) {
			model.addAttribute("title","핸드폰 관리 - 에러");
			model.addAttribute("msg","문제내용 - 목록 조회중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("login.do")
	public String getLoginForm() {
		return "Login";
	}
	
	
}
