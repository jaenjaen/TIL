package com.encore.vo;

import com.encore.utill.MyDate;

public class Engineer {
	private String name;
	private MyDate birthDate;
	private double salary;
	private String tech;
	private double bonus;
	
	public Engineer(String name, MyDate birthDate, double salary, String tech, double bonus) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
		this.tech = tech;
		this.bonus = bonus;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public double getSalary() {
		return salary;
	}

	public String getTech() {
		return tech;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getName() {return name;}
	
	public String getDetail() {return name+"의 생일은 "+birthDate.getDate()+"이고 연봉은"+salary+"이며,주요기술은 "+tech+" 보너스는"+bonus+"입니다.";}
}
