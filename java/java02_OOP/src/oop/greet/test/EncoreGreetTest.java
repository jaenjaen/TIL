package oop.greet.test;

import java.util.Scanner;
import oop.greet.EncoreGreet;

public class EncoreGreetTest {
	
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		EncoreGreet en = new EncoreGreet();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�̸��� �Է��ϼ���: ");
		String scName = sc.nextLine();
		System.out.println("�޼����� �Է��ϼ���: ");
		String scMsg = sc.nextLine();
		
		en.name = scName;
		en.message = scMsg;
		en.sayHello();
	}

}
