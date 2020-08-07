package com.encore.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemDAO;
import com.encore.spring.model.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDAO itemdao;
	
	@Override
	public List<Item> getAllItem() throws Exception {
		return itemdao.getAllItem();
	}

	@Override
	public Item getItem(int itemId) throws Exception {
		return itemdao.getItem(itemId);
	}
	
}
