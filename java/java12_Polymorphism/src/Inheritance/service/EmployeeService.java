package Inheritance.service;

import Inheritance.child.Engineer;
import Inheritance.parent.Employee;

public class EmployeeService {

	//특정 employee 출력
	public void printInfo(Employee e) {System.out.println(e.getDetails());}
	
	public void printAllInfo(Employee[] earr) {for(Employee e : earr) printInfo(e);}
	
	//직원의 이름을 넣고 해당 직원 검색
	public Employee findEmployeeByName(Employee[] earr, String name) {
		Employee emp = null;
		
		for(Employee e : earr) {
			if(e.getName().equals(name)) emp = e;
		}
		return emp;
	}
	
	//특정직원의 연봉 반환
	public int getAnnualSalary(Employee e) {
		int annualSalary = 0;
		
		annualSalary = (int)e.getSalary()*12;
		
		if(e instanceof Engineer) {
			Engineer eg = ((Engineer)e);
			annualSalary += eg.getBonus();
		}
		
		return annualSalary;
	}
	
	//총연봉
	public int getTotalCoast(Employee[] earr) {
		int total = 0;
		for(Employee e: earr) total += getAnnualSalary(e);
		return total;
	}
}
