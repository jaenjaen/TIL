package Inheritance.test;

import Inheritance.child.Engineer;
import Inheritance.child.Manager;
import Inheritance.child.Secretary;
import Inheritance.parent.Employee;
import Inheritance.util.MyDate;

public class PolymorphismTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("이수근",12000.0,new MyDate(1975, 1, 1));
		Manager m1 = new Manager("강호동", 23000.0, new MyDate(1972, 11, 1), "체육부");
		Engineer eg1 = new Engineer("박나래", 56000.0, new MyDate(1987, 3, 1), "R", 1000.0);
		Secretary s1 = new Secretary("박보검", 34000.0, new MyDate(1993, 7, 23), "강호동");
		
		m1.changeDept("기획부");
		System.out.println(e1.getDetails());
		System.out.println(m1.getDetails());
		System.out.println(eg1.getDetails());
		System.out.println(s1.getDetails());
		
		/////////////////////////////////////////////////////////////////////////// 상속 때문에 아래 형태가 가능함
		
		Employee e2 = new Manager("강호동2", 23000.0, new MyDate(1972, 11, 1), "체육부");
		Employee e3 = new Engineer("박나래2", 56000.0, new MyDate(1987, 3, 1), "R", 1000.0);
		Employee e4 = new Secretary("박보검2", 34000.0, new MyDate(1993, 7, 23), "강호동");
		
		//e3.changeTech("자바");
		
		//casting을 통해 자식의 메소드 사용
		/*
		Engineer eg3 = (Engineer) e3;
		eg3.changeTech("Java");*/
		
		System.out.println("****************************************************************************");
		System.out.println(e2.getDetails());
		System.out.println(e3.getDetails());
		System.out.println(e4.getDetails());
	}

}
