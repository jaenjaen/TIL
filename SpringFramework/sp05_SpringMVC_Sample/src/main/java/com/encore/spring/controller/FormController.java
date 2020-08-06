package com.encore.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		/*폼값받아서
		 * VO생성
		 * Service호출
		 * 리턴받아서 
		 * 바인딩
		 */
		
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		return new ModelAndView("form_result","info",name+","+addr);
	}
	
}
