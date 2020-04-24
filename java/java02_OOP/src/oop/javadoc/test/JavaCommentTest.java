package oop.javadoc.test;

import java.util.Scanner;

import oop.javadoc.JavaComment;

/**
 * main() 가지고 실행을 하는 실행클래스
 * JavaComment 객체를 생성 == 메모리에 올린다 == Member(field, method)가 메모리에 올라간다. 
 *
 */
public class JavaCommentTest {

	public static void main(String[] args) {
		JavaComment jc = new JavaComment();
		System.out.println(jc);
		
		//jc라는 이름의 객체를 생성한 이유? 사용하려고
		//filed사용 -> 값할당
		//메소드 사용 ->  호출 (not calling, not working)
		
		jc.name = "Jenny";
		System.out.println(jc.scoreSum(100, 100)); // method calling

	}

}
