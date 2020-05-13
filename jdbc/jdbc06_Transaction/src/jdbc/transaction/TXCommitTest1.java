package jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

/**
 * 
 * 
 *  TX = transaction
 *  set auto commit- ture -> 순서대로 따로 돌리겠다는 뜻
 *  set auto commit- false -> 같이 돌리겠다는 뜻
 */
public class TXCommitTest1 {

	public static void main(String[] args) throws Exception {
		
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("Driver loading!");
		
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		String query1 = "INSERT INTO encore(name) VALUES(?)";
		String query2 = "SELECT no, name FROM encore WHERE no=?";
		
		//트랜잭션 시작
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(query1);
		ps.setString(1, "전지현");
		ps.executeUpdate();
		
		//no 7번에 해당하는 ㅋ레코드가 존재하지 않는다 -> 실패 roll back
		//no 7번에 해당하는 레코드가 존재하면 -> 성공 commit
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ps2.setInt(1, 3);
		ResultSet rs = ps2.executeQuery();
		
		if(!rs.next()) {
			conn.rollback();
			System.out.println("찾는 번호에 해당하는 회원이 없어서 rollback");
		}else {
			conn.commit();
			System.out.println("변경된 정보들이 commit되었습니다.");
		}
		
		//트랜젝션 처리를 돌려놓음
		conn.setAutoCommit(true);
		

	}

}
