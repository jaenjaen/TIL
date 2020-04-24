package Inheritance.service;

import Inheritance.child.Engineer;
import Inheritance.child.Manager;
import Inheritance.child.Secretary;
import Inheritance.parent.Employee;

/*
 * �ּ� ����Ű ctrl+/
 * ctrl+shift + /
 */

public class PolymorphismService {

	//1.step 
	//Ư�� �Ŵ����� ���� �ڵ鸵 ���� ���� ���� �ڵ���
	/*public void handleManager(Manager m) {}
	public void handleEnginner(Engineer eg) {}
	public void handleSecretary(Secretary se) {}*/
	
	/*//2.step overloading
	public void handleEmployee(Manager m) {}
	public void handleEmployee(Engineer eg) {}
	public void handleEmployee(Secretary se) {}*/
	
	//3. step
	public void handleEmployee(Employee[] earr) {
		// ���� earr�� ����ִ� ������ ��ȣ���̶�� �μ� �ѹ��η� �����ϰ� �������
		for(Employee e : earr) {
			if(e instanceof Manager) {
				if(e.getName().equals("��ȣ��2")) {((Manager) e).changeDept("�ѹ���");
			}
			if(e instanceof Engineer) {}
			if(e instanceof Secretary) {}
			}
		}
	}
}
