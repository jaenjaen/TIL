package oop.encapsulation.test;

import java.util.Scanner;

/*
 * 값 입력받아서 ㅇㅇ월 ㅇㅇ일입니다 출력
 */
import oop.encapsulation.MyDate;

public class MyDateTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyDate md = new MyDate();
		
		System.out.println("월을 입력하세요");
		int month = sc.nextInt();
		System.out.println("일을 입력하세요");
		int day = sc.nextInt();
		
		md.setMonth(month);
		md.setDay(day);
		
		System.out.println("오늘의 날짜는 "+md.getMonth()+"월 "+md.getDay()+"일 입니다.");
	}
}
