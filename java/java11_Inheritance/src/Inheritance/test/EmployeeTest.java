package Inheritance.test;

import Inheritance.child.Manager;
import Inheritance.parent.Employee;
import Inheritance.util.MyDate;

public class EmployeeTest {

	public static void main(String[] args) {
		//�θ�ü ����
		Employee e1 = new Employee("�̼���");
		Employee e2 = new Employee("��ȣ��",11000.0,new MyDate(1976, 2, 11));
		
		//�ڽİ�ü ����
		Manager m = new Manager("James",23000.0,new MyDate(1990, 1, 1),"���ߺ�");
		
		
		System.out.println(e1.getDetails());
		System.out.println(e2.getDetails());
		System.out.println(m.getDetails());
	}

}
