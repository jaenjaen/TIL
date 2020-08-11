package com.encore.pms.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.pms.dto.Company;
import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

public class PmsTest {
	
	@Test
	public void test() throws IOException {
		Reader r = Resources.getResourceAsReader("spring/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		String mapper = "PhoneMapper.";
		
//		Phone phone = new Phone("LGVel","엘지벨벳",932500,"20",new Company("20", "엘지"));
//		session.insert(mapper+"phoneRegister",phone);
//		session.commit();
		
//		List<String> tmp = new ArrayList<String>();
//		tmp.add("LGVel");
//		tmp.add("I125g");
//		tmp.add("Sflp1");
//		
//		session.delete(mapper+"phoneDelete",tmp);
//		session.commit();
		
//		List<Phone> list = session.selectList(mapper+"getAllPhone");
//		for(Phone p:list) {
//			System.out.println(p);
//		}
		
//		Phone p = session.selectOne(mapper+"getPhone","V50SQ");
//		System.out.println(p);
		
//		UserInfo user = session.selectOne(mapper+"login","admin");
//		System.out.println(user);
		
		Company c = session.selectOne(mapper+"getCompany","10");
		System.out.println(c);
//		
//		List<Company> list = session.selectList(mapper+"getAllCompany");
//		for(Company com: list) {
//			System.out.println(com);
//		}
	}
}
