package jdbc.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * 1. 드라이버로딩
 * 2.디비서버와 연결 방법 jdbc:mysql:ip://3306(jdbc포트넘버)/스키마(scott)
 * 3.Quary를 준비시킴 (PreparedStatement)
 * 4.값 바인딩 + 쿼리문 실행 - 
 * 		1) ?에 해당하는 값 바인딩
 * 		2) 쿼리문 실행
 * 		ExecuteUpdate - DML용 : int
 * 		ExecuteQuary - SELECT용 : ResultSet
 * 5. 자원반납
 */
public class DBConnectionTest1 {

	public DBConnectionTest1() {
		try {
			
			//1
			Class.forName("com.mysql.cj.jdbc.Driver");//FQCN(패키지명을 포함한 전체 이름)
			System.out.println("Driver loading Success!");
			
			//2
			String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			Connection conn = DriverManager.getConnection(url,"root","1234");
			
			System.out.println("DB Connection Success!");
			
			//3.quary 준비
			String query="INSERT INTO person(ssn,name,address) VALUES(?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("Creating PreparedStatment!");
			
			//4
			st.setInt(1, 111);
			st.setString(2, "박나래");
			st.setString(3, "여의도");
			
			int row = st.executeUpdate();
			System.out.println(row+"명 추가됨!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading fail");
		} catch (SQLException e) {
			System.out.println("DB Connection Fail");
		}
	}
	public static void main(String[] args) {
		new DBConnectionTest1();

	}

}
