package com.encore.pms.service;

import java.util.List;

import com.encore.pms.dto.Company;
import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

public interface IPhoneService {
	int phoneRegister(Phone phone);

	int phoneDelete(List<String> list);

	Phone getPhone(String num);

	List<Phone> getAllPhone();
	
	UserInfo login(UserInfo user);
	
	List<Company> getAllCompany();
}
