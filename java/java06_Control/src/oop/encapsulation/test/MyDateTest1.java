package oop.encapsulation.test;

import java.util.Scanner;

/*
 * �� �Է¹޾Ƽ� ������ �������Դϴ� ���
 */
import oop.encapsulation.MyDate;

public class MyDateTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyDate md = new MyDate();
		
		System.out.println("���� �Է��ϼ���");
		int month = sc.nextInt();
		System.out.println("���� �Է��ϼ���");
		int day = sc.nextInt();
		
		md.setMonth(month);
		md.setDay(day);
		
		System.out.println("������ ��¥�� "+md.getMonth()+"�� "+md.getDay()+"�� �Դϴ�.");
	}
}
