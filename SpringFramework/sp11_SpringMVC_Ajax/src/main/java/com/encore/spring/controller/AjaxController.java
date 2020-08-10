package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Person;

@Controller
public class AjaxController {

	/*
	 * ModelAndView
	 * View Page Name + ModelData
	 * 인데 아래와 같이 찢어서 써도 됨 응답페이지로 forwarding된다.
	 * */
	@RequestMapping("inset.do")
	public String insert(Model model) {
		System.out.println("동기통신***");
		model.addAttribute("info","승기야~ 지금 몇시고");
		return "insert_result";
	}
	
	@RequestMapping("SearchId.do")
		public ModelAndView search() {
			System.out.println("비동기 통신****");
			//return new ModelAndView("redirect:/index.jsp"); 리다이렉트
			return new ModelAndView("JsonView","person",new Person("김선호","관악구"));
	}
	
	
}
