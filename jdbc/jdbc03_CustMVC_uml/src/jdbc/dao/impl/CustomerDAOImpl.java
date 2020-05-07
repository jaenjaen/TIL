package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import config.ServerInfo;
import jdbc.dao.CustomerDAO;
import jdbc.vo.Customer;

/*
 * DAO?
 * Database Access Object의 약자로 디비에 접근하는 로직(중요한 로직 일명 Business logic)
 * 
 * 공통로직과 가변로직 둘로 나누어 작성
 */

public class CustomerDAOImpl implements CustomerDAO{
	
	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	private CustomerDAOImpl() {}
	public static CustomerDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void CloseAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}

	@Override
	public void CloseAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}

	// --------------------------------------------------Business Logic-------------------------------
	
	
	@Override
	public void registerCustomer(Customer vo) throws SQLException {
		
		Connection conn = getConnect();
		String query = "INSERT INTO cust(id,pass,cust_name,address) VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2,vo.getPass());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddress());
		
		ps.executeUpdate();
		System.out.println("회원가입이 완료되었습니다.");
		
		CloseAll(ps, conn);
	}

	@Override
	public void deleteCustomer(String id) throws SQLException {
			Connection conn = getConnect();
			String query = "DELETE FROM CUST WHERE id =?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			ps.executeUpdate();
			
			System.out.println(id+"님이 삭제되었습니다.");
			
			CloseAll(ps, conn);
	}

	@Override
	public void deleteCustomer(Customer vo) throws SQLException {
			Connection conn = getConnect();
			String query = "DELETE FROM CUST WHERE id =?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getId());
			ps.executeUpdate();
			
			System.out.println(vo.getId()+"님이 삭제되었습니다.");
			
			CloseAll(ps, conn);
	}

	@Override
	public Customer getCustomer(String id) throws SQLException {
		Customer gCust = new Customer();
		String query = "Select * FROM cust WHERE id=?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			gCust.setId(rs.getString("id"));
			gCust.setPass(rs.getString("pass"));
			gCust.setName(rs.getString("cust_name"));
			gCust.setAddress(rs.getNString("address"));
		}
		
		CloseAll(rs,ps, conn);
		return gCust;
	}

	@Override
	public ArrayList<Customer> getAllCustomer() throws SQLException {
		ArrayList<Customer> getCust= new ArrayList<>();
		Connection conn = getConnect();
		String query = "Select * FROM cust";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("id");
			String pass = rs.getString("pass");
			String name = rs.getString("cust_name");
			String addr = rs.getString("address");
			
			getCust.add(new Customer(id,pass,name,addr));
		}
		
		return getCust;
	}

	@Override
	public Customer login(Customer vo) throws SQLException {
		Customer logcust = null;
		if(getCustomer(vo.getId())!=null) {
			logcust = vo;
		}
		return logcust;
	}

}
