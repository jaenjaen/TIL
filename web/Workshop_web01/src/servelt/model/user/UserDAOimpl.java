package servelt.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOimpl implements UserDAO {
	private DataSource ds;
	
	//싱글톤	
	private static UserDAOimpl dao = new UserDAOimpl();
	private UserDAOimpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			
			System.out.println("data lookup 성공****");
		}
		catch(NamingException e){
			System.out.println("data lookup 실패****");
		}
	}
	public static UserDAOimpl getInstance(){
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("Database 연결***");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null)rs.close();
		closeAll(ps,conn);
	}

	@Override
	public UserVo login(String id, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVo vo = null;
		
		try {
			conn = getConnection();
			String query= "SELECT * FROM userinfo WHERE userid=? AND password=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new UserVo(id, password,
								rs.getString("name"),
								rs.getString("email"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
}
