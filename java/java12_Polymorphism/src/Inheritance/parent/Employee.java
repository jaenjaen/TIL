package Inheritance.parent;

import Inheritance.util.MyDate;

public class Employee {
	public static final double BASE_SALARY = 100.0; //�������� �빮�ڸ� ������� returnŸ�Ծտ� ������ STATIC FINAL �ٿ��ߵ�!!!
	private String name;
	private double salary;
	private MyDate bDay;
	
	//������ ��� ä���� ���� ����� ���� ���ڸ��� �⺻������ ä��� ��ü�� �����ϱ� ���� (���߿� ������� �� ����)
	public Employee() {}
	
	//������ ��� ä�� ��� ��
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
