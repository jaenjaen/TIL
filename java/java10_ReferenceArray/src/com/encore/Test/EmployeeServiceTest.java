package com.encore.Test;

import com.encore.service.EmployeeService;
import com.encore.utill.MyDate;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		
		//1.service 객체 생성
		EmployeeService service = new EmployeeService(5);
		
		
		//2.method를 각각 호출
		System.out.println("***************생성******************");
		service.addEngineer(new Engineer("이혜리",new MyDate(1994,6,9),300,"java",100.0));
		service.addEngineer(new Engineer("강호동",new MyDate(1970,6,11),600,"C/C++",100.0));
		service.addEngineer(new Engineer("유병재",new MyDate(1988,5,6),380,"java",100.0));
		service.addEngineer(new Engineer("박나래",new MyDate(1985,10,25),420,"Python",100.0));
		service.addManager(new Manager("손담비",new MyDate(1983,9,25),350,"인사팀",10));
		service.addManager(new Manager("장도연",new MyDate(1985,3,10),370,"인사팀",10));
		service.addManager(new Manager("라미란",new MyDate(1975,3,6),600,"기획팀",50));
		service.addManager(new Manager("홍진영",new MyDate(1985,8,9),400,"경영팀",30));
		
		service.printEngs();
		service.printMgs();

		System.out.println("*****************수정****************");
		service.updateEngineer(400.0,"Python","유병재");
		service.updateManager(400,"경영팀",30,"장도연");

		service.printEngs();
		service.printMgs();

		
		System.out.println("****************삭제*****************");
		service.deleteEngineer("강호동");
		service.deleteManager("라미란");
		
		service.printEngs();
		service.printMgs();
		
		System.out.println("****************찾기*****************");
		Engineer e = service.findEngineer("박나래");
		System.out.println(e.getDetail());

		Manager m = service.findManager("손담비");
		System.out.println(m.getDetail());
		
		System.out.println("-그룹 찾기");
		Manager[] mng = service.findManager(30);
		for(Manager mn : mng) {
			if(mn== null) continue;
			System.out.println(mn.getDetail());}
	}

}
