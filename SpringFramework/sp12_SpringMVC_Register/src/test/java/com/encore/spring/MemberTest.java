package com.encore.spring;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.Member;

public class MemberTest {

	@Test
	public void test() throws IOException {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		String mapper = "MemberMapper";
		
		
//		 List<Member> members= session.selectList(mapper+".getAllMember");
//		  
//		 for(Member m: members) { System.out.println(m); }
//		  
//		 System.out.println("***********************************************");
//		 
//		
//		Member member = session.selectOne(mapper+".getMember","m7m");
//		System.out.println(member);
//		
//		System.out.println("***********************************************");
//		
//		member.setPassword("1331");
//		member.setAddress("수영구");
//		member.setName("김부산");
//		
//		System.out.println(member);
//		System.out.println(session.update(mapper+".updateMember",member));
//		session.commit();
//		System.out.println("***********************************************");
//		
//		Member newmem = new Member();
//		newmem.setId("green");
//		newmem.setName("김녹차");
//		newmem.setPassword("1212");
//		newmem.setAddress("보성");
//		System.out.println(session.insert(mapper+".registerMember",newmem));
//		session.commit();
		
		System.out.println(session.selectOne(mapper+".getMember","green"));
	
		
	}
}
