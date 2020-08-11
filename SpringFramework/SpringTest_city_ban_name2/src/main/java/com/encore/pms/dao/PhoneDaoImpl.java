package com.encore.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.pms.dto.Company;
import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

@Repository
public class PhoneDaoImpl implements IPhoneDAO{

	@Autowired
	private SqlSession session;
	
	private String mapper = "PhoneMapper.";

	public int phoneRegister(Phone phone) {
		return session.insert(mapper+"phoneRegister",phone);
	}

	public int phoneDelete(List<String> list) {
		return session.delete(mapper+"phoneDelete",list);
	}

	public Phone getPhone(String num) {
		return session.selectOne(mapper+"selectPhone",num);
	}

	public List<Phone> getAllPhone() {
		return session.selectList(mapper+"selectPhone");
	}

	public UserInfo login(UserInfo user) {
		return session.selectOne(mapper+"login",user);
	}

	public List<Company> getAllCompany() {
		return session.selectList(mapper+"getAllCompany");
	}
}
