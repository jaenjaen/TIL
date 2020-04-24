package Inheritance.test;

import Inheritance.child.Engineer;
import Inheritance.child.Manager;
import Inheritance.child.Secretary;
import Inheritance.parent.Employee;
import Inheritance.service.EmployeeService;
import Inheritance.service.PolymorphismService;
import Inheritance.util.MyDate;

public class PolymorphismTest3 {

	public static void main(String[] args) {
		/////////////////////////////////////////////////////////////////////////// 상속 때문에 아래 형태가 가능함
		System.out.println("********************Polymorphism으로 객체생성****************************");
		Employee e1 = new Manager("강호동", 23000.0, new MyDate(1972, 11, 1), "체육부");
		Employee e2 = new Engineer("박나래", 56000.0, new MyDate(1987, 3, 1), "R", 1000.0);
		Employee e3 = new Secretary("박보검", 34000.0, new MyDate(1993, 7, 23), "강호동");
		Employee e4 = new Manager("강호동2", 23000.0, new MyDate(1972, 11, 1), "체육부");
		
		//Heterogeneous Collection
		Employee[] emps = {e1,e2,e3,e4};
		
		EmployeeService service = new EmployeeService();
		
		System.out.println();
		service.printInfo(e2);
		
		System.out.println();
		service.printAllInfo(emps);
		
		System.out.println();
		System.out.println((service.findEmployeeByName(emps, "박보검").getDetails()));
		
		System.out.println();
		System.out.println(service.getAnnualSalary(e2));
		
		System.out.println();
		System.out.println(service.getTotalCoast(emps));
		
		
	}

}
