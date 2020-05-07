package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		return null;
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
		
	}

	@Override
	public void deleteCustomer(String id) throws SQLException {
		
	}

	@Override
	public void deleteCustomer(Customer vo) throws SQLException {
		
	}

	@Override
	public Customer getCustomer(String id) throws SQLException {
		return null;
	}

	@Override
	public ArrayList<Customer> getAllCustomer() throws SQLException {
		return null;
	}

	@Override
	public Customer login(Customer vo) throws SQLException {
		return null;
	}

}
