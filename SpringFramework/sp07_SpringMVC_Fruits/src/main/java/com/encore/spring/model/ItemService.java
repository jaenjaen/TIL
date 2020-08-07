package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Item;

public interface ItemService {
	List<Item> getAllItem() throws Exception;
	Item getItem(int itemId) throws Exception;
}
