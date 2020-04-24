package oop.self;

public class Programmer {
	public String name;
	public int age;
	public float salary;
	public int bouns;
	
	public void setProgrammer(String n, int a, float s, int b) {
		//field initialization
		name = n;
		age = a;
		salary = s;
		bouns = b;
	}
	
	public String getProgrammer() {
		return name+", "+age+", "+salary+", "+bouns;
	}
	
	public float annualSalary() {
		return salary * 12 + bouns;
	}

}
