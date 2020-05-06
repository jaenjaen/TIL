package jdbc.step3;

/*
 * 문제점 step2에는 디비서버에 대한 정보가 프로그램상에 하드코딩 되어져 있다.
 * 
 * 해결책 별도의 모듈에 디비서버에 대한 정보를 뽑아내어서 별도로 처리(==메타데이터화 시킨다)
 * interface - properties - xml
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import query.PersonSQL;

public class DBConnectionTest1 {

	public DBConnectionTest1() throws ClassNotFoundException, SQLException {
		Class.forName(ServerInfo.DRIVER_NAME);//driver FQCN
		System.out.println("Driver Loading");
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("디비연결 성공");
		
		//쿼리준비
		/*String query ="INSERT INTO person(ssn,name,address) VALUES(?,?,?)";
		PreparedStatement st = conn.prepareCall(query);
		System.out.println("preparedstatment 생성 성공");
		
		//값 바인딩+쿼리실행
		st.setInt(1, 333);
		st.setString(2, "정우성");
		st.setString(3, "혜화동");
		
		int row = st.executeUpdate();
		System.out.println(row+"행 추가");*/
		
		/*//Query 삭제
		String query = "DELETE FROM person WHERE ssn=?";
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("preparedstatment 생성");
		
		//값 바인딩
		st.setInt(1, 333);
		
		int row = st.executeUpdate();
		System.out.println(row+"행이 삭제되었습니다.");*/
		
		/*//111 업데이트
		String query = "UPDATE person SET name=?,address=? WHERE ssn=?";
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("st생성");
		
		//값 바인딩
		st.setString(1, "박나리");
		st.setString(2, "한남동");
		st.setInt(3, 111);
		int row = st.executeUpdate();
		System.out.println(row+"행이 업데이트 되었습니다.");*/
		
		//select문 모든 레코드 검색
		PreparedStatement st = conn.prepareStatement(PersonSQL.All_Person);
		System.out.println("PreparedStatment 생성");
		
		ResultSet rs= st.executeQuery();
		while(rs.next()) {
			int ssn = rs.getInt("ssn"); // 첫번째 컬럼 또는 rs.getInt("ssn")
			String name = rs.getString("name");
			String addr = rs.getString("address");
			System.out.println(ssn+","+name+","+addr);
			
		}
		
		//자원반납
		st.close();
		conn.close();
	}
			
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new DBConnectionTest1();

	}

}
