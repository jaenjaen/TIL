package oop.greet.test;
/*
 * EncoreGreetTest1������ �ʵ忡 ���� ���������� �Է�
 * �ʵ��� ������ �þ�ٸ�? ������ �ʵ忡 ���� �Է��ϴ� ����� ��ȿ������
 * 
 * �ذ�å
 * ��� �ʵ��� ���� �ѹ��� �޾Ƽ� �Ҵ����ִ� ����� ���� �Լ��� ���Ӱ� ����
 * test2������ �� �Լ��� ȣ���ϴ� ��� ���
 */
import java.util.Scanner;
import oop.greet.EncoreGreet;

public class EncoreGreetTest2 {
	
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		EncoreGreet en = new EncoreGreet();
		en.setEncore("��ä��", "HI!", 4, "�����ͻ��̾�"); // method calling
		System.out.println(en.getEncore());
		en.sayHello();
	}

}
