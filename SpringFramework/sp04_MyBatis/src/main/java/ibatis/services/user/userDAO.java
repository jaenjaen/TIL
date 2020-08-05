package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;

/*
 * 비즈니스 로직의 템플릿이 들어있음
 * mybatis-userservie-mapping10.xml 보고 하기~
 * mapping10.xml의 쿼리문 id값이 비즈니스 로직의 이름이 된다
 * 비즈니스 로직의 인자값은 parameterType 참조
 * 비즈니스 로직의 리턴값은 resultType 참조
 * */
public interface userDAO {
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String userId) throws Exception;
	
	User getUser(String userId)throws Exception;
	List<User> getUserList(User user)throws Exception;
}
