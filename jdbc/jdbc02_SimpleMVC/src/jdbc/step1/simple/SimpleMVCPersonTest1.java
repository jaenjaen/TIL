package jdbc.step1.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
 * 구조적으로 작성
 * 1.드라이버로딩
 * 2.디비연결
 * 3.preparedStatment설정
 * 4.쿼리문 실행
 * 5.close
 * 고정적 반복 - 디비연결, 자원반납 - 공통적인 메소드로 처리 메소드마다 호출
 * 변동적인 반복 - 
 * 
 * 비즈니스 로직가 모인곳ㅛ DAO(Database Access Object)
 */
public class SimpleMVCPersonTest1{
	
	public Connection getConn() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("드라이버 연결");
		return conn;
	}
	
	public void closeAll(PreparedStatement ps,Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void addPerson(int ssn,String name, String addr) throws SQLException {
		//디비연결 preparedstatment 쿼리문수행, close
		Connection conn = getConn();
		String query = "INSERT INTO person(ssn, name, address) Values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, ssn);
		ps.setString(2, name);
		ps.setString(3, addr);
		
		ps.executeUpdate();
		System.out.println(name+"님이 추가되었습니다.");
		
		closeAll(ps, conn);
		
	}
	public void deletePerson(int ssn) throws SQLException {
		//디비연결 preparedstatment 쿼리문수행, close
		if(searchAPeroson(ssn)) {
			Connection conn = getConn();
			
			String query = "DELETE FROM person WHERE ssn=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, ssn);
			ps.executeUpdate();
			System.out.println(ssn+"번 회원님이 삭제되었습니다.");
			
			closeAll(ps, conn);
		}
		else System.out.println(ssn+"님은 존재하지 않습니다.");
		
		
	}
	
	public void updatePerson(int ssn, String name, String address) throws SQLException {
		//디비연결 preparedstatment 쿼리문수행, close
		if(searchAPeroson(ssn)) {
			Connection conn = getConn();
			
			String quary = "UPDATE person SET name=?,address=? WHERE ssn=?";
			PreparedStatement ps = conn.prepareStatement(quary);
			
			ps.setString(1,name);
			ps.setString(2, address);
			ps.setInt(3, ssn);
			
			ps.executeUpdate();
			System.out.println(name+"님의 정보가 수정되었습니다.");
			
			closeAll(ps, conn);
			
		}else System.out.println(ssn+"님은 존재하지 않습니다.");
		
	}
	
	public void searchAllPerson() throws SQLException {
		Connection conn = getConn();
		
		String quary = "Select ssn,name,address from person";
		PreparedStatement ps = conn.prepareStatement(quary);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int ssn = rs.getInt("ssn");
			String name = rs.getString("name");
			String address = rs.getString("address");
			
			System.out.println(ssn+". "+name+"님의 주소는 "+address+"입니다.");
		}
		
		closeAll(rs, ps, conn);
	}
	
	public Boolean searchAPeroson(int ssn) throws SQLException {
		Boolean p = false;
		//디비연결 preparedstatment 쿼리문수행, close
		Connection conn = getConn();
		
		String query = "Select ssn, name, address From person WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, ssn);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			int sn = rs.getInt("ssn");
			String name = rs.getString("name");
			String addr = rs.getString("address");
			
			System.out.println(sn+". "+name+"님의 주소는 "+addr+"입니다.");
			p = true;
		}
		
		closeAll(rs, ps, conn);
		return p;
	}
	public static void main(String[] args) {
		SimpleMVCPersonTest1 mvc = new SimpleMVCPersonTest1();
		try {
			mvc.addPerson(444,"이효리","제주도");
		} catch (SQLException e) {
			System.out.println("회원가입~~~ 실패!");
		}try {
			mvc.deletePerson(333);
		} catch (SQLException e) {
			System.out.println("회원 삭제에 실패하였습니다.");
		}try {
			mvc.updatePerson(111,"박나래","성수동");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("회원정보가 수정되지 않았습니다.");
		}
		try {
			mvc.searchAllPerson();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("회원이 존재하지 않습니다.");
		}
		try {
			mvc.searchAPeroson(444);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("해당 회원이 존재하지 않습니다.");
		}
	}
	
	//static initialization block - 메인보다 먼저 돌아감
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
}
