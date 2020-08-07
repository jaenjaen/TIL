package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemDAO;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Item> getAllItem() throws Exception {
		return session.selectList("ItemMapper.getAllItem");
	}

	@Override
	public Item getItem(int itemId) throws Exception {
		return session.selectOne("ItemMapper.getItem",itemId);
	}
}
