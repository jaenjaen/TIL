package com.encore.Test;

import com.encore.service.EmployeeService;
import com.encore.utill.MyDate;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		
		//1.service ��ü ����
		EmployeeService service = new EmployeeService(5);
		
		
		//2.method�� ���� ȣ��
		System.out.println("***************����******************");
		service.addEngineer(new Engineer("������",new MyDate(1994,6,9),300,"java",100.0));
		service.addEngineer(new Engineer("��ȣ��",new MyDate(1970,6,11),600,"C/C++",100.0));
		service.addEngineer(new Engineer("������",new MyDate(1988,5,6),380,"java",100.0));
		service.addEngineer(new Engineer("�ڳ���",new MyDate(1985,10,25),420,"Python",100.0));
		service.addManager(new Manager("�մ��",new MyDate(1983,9,25),350,"�λ���",10));
		service.addManager(new Manager("�嵵��",new MyDate(1985,3,10),370,"�λ���",10));
		service.addManager(new Manager("��̶�",new MyDate(1975,3,6),600,"��ȹ��",50));
		service.addManager(new Manager("ȫ����",new MyDate(1985,8,9),400,"�濵��",30));
		
		service.printEngs();
		service.printMgs();

		System.out.println("*****************����****************");
		service.updateEngineer(400.0,"Python","������");
		service.updateManager(400,"�濵��",30,"�嵵��");

		service.printEngs();
		service.printMgs();

		
		System.out.println("****************����*****************");
		service.deleteEngineer("��ȣ��");
		service.deleteManager("��̶�");
		
		service.printEngs();
		service.printMgs();
		
		System.out.println("****************ã��*****************");
		Engineer e = service.findEngineer("�ڳ���");
		System.out.println(e.getDetail());

		Manager m = service.findManager("�մ��");
		System.out.println(m.getDetail());
		
		System.out.println("-�׷� ã��");
		Manager[] mng = service.findManager(30);
		for(Manager mn : mng) {
			if(mn== null) continue;
			System.out.println(mn.getDetail());}
	}

}
