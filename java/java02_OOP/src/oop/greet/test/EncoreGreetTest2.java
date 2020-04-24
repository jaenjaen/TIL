package oop.greet.test;
/*
 * EncoreGreetTest1에서는 필드에 값을 직접적으로 입력
 * 필드의 갯수가 늘어난다면? 일일이 필드에 값을 입력하는 방식은 비효율적임
 * 
 * 해결책
 * 모든 필드의 값을 한번에 받아서 할당해주는 기능을 가진 함수를 새롭게 정의
 * test2에서는 그 함수를 호출하는 방식 사용
 */
import java.util.Scanner;
import oop.greet.EncoreGreet;

public class EncoreGreetTest2 {
	
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		EncoreGreet en = new EncoreGreet();
		en.setEncore("임채은", "HI!", 4, "데이터사이언스"); // method calling
		System.out.println(en.getEncore());
		en.sayHello();
	}

}
