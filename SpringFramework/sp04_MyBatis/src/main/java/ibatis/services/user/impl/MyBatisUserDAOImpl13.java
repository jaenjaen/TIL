package ibatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ibatis.services.domain.User;
import ibatis.services.user.userDAO;

@Repository
public class MyBatisUserDAOImpl13 implements userDAO {
	
	@Autowired
	private SqlSession sqlsession;
	
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
