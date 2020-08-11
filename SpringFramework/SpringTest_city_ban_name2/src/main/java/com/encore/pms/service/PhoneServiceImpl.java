package com.encore.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.pms.dao.IPhoneDAO;
import com.encore.pms.dto.Company;
import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;



@Service
public class PhoneServiceImpl implements IPhoneService{

	@Autowired
	private IPhoneDAO phoneDao;
	
	@Transactional
	public int phoneRegister(Phone phone) {
		return phoneDao.phoneRegister(phone);
	}

	@Transactional
	public int phoneDelete(List<String> list) {
		return phoneDao.phoneDelete(list);
	}

	public Phone getPhone(String num) {
		return phoneDao.getPhone(num);
	}

	public List<Phone> getAllPhone() {
		return phoneDao.getAllPhone();
	}

	public UserInfo login(UserInfo user) {
		return phoneDao.login(user);
	}

	public List<Company> getAllCompany() {
		return phoneDao.getAllCompany();
	}

}
