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
		if(map.containsKey(e.getSsn())) {
			System.out.println(e.getName()+"이미 회원이십니다.");
			return;}
		else {
			map.put(e.getSsn(), e);
			System.out.println(e.getName()+"님이 추가 되었습니다.");
		}
	}
	
	
	public void deleteEmployee(int ssn) {	
		Employee emp = map.remove(ssn);
		if (emp == null) System.out.println("삭제할 대상이 존재하지 않습니다.");
		else System.out.println(emp.getName()+"님이 삭제되었습니다.");
	}	
	
	
	public void updateEmployee(Employee e, int ssn) {
		if(map.containsKey(ssn)) {
			map.put(ssn, e);
			System.out.println(e.getName()+"님의 정보가 수정되었습니다.");
		}
		else System.out.println("수정할 대상이 존재하지 않습니다.");
	}	
	
	
	public Employee findEmployee(int ssn) {
		return map.get(ssn);
	}	
	
	public ArrayList<Employee> findEmployee(double sal) {
		ArrayList<Employee> es = new ArrayList<>();
		
		key = map.keySet();
		it = key.iterator();
		boolean check = false;
		
		while(it.hasNext()) {
			Integer next = it.next();
			if(map.get(next).getSalary() <= sal) {
				check = true;
				es.add(map.get(next));
			}
		}
		
		return es;
	}	
	
}







