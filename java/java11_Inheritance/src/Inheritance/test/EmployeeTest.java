package Inheritance.test;

import Inheritance.child.Manager;
import Inheritance.parent.Employee;
import Inheritance.util.MyDate;

public class EmployeeTest {

	public static void main(String[] args) {
		//부모객체 생성
		Employee e1 = new Employee("이수근");
		Employee e2 = new Employee("강호동",11000.0,new MyDate(1976, 2, 11));
		
		//자식객체 생성
		Manager m = new Manager("James",23000.0,new MyDate(1990, 1, 1),"개발부");
		
		
		System.out.println(e1.getDetails());
		System.out.println(e2.getDetails());
		System.out.println(m.getDetails());
	}

}
