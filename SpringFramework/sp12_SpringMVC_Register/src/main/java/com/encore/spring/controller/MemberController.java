package com.encore.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Member;
import com.encore.spring.model.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("login.do")
	public String login(HttpServletRequest req, Member m) {
		String path = "find_fail";
		Member vo = null;
		HttpSession session = req.getSession();
		
		try {
			vo = memberService.login(m);
			if (vo != null) {
				path = "login_result";
				session.setAttribute("vo", vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	@RequestMapping("AllMember.do")
	public ModelAndView getAllMember() {
		String path ="find_fail";
		List<Member> list = null;
		
		try {
			list = memberService.getAllMember();
			path = "allView";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(path,"list",list);
	}
	
	@RequestMapping("idcheck.do")
	public ModelAndView idCheck(String id) {
		Boolean flag = false;
		try {
			flag = memberService.checkId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("JsonView","flag",flag);
	}
	
	@RequestMapping("register.do")
	public String register(Member m) {
		
		try {
			memberService.registerMember(m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("findmember.do")
	public ModelAndView getMember(String id) {
		String path = "find_fail";
		Member vo = null;
		try {
			vo = memberService.getMember(id);
			if (vo!=null) path ="find_ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView(path,"vo",vo);
	}
	
	@RequestMapping("update.do")
	public ModelAndView updateMember(Member m) {
		try {
			memberService.updateMember(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("update_result","vo",m);
	}
	
	@RequestMapping("Logout.do")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("vo") != null) session.invalidate();
		return "logout";
	}
}
