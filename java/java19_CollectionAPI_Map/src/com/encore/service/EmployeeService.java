package com.encore.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;
// Manager[ ]을 ArrayList<Employee> 사용
public class EmployeeService {
	
	//추가...
	private Map<Integer, Employee> map;
	Set<Integer> key;
	Iterator<Integer> it;
	
	//싱글톤
	private static EmployeeService service = new EmployeeService();	
	private EmployeeService(){
		map = new HashMap<Integer, Employee>();
	}
	public static EmployeeService getInstance() {
		return service;
	}
	
	
	//추가
	public void getEmployee() {
		key = map.keySet();
		it = key.iterator();
		
		while(it.hasNext()) {
			System.out.println(map.get(it.next()));
		}
		
	}
	
	public void addEmployee(Employee e) {	
		map.put(e.getSsn(), e);
		System.out.println(e.getName()+"님이 추가 되었습니다.");
	}
	
	
	public void deleteEmployee(int ssn) {	
		key = map.keySet();
		it = key.iterator();
		boolean check = false;
		while(it.hasNext()) {
			Integer next = it.next();
			if(map.get(next).getSsn() == ssn) {
				check = true;
				System.out.println(map.get(next).getName()+"님이 삭제되었습니다.");
				map.remove(next);
				break;
			}
		}
		if(!check) System.out.println(ssn+"은 존재하지 않는 번호 입니다.");
	}	
	
	
	public void updateEmployee(Employee e, int ssn) {
		key = map.keySet();
		it = key.iterator();
		boolean check = false;
		
		while(it.hasNext()) {
			Integer next = it.next();
			if(map.get(next).getSsn() == ssn) {
				check = true;
				System.out.println(map.get(next).getName()+"님의 정보가 수정되었습니다.");
				map.replace(next, map.get(next), e);
			}
		}
		if(!check) System.out.println(ssn+"은 존재하지 않는 번호 입니다.");
	}	
	
	
	public Employee findEmployee(int ssn) {
		Employee e = null;
		key = map.keySet();
		it = key.iterator();
		boolean check = false;
		
		while(it.hasNext()) {
			Integer next = it.next();
			if(map.get(next).getSsn() == ssn) {
				check = true;
				e =map.get(next);
			}
		}
		
		if(!check) System.out.println(ssn+"은 존재하지 않는 번호 입니다.");
		return e;
	}	
	
	public ArrayList<Employee> findEmployee(double sal) {
		
		return null;
	}	
	
}







