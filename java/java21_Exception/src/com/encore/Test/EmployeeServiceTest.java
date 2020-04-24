package com.encore.Test;

import com.encore.exception.DuplicateNameException;
import com.encore.exception.RecodeNotFoundException;
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
		
		//동일인 오류 잡기
		try{
			service.addEmployee(eg1);
		}
		catch(DuplicateNameException e) {
			System.out.println(e.getMessage());
		}
		try{
			service.addEmployee(eg2);
		}catch(DuplicateNameException e) {
			System.out.println(e.getMessage());
		}
		try{
			service.addEmployee(m1);
		}catch(DuplicateNameException e) {
			System.out.println(e.getMessage());
		}try{
			service.addEmployee(m2);
		}catch(DuplicateNameException e) {
			System.out.println(e.getMessage());
		}try{
			service.addEmployee(m2);
		}catch(DuplicateNameException e) {
			System.out.println(e.getMessage());
		}try{
			service.addEmployee(m3);
		}catch(DuplicateNameException e) {
			System.out.println(e.getMessage());
		}
		
		service.getEmployee();

		System.out.println("*****************delete****************");
		try{
			service.deleteEmployee("손담비");
		}catch(RecodeNotFoundException e) {
			System.out.println(e.getMessage());
		}
		//삭제할때 사람없으면 리턴
		service.getEmployee();
		
		System.out.println("****************update*****************");
		try{
			service.updateEmployee(new Manager("공효진",new MyDate(1985,8,9),400,"총무부",20));
		}catch(RecodeNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		service.getEmployee();
		
		
		System.out.println("****************find*****************");
		System.out.println(service.findEmployee(6000.0));
		
	}

}




