package Inheritance.child;

import Inheritance.parent.Employee;
import Inheritance.util.MyDate;

public class Engineer extends Employee {

	private String tech;
	private double bonus;
	
	public Engineer(String name, double salary, MyDate bDay,String tech,double bonus) {
		super(name,salary,bDay);
		this.tech = tech;
		this.bonus = bonus;
	}

	//method 1. 그대로 물려받아서 ->2. 고침
	public String getDetails() {
		return super.getDetails()+","+tech+","+bonus; //employee의 getdetails 호출
	}

	public void changeTech(String tech) {
		this.tech = tech;
	}

	public double getBonus() {
		return bonus;
	}
	
	

}
 