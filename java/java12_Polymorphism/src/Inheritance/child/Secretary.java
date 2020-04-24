package Inheritance.child;

import Inheritance.parent.Employee;
import Inheritance.util.MyDate;

public class Secretary extends Employee {

	private String nameOfBoss;
	
	public Secretary(String name, double salary, MyDate bDay,String nameOfBoss) {
		super(name,salary,bDay);
		this.nameOfBoss = nameOfBoss;
	}

	//method 1. �״�� �����޾Ƽ� ->2. ��ħ
	public String getDetails() {
		return super.getDetails()+","+nameOfBoss; //employee�� getdetails ȣ��
	}

}
 