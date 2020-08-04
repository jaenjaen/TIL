package com.encore.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*SqlSessionFactory 하나 받아오는 로직을 따로 분리*/
public class FactoryService {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
		}catch(Exception e){
			e.printStackTrace();
		}
	}//~static
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
