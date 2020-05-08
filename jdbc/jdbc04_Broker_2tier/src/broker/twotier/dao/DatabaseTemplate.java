package broker.twotier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.excetion.DuplicateSSNException;
import broker.twotier.excetion.InvaildTransactionException;
import broker.twotier.excetion.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.ShareRec;
import broker.twotier.vo.StockRec;

public interface DatabaseTemplate {
	Connection getConnet() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException;
	
	
	//business CRUD
	void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException;
	void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException;
	void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException;
	
	Vector<ShareRec> getPortolio(String ssn)throws SQLException;
	CustomerRec getCustonmer(String ssn) throws SQLException, InvaildTransactionException;
	ArrayList<CustomerRec> getAllCustomers() throws SQLException, RecordNotFoundException;
	ArrayList<StockRec> getAllPortfolio(String ssn) throws SQLException, RecordNotFoundException;
	
	//business 특화로직
	void buyShares(String ssn, String symbol, int quantity) throws SQLException, RecordNotFoundException;
	void sellShares(String ssn, String symbol, int quantity) throws SQLException, RecordNotFoundException;
}
