package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String ns = "ProductMapper.";

	@Override
	public int addProduct(MyProduct myproduct) throws Exception {
		return sqlSession.insert(ns+"addProduct", myproduct);
	}

	@Override
	public List<MyProduct> findByProductName(String productName) throws Exception {
		return sqlSession.selectList(ns+"findByProductName", productName);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		return sqlSession.selectList(ns+"findProducts");
	}

}
