package Inheritance.child;

import Inheritance.parent.Employee;
import Inheritance.util.MyDate;

public class Manager extends Employee {

	private String dept;
	
	public Manager(String name, double salary, MyDate bDay,String dept) {
		super(name,salary,bDay);
		this.dept = dept;
	}

	//method 1. 그대로 물려받아서 ->2. 고침
	public String getDetails() {
		return super.getDetails()+","+dept; //employee의 getdetails 호출
	}
	
	public void changeDept(String dept) {
		this.dept = dept;
	}

}
 