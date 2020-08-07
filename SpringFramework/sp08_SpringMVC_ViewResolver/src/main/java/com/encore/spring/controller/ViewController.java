package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	@RequestMapping("findBoard.do")
	public ModelAndView findBoard() throws Exception {
		System.out.println("findBoard() call!");
		return new ModelAndView("board_result");
	}
	
	@RequestMapping("findProduct.do")
	public ModelAndView findProduct() throws Exception {
		System.out.println("findProduct() call!");
		return new ModelAndView("product_result");
	}
	
	@RequestMapping("register.do")
	public ModelAndView register() throws Exception {
		System.out.println("register() call!");
		return new ModelAndView("register_result");
	}
}
