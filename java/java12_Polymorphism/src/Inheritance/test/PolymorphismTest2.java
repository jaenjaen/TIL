package Inheritance.test;

import Inheritance.child.Engineer;
import Inheritance.child.Manager;
import Inheritance.child.Secretary;
import Inheritance.parent.Employee;
import Inheritance.service.PolymorphismService;
import Inheritance.util.MyDate;

public class PolymorphismTest2 {

	public static void main(String[] args) {
		/////////////////////////////////////////////////////////////////////////// ��� ������ �Ʒ� ���°� ������
		System.out.println("********************Polymorphism���� ��ü����****************************");
		Employee e2 = new Manager("��ȣ��2", 23000.0, new MyDate(1972, 11, 1), "ü����");
		Employee e3 = new Engineer("�ڳ���2", 56000.0, new MyDate(1987, 3, 1), "R", 1000.0);
		Employee e4 = new Secretary("�ں���2", 34000.0, new MyDate(1993, 7, 23), "��ȣ��");
		Employee e5 = new Manager("��ȣ��3", 23000.0, new MyDate(1972, 11, 1), "ü����");
		
		//Heterogeneous Collection
		Employee[] emps = {e2,e3,e4,e5};
		
		PolymorphismService service = new PolymorphismService();
		service.handleEmployee(emps);
		
		for(Employee emp :emps) System.out.println(emp.getDetails());
	}

}
