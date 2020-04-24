package com.encore.service;

import com.encore.utill.MyDate;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeService {
	Manager [] ms;
	int midx;
	
	Engineer [] egs;
	int egidx;
	
	
	//생성자
	public EmployeeService(int size) {
		ms = new Manager[size];
		egs = new Engineer[size];
	}
	public void addManager(Manager m) {
		ms[midx++] = m;
	}
	
	public void addEngineer(Engineer eg) {
		egs[egidx++] = eg;
	}
	
	public void deleteManager(String name) {
		for(int i =0; i<midx;i++) {
				if(ms[i].getName().equals(name)) {
					for(int j = i; j<midx;j++) {
						if(ms[j] == null) break;
						ms[j] = ms[j+1];
				}
					ms[midx--] = null;
			}
		}
	}
	
	public void deleteEngineer(String name) {
		for(int i =0; i<egidx;i++) {
				if(egs[i].getName().equals(name)) {
					for(int j = i; j<egidx;j++) {
						if(egs[j] == null) break;
						egs[j] = egs[j+1];
				}
					egs[egidx--] = null;
			}
		}
	}
	
	public void updateManager(double s, String dept, int deptNo,String n) {
		for(int i=0; i<midx;i++) {
			if(n.equals(ms[i].getName())) {
				ms[i].setSalary(s);
				ms[i].setDept(dept);
				ms[i].setDeptNo(deptNo);
			}
		}
	}
	
	public void updateEngineer(double s, String tec,String n) {
		for(int i=0; i<egidx;i++) {
			if(n.equals(egs[i].getName())) {
				egs[i].setSalary(s);
				egs[i].setTech(tec);
			}
		}
	}
	
	//오버로딩
	public Manager findManager(String name) {
		Manager m = null;
		for(int i=0; i<midx;i++) {
			if(name.equals(ms[i].getName())) m = ms[i];
		}
		return m;
		}
	
	public Manager[] findManager(int deptno) {
		Manager[] mngs = new Manager[ms.length];
		int idx = 0;
		for(Manager tmp : ms) {
			if (tmp == null) continue;
			if(deptno == tmp.getDeptNo()){
				mngs[idx++] = tmp;
			}
		}
		return mngs;}
	
	public Engineer findEngineer(String name) {
		Engineer eg = null;
		for(int i=0; i<egidx;i++) {
			if(name.equals(egs[i].getName())) eg = egs[i];
		}
		return eg;
	}
	
	public void printEngs() {
		if(egs != null) {
			for(Engineer e: egs) {
				if (e == null) break;
				System.out.println(e.getDetail());
			}
		}
	}
	
	public void printMgs() {
		if(egs != null) {
			for(Manager m: ms) {
				if (m == null) break;
				System.out.println(m.getDetail());
			}
		}
	}
}
