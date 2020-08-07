package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductService;

@Controller
public class MyProductController {
	
	@Autowired
	private MyProductService myProductService;
	
	//dispatcherservlet->handlermapping->dispatcherservlet->controller를 거쳐오면서 자동으로 Binding
	//RequestMethod지워도 됨
	@RequestMapping(value="myProduct.do", method=RequestMethod.POST)
	public ModelAndView insert(MyProduct pvo) throws Exception { 
		System.out.println("폼으로 받은 데이터"+pvo.getId());
		myProductService.addProduct(pvo);
		System.out.println("DB를 거친 데이터"+pvo.getId());
		
		return new ModelAndView("insert_result","info",pvo);
	}
	
	@RequestMapping(value="mySearch.do", method=RequestMethod.GET)
	public ModelAndView getProducts(String word) throws Exception { 
		List<MyProduct> list = myProductService.findByProductName(word);
		
		return new ModelAndView("find_result","list",list);
	}
}
