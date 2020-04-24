package com.encore.vo;

import com.encore.utill.MyDate;

public class Manager extends Employee{

	private String dept;
	private int deptNo;
	
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptNo) {
		super(name,birthDate,salary);
		this.dept = dept;
		this.deptNo = deptNo;
	}

	public String getDept() {return dept;}

	public void setDept(String dept) {this.dept = dept;}

	public int getDeptNo() {return deptNo;}

	public void setDeptNo(int deptNo) {this.deptNo = deptNo;}

	@Override
	public String toString() {
		return super.toString()+", dept="+ dept + ", deptNo=" + deptNo;
	}


}
