package com.encore.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.MyProduct;

public class MyBatisUnitTest2 {
	
	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		MyProduct vo = new MyProduct("LG 스마트 드럼세탁기", "LG", 800000);
		System.out.println("Before insert VO: "+vo.getId());
		
		//session.insert("ProductMapper.addProduct",vo);//디비에 값 넣고 id값 자동생성하고 vosetting
		System.out.println("INSERT FINISHED");
		System.out.println("After insert Vo: "+vo.getId());
		
		session.commit();
		
		System.out.println("*********************************************************");
		List<MyProduct> mlist = session.selectList("ProductMapper.findByProductName","세탁기");
		for(MyProduct m:mlist) {
			System.out.println(m);
		}
		
		System.out.println("*********************************************************");
		List<MyProduct> alist = session.selectList("ProductMapper.findProducts");
		for(MyProduct m:alist) {
			System.out.println(m);
		}
	}
}
