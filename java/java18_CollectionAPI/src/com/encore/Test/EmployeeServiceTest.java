package com.encore.Test;

import com.encore.service.EmployeeService;
import com.encore.utill.MyDate;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		
		//1.생성 객체 calling 
		EmployeeService service = EmployeeService.getInstance();
		
		
		//2.객체 추가
		Engineer eg1 = new Engineer("이혜리",new MyDate(1994,6,9),3000.0,"java",100.0);
		Engineer eg2 = new Engineer("박나래",new MyDate(985,10,25),6000.0,"C/C++",100.0);
		Manager m1 = new Manager("장도연",new MyDate(1985,3,10),3700.0,"기획부",10);
		Manager m2 = new Manager("손담비",new MyDate(1975,3,6),6000.0,"교육부",50);
		Manager m3 = new Manager("공효진",new MyDate(1985,8,9),4000.0,"경영부",30);
		
		service.addEmployee(eg1);
		service.addEmployee(eg2);
		service.addEmployee(m1);
		service.addEmployee(m2);
		service.addEmployee(m2); // 안들어 오게 리턴
		service.addEmployee(m3);
		
		service.getEmployee();

		System.out.println("*****************delete****************");
		service.deleteEmployee("손담비");
		//삭제할때 사람없으면 리턴
		service.getEmployee();
		
		System.out.println("****************update*****************");
		service.updateEmployee(new Manager("공효진",new MyDate(1985,8,9),400,"총무부",20));
		
		service.getEmployee();
		
		
		System.out.println("****************find*****************");
		System.out.println(service.findEmployee(6000.0));
		
	}

}
