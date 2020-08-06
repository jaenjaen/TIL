package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.MyProduct;

public interface MyProductDAO {
	int addProduct(MyProduct myproduct) throws Exception;
	List<MyProduct> findByProductName(String productName) throws Exception;
	List<MyProduct> findProducts() throws Exception;
}
