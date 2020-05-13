package jdbc.transaction;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class TXcommitTest2 {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs = null;
		
		//1. 파일의 정보를 읽어온다.
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			//2.key로 읽어들인 값을 각각의 변수에 할당
			String driverName = p.getProperty("jdbc.mysql.driver") ;
			String url = p.getProperty("jdbc.mysql.url");
			String user = p.getProperty("jdbc.mysql.user");
			String pass = p.getProperty("jdbc.mysql.pass");
			
			String selectQuery = p.getProperty("jdbc.sql.select");
			String increaseQuery = p.getProperty("jdbc.sql.increaseupdate");
			String decreaseQuery = p.getProperty("jdbc.sql.decreaseupdate");
			
			//3.드라이버 로딩
			Class.forName(driverName);
			System.out.println("드라이버 로딩 성공");
			
			//4. 드라이버 연결
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("디비 연결 성공");
			
			conn.setAutoCommit(false); //시작
			
			ps1 = conn.prepareStatement(selectQuery);
			rs = ps1.executeQuery();
			
			System.out.println("*******************SELECT ***********************");
			
			while(rs.next()) {
				System.out.println(rs.getString("name")+" "+rs.getString("bankname")+" "+rs.getInt("balance"));	
			}
			
			System.out.println("************************************************");
			
			//윤아의 계좌 50만원 출금
			ps2 = conn.prepareStatement(decreaseQuery);
			ps2.setInt(1, 500000);
			ps2.setString(2,"윤아");
			ps2.executeUpdate();
			
			//승기의 계좌 50만원 입금
			ps3 = conn.prepareStatement(increaseQuery);
			ps3.setInt(1, 500000);
			ps3.setString(2, "이승기");
			ps3.executeUpdate();
			
			conn.commit();
			System.out.println("commit");
		}catch(Exception e) {
			conn.rollback();
			System.out.println("계좌이체시 오류발생");
		}finally {
			try {
				rs = ps1.executeQuery();
				System.out.println("******************* 계좌이체 이 후 ***********************");
				while(rs.next()) {
					System.out.println(rs.getString("name")+" "+rs.getString("bankname")+" "+rs.getInt("balance"));	
				}
				System.out.println("************************************************");
			} catch (SQLException e) {
			}
			conn.setAutoCommit(true);
			ps1.close();
			ps2.close();
			ps3.close();
			conn.close();
		}

	}

}
