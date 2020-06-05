package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAOimpl implements MemberDAO {
	
	//싱글톤
	private static MemberDAOimpl dao = new MemberDAOimpl();
	private MemberDAOimpl() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공****");
		}
		catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패****");
		}
	}
	public static MemberDAOimpl getInstance() {
		return dao;
	}
	
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("Database 연결***");
		return conn;
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
	
	public boolean isExist(String id, Connection conn) throws SQLException {
		
		String query = "SELECT id FROM member WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	@Override
	public void registerMember(MemberVO member)  {
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			if(!isExist(member.getId(),conn)) {
				String query = "INSERT INTO member(id,password,name,address) VALUES(?,?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, member.getId());
				ps.setString(2, member.getPassword());
				ps.setString(3, member.getName());
				ps.setString(4, member.getAddress());
				ps.executeUpdate();
				System.out.println(member.getName()+"님이 회원가입 하셨습니다.");
			}
			else System.out.println("이미 가입한 회원입니다");
		} catch (SQLException e) {
			System.out.println("registerMember SQL오류");
		}finally {
			try {
				closeAll(ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("resiterMember ps,conn 안닫힘");
			}
		}
	}

	@Override
	public ArrayList<MemberVO> showAllMembers(){
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> allMember = new ArrayList<>();
		String query = "SELECT * FROM member";
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				allMember.add(new MemberVO(rs.getString("id"),
										   rs.getString("name"),
										   rs.getString("address")));
			}
		} catch (SQLException e) {
			System.out.println("showAllMembers() 디비오류****");
		}finally {
			try {
				closeAll(rs, ps, conn);
			} catch (SQLException e) {
				System.out.println("showAllMembers() DB안닫힘****");
			}
		}
		
		return allMember;
	}

	@Override
	public MemberVO findByIdMember(String id) {
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO tmp = null;
		String query = "SELECT * FROM member where id = ?";
		
		try {
			conn= getConnection();
			
			if (isExist(id, conn)) {
				ps = conn.prepareStatement(query);
				ps.setString(1, id);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					tmp = new MemberVO(rs.getString("id"), rs.getString("name"), rs.getString("address"));
				}
			}
			
			else {
				System.out.println("존재하지 않는 id입니다.");
			}
		} catch (SQLException e) {
			System.out.println("findByIdMember 디비 연결 오류");
		}finally {
			try {
				closeAll(rs, ps, conn);
			} catch (SQLException e) {
				System.out.println("findByIdMember 안닫힘");
			}
		}
		return tmp;
	}
	
	/*public static void main(String[] args) {
		MemberDAOimpl dao = MemberDAOimpl.getInstance();
		ArrayList<MemberVO> tmp = new ArrayList<>();
		
		dao.registerMember(new MemberVO("raingurl","yeji12","예지","뉴욕"));
		tmp = dao.showAllMembers();
		for(MemberVO i:tmp) {
			System.out.println(i.toString());
		}
		dao.findByIdMember("11");
		System.out.println(dao.findByIdMember("greentea").toString());
	}*/
}
