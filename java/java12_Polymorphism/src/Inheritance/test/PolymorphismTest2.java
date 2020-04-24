package Inheritance.test;

import Inheritance.child.Engineer;
import Inheritance.child.Manager;
import Inheritance.child.Secretary;
import Inheritance.parent.Employee;
import Inheritance.service.PolymorphismService;
import Inheritance.util.MyDate;

public class PolymorphismTest2 {

	public static void main(String[] args) {
		/////////////////////////////////////////////////////////////////////////// 상속 때문에 아래 형태가 가능함
		System.out.println("********************Polymorphism으로 객체생성****************************");
		Employee e2 = new Manager("강호동2", 23000.0, new MyDate(1972, 11, 1), "체육부");
		Employee e3 = new Engineer("박나래2", 56000.0, new MyDate(1987, 3, 1), "R", 1000.0);
		Employee e4 = new Secretary("박보검2", 34000.0, new MyDate(1993, 7, 23), "강호동");
		Employee e5 = new Manager("강호동3", 23000.0, new MyDate(1972, 11, 1), "체육부");
		
		//Heterogeneous Collection
		Employee[] emps = {e2,e3,e4,e5};
		
		PolymorphismService service = new PolymorphismService();
		service.handleEmployee(emps);
		
		for(Employee emp :emps) System.out.println(emp.getDetails());
	}

}
