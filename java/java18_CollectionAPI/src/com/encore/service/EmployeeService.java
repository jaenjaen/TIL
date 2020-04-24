package com.encore.service;

import java.util.ArrayList;

import com.encore.utill.MyDate;
import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

//Manager [] ArrayList<Employee>
public class EmployeeService {
	private ArrayList<Employee> list;
	
	private static EmployeeService service = new EmployeeService();
	
	private EmployeeService() {
		list = new ArrayList<>();
	}
	
	public static EmployeeService getInstance() {
		return service;
	}
	
	public void addEmployee(Employee e) {
		if(!list.contains(e)) {
			list.add(e);
			System.out.println(e.getName()+"님이 추가 되었습니다.");
		}
		else System.out.println(e.getName()+"님은 이미 직원 입니다.");
	}
	
	public void deleteEmployee(String name) {
		boolean find = false;
		for(Employee e: list) {
			if(e.getName().equals(name)) {
				find = true;
				System.out.println(name+"님이 삭제 되었습니다.");
				list.remove(e);
				break;
			}
		}
		if(find == false) System.out.println(name+"님이 존재하지 않습니다.");
	}
	
	public void updateEmployee(Employee e) {
		boolean find = false;
		for(Employee emp: list) {
			if(emp.getName().equals(e.getName())) {
				find = true;
				System.out.println(e.getName()+"님의 정보가 업데이트 되었습니다.");
				int i = list.indexOf(emp);
				list.set(i, e);
				break;
			}
		}
		if(find == false) System.out.println(e.getName()+"님이 존재하지 않습니다.");
	}
	
	public ArrayList<Employee> findEmployee(double salary) {
		ArrayList<Employee> temp = new ArrayList<>();
		for(Employee e : list) {
			if(e.getSalary()==salary) 	temp.add(e);		
		}
		return temp;
	}	

	//추가
	public void getEmployee() {
		for(Employee e: list) System.out.println(e);
	}
}
