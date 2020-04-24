package Inheritance.child;

import Inheritance.parent.Employee;
import Inheritance.util.MyDate;

public class Manager extends Employee {

	private String dept;
	
	public Manager(String name, double salary, MyDate bDay,String dept) {
		super(name,salary,bDay);
		this.dept = dept;
	}

	//method 1. �״�� �����޾Ƽ� ->2. ��ħ
	public String getDetails() {
		return super.getDetails()+","+dept; //employee�� getdetails ȣ��
	}
	
	public void changeDept(String dept) {
		this.dept = dept;
	}

}
 