package Inheritance.test;

import Inheritance.child.Engineer;
import Inheritance.child.Manager;
import Inheritance.child.Secretary;
import Inheritance.parent.Employee;
import Inheritance.util.MyDate;

public class PolymorphismTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("�̼���",12000.0,new MyDate(1975, 1, 1));
		Manager m1 = new Manager("��ȣ��", 23000.0, new MyDate(1972, 11, 1), "ü����");
		Engineer eg1 = new Engineer("�ڳ���", 56000.0, new MyDate(1987, 3, 1), "R", 1000.0);
		Secretary s1 = new Secretary("�ں���", 34000.0, new MyDate(1993, 7, 23), "��ȣ��");
		
		m1.changeDept("��ȹ��");
		System.out.println(e1.getDetails());
		System.out.println(m1.getDetails());
		System.out.println(eg1.getDetails());
		System.out.println(s1.getDetails());
		
		/////////////////////////////////////////////////////////////////////////// ��� ������ �Ʒ� ���°� ������
		
		Employee e2 = new Manager("��ȣ��2", 23000.0, new MyDate(1972, 11, 1), "ü����");
		Employee e3 = new Engineer("�ڳ���2", 56000.0, new MyDate(1987, 3, 1), "R", 1000.0);
		Employee e4 = new Secretary("�ں���2", 34000.0, new MyDate(1993, 7, 23), "��ȣ��");
		
		//e3.changeTech("�ڹ�");
		
		//casting�� ���� �ڽ��� �޼ҵ� ���
		/*
		Engineer eg3 = (Engineer) e3;
		eg3.changeTech("Java");*/
		
		System.out.println("****************************************************************************");
		System.out.println(e2.getDetails());
		System.out.println(e3.getDetails());
		System.out.println(e4.getDetails());
	}

}
