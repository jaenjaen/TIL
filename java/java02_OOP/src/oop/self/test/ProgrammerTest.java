package oop.self.test;
import oop.self.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		Programmer pr = new Programmer();
		
		pr.setProgrammer("¿Ã¿Á¿∫", 26, 300.0F, 100);
		System.out.println(pr.getProgrammer());
		System.out.println(pr.annualSalary());
	}

}
