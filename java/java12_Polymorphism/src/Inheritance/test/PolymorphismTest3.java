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
		/////////////////////////////////////////////////////////////////////////// ��� ������ �Ʒ� ���°� ������
		System.out.println("********************Polymorphism���� ��ü����****************************");
		Employee e1 = new Manager("��ȣ��", 23000.0, new MyDate(1972, 11, 1), "ü����");
		Employee e2 = new Engineer("�ڳ���", 56000.0, new MyDate(1987, 3, 1), "R", 1000.0);
		Employee e3 = new Secretary("�ں���", 34000.0, new MyDate(1993, 7, 23), "��ȣ��");
		Employee e4 = new Manager("��ȣ��2", 23000.0, new MyDate(1972, 11, 1), "ü����");
		
		//Heterogeneous Collection
		Employee[] emps = {e1,e2,e3,e4};
		
		EmployeeService service = new EmployeeService();
		
		System.out.println();
		service.printInfo(e2);
		
		System.out.println();
		service.printAllInfo(emps);
		
		System.out.println();
		System.out.println((service.findEmployeeByName(emps, "�ں���").getDetails()));
		
		System.out.println();
		System.out.println(service.getAnnualSalary(e2));
		
		System.out.println();
		System.out.println(service.getTotalCoast(emps));
		
		
	}

}
