package com.encore.vo;

import com.encore.utill.MyDate;

public class Manager {
	private String name;
	private MyDate birthDate;
	private double salary;
	private String dept;
	private int deptNo;
	
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptNo) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
		this.dept = dept;
		this.deptNo = deptNo;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public double getSalary() {
		return salary;
	}

	public String getDept() {
		return dept;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getName() {return name;}

	public String getDetail() {return name+"의 생일은 "+birthDate.getDate()+"이고 연봉은 "+salary+"이며, "+deptNo+"."+dept+" 소속입니다.";}
	
}
