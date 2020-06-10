package servelt.model.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAOimpl implements BookDAO {
	
	private DataSource ds;
	
	private static BookDAOimpl dao = new BookDAOimpl();
	private BookDAOimpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("data Lookup 성공***");
		} catch (NamingException e) {
			System.out.println("data Lookup 실패***");
		}
	}
	
	public static BookDAOimpl getInstance() {
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
		ps = conn.prepareStatement(query);
		
		ps.setString(1, book.getIsbn());
		ps.setString(2, book.getTitle());
		ps.setString(3, book.getCatalogue());
		ps.setString(4, book.getNation());
		ps.setDate(5, book.getPublish_date());
		ps.setString(6, book.getPublisher());
		ps.setString(7, book.getAuthor());
		ps.setInt(8, book.getPrice());
		ps.setString(9, book.getCurrency());
		ps.setString(10, book.getDesc());
		
		ps.executeUpdate();
		System.out.println("db추가***");

		closeAll(ps, conn);
		
	}

	@Override
	public ArrayList<BookVo> showAllbook() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookVo> books = new ArrayList<BookVo>();
		
		conn=getConnection();
		String query = "SELECT * FROM book";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			books.add(new BookVo(rs.getString("isbn"),
				  	rs.getString("title"), rs.getString("catalogue"),
				  	rs.getString("nation"), rs.getDate("publish_date"),
				  	rs.getString("publisher"),rs.getString("author"),
				  	rs.getInt("price"),rs.getString("currency"),rs.getString("description")));
			
		}
		return books;
	}
	
	public ArrayList<BookVo> search(String sort,String word) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookVo> books = new ArrayList<BookVo>();
		String query = "";
		
		try {
			conn = getConnection();
			if(word.equals("title")){
				query = "SELECT * FROM book WHERE title LIKE ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, "%"+word+"%");
			}
			else if(word.equals("publisher")) {
				query = "SELECT * FROM book WHERE publisher LIKE ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, "%"+word+"%");
				
			}
			else if(word.equals("price")) {
				query = "SELECT * FROM book WHERE price LIKE ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, "%"+word+"%");
				
			}
			else {
				query = "SELECT * FROM book WHERE title LIKE ? OR "
						+ "publisher LIKE ? OR price LIKE ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, "%"+word+"%");
				ps.setString(2, "%"+word+"%");
				ps.setString(3, "%"+word+"%");
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				books.add(new BookVo(rs.getString("isbn"), rs.getString("title"), 
						rs.getString("catalogue"),rs.getString("nation"),
						rs.getDate("publish_date"), rs.getString("publisher"),
						rs.getString("author"), rs.getInt("price"),
						rs.getString("currency"), rs.getString("description")));
			}
			return books;
		} finally {
			closeAll(rs,ps,conn);
		}
		
	}
	
	/*public static void main(String[] args) throws SQLException {
		
		BookDAOimpl dao = BookDAOimpl.getInstance();
		
		ArrayList<BookVo> books = new ArrayList<>();
		books = dao.showAllbook();
		for(BookVo book: books) {
			System.out.println(book.toString());
		}
		
	}*/

}
