package ibatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ibatis.services.domain.User;
import ibatis.services.user.userDAO;

/*
 * persistence Layer component(Bean)
 * SQLsession을 Hasing하는 클래스
 * 1)필드에 sqlsession 선언
 * 2) setter로 주입
 * */
public class MyBatisUserDAOImpl10 implements userDAO {
	
	private SqlSession sqlsession;
	
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
		System.out.println(getClass().getName()+".setSqlSession() call");
	}

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlsession.insert("UserMapper10.addUser",user);
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		return sqlsession.update("UserMapper10.updateUser",user);
	}

	@Override
	public int removeUser(String userId) throws Exception {
		return sqlsession.delete("UserMapper10.removeUser",userId);
	}

	@Override
	public User getUser(String userId) throws Exception {
		return sqlsession.selectOne("UserMapper10.getUser", userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> users = sqlsession.selectList("UserMapper10.getUserList",user);
		return users;
	}

}
