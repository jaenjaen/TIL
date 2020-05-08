package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

import broker.twotier.excetion.DuplicateSSNException;
import broker.twotier.excetion.InvaildTransactionException;
import broker.twotier.excetion.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.ShareRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

//DuplicateSSNException - 중복
//RecodeNotFoundException - recode not found (안갖고있은데 팔때도 포함)
//InvaildTransactionException - 100개 가지고 있는데 150개 팔때

public class Database implements DatabaseTemplate{
	
	public Database(String serverIp) throws ClassNotFoundException{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공...");
	}

	//공통 로직
	@Override
	public Connection getConnet() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	public boolean isExist(String ssn, Connection conn) throws SQLException{
		//query문 나오기 전에 존재 유무 확인
		String sql = "Select ssn From Customer WHere ssn=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, ssn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	//원래 오류는 던지는데 closeall이 무조건 진행되어야되서 finally써야함
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnet();
			
			if(!isExist(cust.getSsn(),conn)) {
				String query = "INSERT INTO customer(ssn,cust_name,address) VALUES (?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate()+"명 Insert OK .... addCustomer()....");
			}else {
				throw new DuplicateSSNException(cust.getName()+"님은 이미 회원입니다.");
			}
			
		}finally{closeAll(ps, conn);}
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnet();
			
			if(isExist(ssn, conn)) {
				String query = "DELETE FROM customer WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, ssn);
				
				System.out.println(ps.executeUpdate()+"명이 삭제되었습니다....deleteCustomer()...");
			} else {
				throw new RecordNotFoundException("존재하지 않는 ssn입니다.");
			}
		}finally {closeAll(ps, conn);}
		
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnet();
			
			if(isExist(cust.getSsn(), conn)) {
				String query = "UPDATE customer SET ssn=?, cust_name=?, address=? WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				ps.setString(4, cust.getSsn());
				
				System.out.println(ps.executeUpdate()+"명의 정보가 수정되었습니다....updateCustomer()...");
				
			}else {
				throw new RecordNotFoundException(cust.getName()+"님은 존재하지 않는 회원입니다.");
			}
		}finally {closeAll(ps, conn);}
	}

	@Override
	public Vector<ShareRec> getPortolio(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<ShareRec> tmp = new Vector<>();
		ShareRec sr =null;
		
		try {
			conn = getConnet();
			String query = "Select s.* FROM shares s, customer c WHERE s.ssn = c.ssn AND c.ssn = ?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				sr = new ShareRec(rs.getString("ssn"),
								  rs.getString("symbol"),
								  rs.getInt("quantity"));
				tmp.add(sr);
			}
			System.out.println(tmp.size()+"개의 포트폴리오가 검색되었습니다....getPortolio()...");
		}finally {closeAll(rs,ps,conn);}
		
		return tmp;
	}

	@Override
	public CustomerRec getCustonmer(String ssn) throws SQLException, InvaildTransactionException {
		CustomerRec tmpCust = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnet();
			String query = "SELECT * FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				tmpCust = new CustomerRec(rs.getString("ssn"),
										  rs.getString("cust_name"),
										  rs.getString("address"));
				System.out.println(tmpCust.getName()+"님의 정보가 검색되었습니다 ....getCustomer()...");
			}else {
				throw new InvaildTransactionException("존재하지 않는 회원입니다.");
			}
			
		}finally {closeAll(rs,ps,conn);}
		
		return tmpCust;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException, RecordNotFoundException {
		ArrayList<CustomerRec> tmp = new ArrayList<>();
		CustomerRec tmpC = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnet();
			String query = "Select * from customer";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				tmpC = new CustomerRec(rs.getString("ssn"),
									   rs.getString("cust_name"),
									   rs.getString("address"));
				tmp.add(tmpC);
			}
			
			if(tmp.isEmpty()) throw new RecordNotFoundException("회원이 존재하지 않습니다.");
			else System.out.println("정보가 검색되었습니다 ....getAllCustomers()...");
			
		}finally {closeAll(rs, ps, conn);}
		return tmp;
	}

	@Override
	public ArrayList<StockRec> getAllPortfolio(String ssn) throws SQLException, RecordNotFoundException {
		ArrayList<StockRec> tmp = new ArrayList<>();
		StockRec tmpS = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnet();
			String query = "SELECT t.* FROM stock t, shares h, customer c "
						+ "WHERE h.ssn = c.ssn AND t.symbol = h.symbol;";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				tmpS = new StockRec(rs.getString("symbol"),
									 rs.getFloat("price"));
				
				tmp.add(tmpS);
			}
			
			if(tmp.isEmpty()) throw new RecordNotFoundException("주식이 존재하지 않습니다.");
			else System.out.println("정보가 검색되었습니다 ....getAllPortfolio()...");
			
		}finally {closeAll(rs, ps, conn);}
		
		return tmp;
	}

	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		String query ="";
		
		try {
			conn = getConnet();
			if(isExist(ssn, conn)) {
				int tmp = getQuantity(ssn, conn);
				
				if(!isZero(ssn, conn)) {
					query = "INSERT INTO shares(ssn,symbol,quantity) VALUES(?,?,?)";
					ps = conn.prepareStatement(query);
					
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					ps.setInt(3, quantity+tmp);
					
					System.out.println(ps.executeUpdate()+"첫 구매 성공! ....buyShares()...");
				}
				else {
					query = "UPDATE shares SET ssn=?, symbol=?, quantity=? WHERE ssn=?";
					ps = conn.prepareStatement(query);
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					ps.setInt(3, quantity+tmp);
					ps.setString(4, ssn);
					
					System.out.println(ps.executeUpdate()+"구매 성공! ....buyShares()...");
				}
			}else throw new RecordNotFoundException("존재하지 않는 회원입니다.");
			
		}finally {closeAll(ps, conn);}
	}

	@Override
	public void sellShares(String ssn, String symbol, int quantity) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		String query ="";
		
		try {
			conn = getConnet();
			if(isExist(ssn, conn)) {
				int tmp = getQuantity(ssn, conn);
				
				if(!isZero(ssn, conn)) {
					query = "INSERT INTO shares(ssn,symbol,quantity) VALUES(?,?,?)";
					ps = conn.prepareStatement(query);
					
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					ps.setInt(3, quantity+tmp);
					
					System.out.println(ps.executeUpdate()+"첫 구매 성공! ....buyShares()...");
				}
				else {
					query = "UPDATE shares SET ssn=?, symbol=?, quantity=? WHERE ssn=?";
					ps = conn.prepareStatement(query);
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					ps.setInt(3, quantity+tmp);
					ps.setString(4, ssn);
					
					System.out.println(ps.executeUpdate()+"구매 성공! ....buyShares()...");
				}
			}else throw new RecordNotFoundException("존재하지 않는 회원입니다.");
			
		}finally {closeAll(ps, conn);}
	}
	
	public int getQuantity(String ssn, Connection conn) throws SQLException{
		int tmp = 0;
		ResultSet rs = null;
		String query = "SELECT h.quantity FROM shares h, customer c "
				+ "WHERE c.ssn =? AND h.ssn = c.ssn";
		PreparedStatement ps = conn.prepareStatement(query);
	
		ps.setString(1, ssn);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			tmp = rs.getInt("h.quantity");
		}
		return tmp;
	}
	
	public Boolean isZero(String ssn, Connection conn) throws SQLException{
		String query = "SELECT quantity FROM shares WHERE ssn =?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, ssn);
		
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	}

}
