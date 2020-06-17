package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import util.DataSourceManager;

public class ItemDao {
	
	private DataSource ds;
	
	private static ItemDao dao = new ItemDao();
	private ItemDao() {
		//공장 받아오기
		ds = (DataSource) DataSourceManager.getInstance();
	};
	public static ItemDao getInstance() {
		return dao;
	}
	
	//공통로직 Connection , Close All;
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps !=null) ps.close();
		if(conn !=null) conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		if(rs !=null) rs.close();
		closeAll(ps, conn);
	}
	
	
	//가변로직
}
