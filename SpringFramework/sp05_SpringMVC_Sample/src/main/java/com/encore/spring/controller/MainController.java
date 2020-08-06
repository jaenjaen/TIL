package com.encore.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView(); // 뷰페이지이름, 이동경로+ 데이터바인딩
		mv.setViewName("result"); //확장자 보통 안씀,물리적 저장위치도 안씀 -> ViewResolver
		mv.addObject("message","Hello First Spring MVC!");
		return mv;
	}

}
