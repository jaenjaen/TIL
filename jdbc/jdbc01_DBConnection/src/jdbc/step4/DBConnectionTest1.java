package jdbc.step4;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
 * 실제 값들의 메타데이타
 * 인터페이스->properties file
 * collection - set/list     map
 * 							  | hashmap / hashtable
 * 											| properties 키와 값을 쌍으로 저장하는데 값 무족건 STRING!
 */


public class DBConnectionTest1 {

	public DBConnectionTest1() {
		
	}
			
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.load(new FileInputStream("src/config/db.properties")); //file은  src부터 시작해야됨 package에는 src포함
		
		String driver = p.getProperty("jdbc.mysql.driver");
		String url = p.getProperty("jdbc.mysql.url");
		String user = p.getProperty("jdbc.mysql.user");
		String pass = p.getProperty("jdbc.mysql.pass");
		
		String selectAll = p.getProperty("jdbc.sql.selectAll");
		
		Class.forName(driver);
		System.out.println("드라이버 로딩 성공");
		
		Connection conn = DriverManager.getConnection(url,user,pass);
		System.out.println("디비 연결 성공");
		
		PreparedStatement st = conn.prepareStatement(selectAll);
		System.out.println("PreparedStatment 준비 완료");
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			String addr = rs.getString("address");
			
			System.out.printf("%s님의 주소는 %s입니다.\n",name,addr);
		}
		
		st.close();
		conn.close();
	}

}
