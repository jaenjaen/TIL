package Inheritance.service;

import Inheritance.child.Engineer;
import Inheritance.child.Manager;
import Inheritance.child.Secretary;
import Inheritance.parent.Employee;

/*
 * 주석 단축키 ctrl+/
 * ctrl+shift + /
 */

public class PolymorphismService {

	//1.step 
	//특정 매니저의 정보 핸들링 제일 좋지 않은 코드임
	/*public void handleManager(Manager m) {}
	public void handleEnginner(Engineer eg) {}
	public void handleSecretary(Secretary se) {}*/
	
	/*//2.step overloading
	public void handleEmployee(Manager m) {}
	public void handleEmployee(Engineer eg) {}
	public void handleEmployee(Secretary se) {}*/
	
	//3. step
	public void handleEmployee(Employee[] earr) {
		// 만약 earr에 들어있는 직원이 강호동이라면 부서 총무부로 변경하고 정보출력
		for(Employee e : earr) {
			if(e instanceof Manager) {
				if(e.getName().equals("강호동2")) {((Manager) e).changeDept("총무부");
			}
			if(e instanceof Engineer) {}
			if(e instanceof Secretary) {}
			}
		}
	}
}
