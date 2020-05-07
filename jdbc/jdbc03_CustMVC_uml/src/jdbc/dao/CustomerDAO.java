package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.vo.Customer;

public interface CustomerDAO {
	Connection getConnect() throws SQLException;
	void CloseAll(PreparedStatement ps,Connection conn) throws SQLException;
	void CloseAll(ResultSet rs,PreparedStatement ps,Connection conn) throws SQLException;
	
	void registerCustomer(Customer vo) throws SQLException;
	void deleteCustomer(String id) throws SQLException;
	void deleteCustomer(Customer vo) throws SQLException;
	
	Customer getCustomer(String id) throws SQLException;
	ArrayList<Customer> getAllCustomer() throws SQLException;
	
	Customer login(Customer vo) throws SQLException;
}
