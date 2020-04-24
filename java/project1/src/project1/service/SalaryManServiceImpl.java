package project1.service;

import java.util.ArrayList;

import project1.vo.SalaryMan;

public class SalaryManServiceImpl implements SalaryManService {
	ArrayList<SalaryMan> sms = new ArrayList<>();

	@Override
	public void work(SalaryMan s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vacation(SalaryMan s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nightwork(SalaryMan s) {
		int minusHP = 30;
		int plusSalary = calRandom() + 50;
		
		if(sms.contains(s)) {
			for(SalaryMan sm : sms) {
				if(sm.getSsn() == s.getSsn()) {
					sm.setHP(s.getHP()-minusHP);
					sm.setSalary(s.getSalary()+plusSalary);
				}
			}
			System.out.println(s.getName()+"님의 체력이"+minusHP+"하락하고, 월급이 "+plusSalary+"원 상승하였습니다.");
			}
		else System.out.println(s.getName()+"님은 존재하지 않습니다.");
	}

	@Override
	public void addSalaryMan(SalaryMan s) {
		sms.add(s);
	}

	@Override
	public void updateSalaryMan(int ssn, String position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSalaryMan(int ssn) {
		SalaryMan s = null;
		
		for(SalaryMan sm : sms) {
			if(sm.getSsn() == ssn) s = sm;
		}
		if(sms.contains(s)) sms.remove(s);
		else System.out.println(ssn+"은 존재하지 않는 번호입니다.");
	}

	@Override
	public SalaryMan getSalaryMan(int ssn) {
		return null;
	}

	@Override
	public ArrayList<SalaryMan> searchHP(int hp) {
		
		return null;
	}

	@Override
	public ArrayList<SalaryMan> searchSalary(int salary) {
		ArrayList<SalaryMan> s = new ArrayList<>();
		
		for(SalaryMan sm : sms) {
			if(sm.getSalary() == salary) s.add(sm);
		}
		
		return s;
	}

	@Override
	public int calRandom() {
		int rd = (int) (Math.random()*10);
		return rd;
	}

}
