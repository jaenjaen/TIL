package Inheritance.child;

import Inheritance.parent.Employee;
import Inheritance.util.MyDate;

public class Secretary extends Employee {

	private String nameOfBoss;
	
	public Secretary(String name, double salary, MyDate bDay,String nameOfBoss) {
		super(name,salary,bDay);
		this.nameOfBoss = nameOfBoss;
	}

	//method 1. 그대로 물려받아서 ->2. 고침
	public String getDetails() {
		return super.getDetails()+","+nameOfBoss; //employee의 getdetails 호출
	}

}
 