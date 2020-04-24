package oop.javadoc.test;

import java.util.Scanner;

import oop.javadoc.JavaComment;

/**
 * main() ������ ������ �ϴ� ����Ŭ����
 * JavaComment ��ü�� ���� == �޸𸮿� �ø��� == Member(field, method)�� �޸𸮿� �ö󰣴�. 
 *
 */
public class JavaCommentTest {

	public static void main(String[] args) {
		JavaComment jc = new JavaComment();
		System.out.println(jc);
		
		//jc��� �̸��� ��ü�� ������ ����? ����Ϸ���
		//filed��� -> ���Ҵ�
		//�޼ҵ� ��� ->  ȣ�� (not calling, not working)
		
		jc.name = "Jenny";
		System.out.println(jc.scoreSum(100, 100)); // method calling

	}

}
