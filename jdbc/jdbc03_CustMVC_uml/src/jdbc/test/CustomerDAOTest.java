package jdbc.test;

import config.ServerInfo;
import jdbc.dao.impl.CustomerDAOImpl;

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

	}

}
