package com.encore.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.Item;

public class ItemTest {
	
	@Test
	public void unit() throws IOException {
		Reader r = Resources.getResourceAsReader("config/sqlmapconfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		System.out.println("get All Item*************");
		List<Item> ilist = session.selectList("ItemMapper.getAllItem");
		for(Item i:ilist) {
			System.out.println(i);
		}
		
		System.out.println("getItem*************");
		Item item = session.selectOne("ItemMapper.getItem",1);
		System.out.println(item);
	
	}
}
