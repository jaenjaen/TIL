package jdbc.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import config.ServerInfo;
import jdbc.dao.impl.CustomerDAOImpl;
import jdbc.vo.Customer;

public class CustomerDAOTest {
	
	// static 초기화 블락
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("driver 로딩 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("driver 로딩 실패");
		}
	}
	
	public static void main(String[] args) {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		Customer cust = new Customer("ohmygirl","yeahbbo","오마이걸","망원동");
		Customer getrtn = null;

		/*try {
			dao.registerCustomer(new Customer("ceres","qqww11@@","마이니","강남구"));
			dao.registerCustomer(delCust);
		} catch (SQLException e) {
			System.out.println("이미 존재하는 회원입니다.");
		}
		try {
			ArrayList<Customer> custarr = dao.getAllCustomer();
			for(Customer c: custarr) {
				System.out.println(c.toString());
			}
		} catch (SQLException e1) {
			System.out.println("모두찾기 - 디비에러");
		}
	
		try {
			System.out.println(dao.getCustomer("ohmygirl"));
		} catch (SQLException e) {
			System.out.println("한명찾기 - 디비에러");
		}
		
		
		try {
			dao.deleteCustomer("ceres");
			dao.deleteCustomer(delCust);
			} catch (SQLException e) {
			System.out.println("삭제 - 디비에러");
		}*/
		try {
			getrtn = dao.login(cust);
			System.out.println(getrtn.getName()+"님이 로그인 하셨습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("로그인실패");
		}
		

	}

}
