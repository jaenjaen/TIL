package Inheritance.parent;

import Inheritance.util.MyDate;

public class Employee {
	public static final double BASE_SALARY = 100.0; //변수명이 대문자면 상수값임 return타입앞에 무조건 STATIC FINAL 붙여야됨!!!
	private String name;
	private double salary;
	private MyDate bDay;
	
	//정보를 모두 채우지 않은 사람을 위헤 빈자리를 기본값으로 채우고 객체를 생성하기 위해 (나중에 집어넣을 수 있음)
	public Employee() {}
	
	//정보를 모두 채운 사람 용
	public Employee(String name, double salary, MyDate bDay) {
		super();
		this.name = name;
		this.salary = salary;
		this.bDay = bDay;
	}
	
	public Employee(String name) {
		this(name,BASE_SALARY,new MyDate(1980, 1, 1));
	}

	public String getDetails() {
		return name+","+salary+","+bDay;
	}

	public static double getBaseSalary() {
		return BASE_SALARY;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public MyDate getbDay() {
		return bDay;
	}
	
	
}
