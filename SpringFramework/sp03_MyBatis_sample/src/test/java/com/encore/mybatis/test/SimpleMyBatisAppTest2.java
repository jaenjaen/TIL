package com.encore.mybatis.test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;

public class SimpleMyBatisAppTest2 {
	
	//table 불러오기
	public static void main(String[] args) {
	try {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		
		System.out.println("-------------------------------------------------");
		List<MySawon> list = session.selectList("mysawonMapper.sawonList");
		
		for(MySawon vo:list) {
			System.out.println(vo.getId()+","+vo.getName()+","+vo.getHiredate());
			}
		}
	catch(Exception e) {
		e.printStackTrace();
		}
	}

}
