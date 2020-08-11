package com.encore.pms.dao;

import java.util.List;

import com.encore.pms.dto.Company;
import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

public interface IPhoneDAO {
	int phoneRegister(Phone phone);

	int phoneDelete(List<String> list);

	Phone getPhone(String num);

	List<Phone> getAllPhone();

	UserInfo login(UserInfo user);
	
	List<Company> getAllCompany();
}
