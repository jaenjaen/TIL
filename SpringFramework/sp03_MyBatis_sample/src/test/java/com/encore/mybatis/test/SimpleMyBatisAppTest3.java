package com.encore.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.encore.mybatis.vo.MySawon;

public class SimpleMyBatisAppTest3 {
	
	//table 불러오기
	public static void main(String[] args) {SqlSessionFactory factory = FactoryService.getFactory();
		SqlSession session = factory.openSession();
		
		System.out.println("-------------------------------------------------");
		List<MySawon> list = session.selectList("mysawonMapper.sawonList");
		
		for(MySawon vo:list) {
			System.out.println(vo.getId()+","+vo.getName()+","+vo.getHiredate());
			}
	}

}
