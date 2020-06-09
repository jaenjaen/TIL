package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAO {
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException;
	
	void registerMember(MemberVO member) throws SQLException;
	ArrayList<MemberVO> showAllMembers() throws SQLException;
	MemberVO findByIdMember(String id) throws SQLException;
}
