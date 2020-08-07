package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemservice;
	
	//method가 get방식이다 라는 뜻
	@RequestMapping("index.do")
	public ModelAndView listView() throws Exception {
		List<Item> list= itemservice.getAllItem();
		return new ModelAndView("itemList","list",list);
	}
	
	@RequestMapping("itemView.do")
	public ModelAndView ItemView(int itemId) throws Exception{
		Item item = itemservice.getItem(itemId);
		return new ModelAndView("itemView","item",item);
	}
}
