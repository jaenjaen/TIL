package servelt.model.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAOimpl implements BookDAO {
	
	private DataSource ds;
	
	private BookDAOimpl dao = new BookDAOimpl();
	private BookDAOimpl() {
		
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:java:comp/env/jdbc/mysql");
			System.out.println("data Lookup 성공***");
		} catch (NamingException e) {
			System.out.println("data Lookup 실패***");
		}
	}
	
	public BookDAOimpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps !=null ) ps.close();
		if(conn !=null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void bookRegister(BookVo book) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnection();
		String query = "INSERT INTO book(isbn,title,catalogue,nation,publish_date,publisher,author,price,currency,description)"
				+ "VALUE(?,?,?,?,?,?,?,?,?,?)";
	}

}
