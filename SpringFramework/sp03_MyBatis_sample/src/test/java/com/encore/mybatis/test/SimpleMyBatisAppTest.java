package com.encore.mybatis.test;

import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;

public class SimpleMyBatisAppTest {
/*
 * Scanner를 통해 값을 입력 (화면 대신)
 * 입력받은 값을 MyBatis 라이브러리를 사용해
 * DB에 Access하는 로직 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		MySawon vo = new MySawon();
		
		System.out.println("아이디를 입력하세요:");
		vo.setId(sc.next());
		
		System.out.println("비밀번호를 입력하세요:");
		vo.setPwd(sc.next());
		
		System.out.println("이름을 입력하세요:");
		vo.setName(sc.next());
		
		System.out.println("나이을 입력하세요:");
		vo.setAge(sc.nextInt());
		
		sc.close();
		
		//mybatis lib사용
		try {
			//1 SqlMapConfig.xml읽어들임
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			
			//2.SqlSessionFactory를 리턴받음
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
			//3. SqlSession을 리턴받는다.
			SqlSession session = factory.openSession();
			
			//4. 쿼리문을 실행하는기능
			/*
			 * session.insert(arg0) insert 
			 * session.delete(arg0) delete
			 * session.update() update
			 * session.selectOne(arg0) 하나만 불러오기 
			 * session.selectList(arg0) 전체 다 불러오기
			 */
			
			session.insert("mysawonMapper.sawonAdd",vo);
			session.commit(); // dml일때는 commit꼬옥 해줘야함
			session.close(); // spring di는 들어가있어서 그때하면 에러남 
			
			System.out.println(vo.getName()+"님의 정보가 추가되었습니다.");
		}catch(Exception e){
			//e.printStackTrace();
			System.out.println(vo.getName()+"님의 정보 추가실패");
		}
	}

}
