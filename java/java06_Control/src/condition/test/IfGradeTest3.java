package condition.test;
/*
 * ��޿� ���� �ش��ϴ� case���� ����ǵ���
 * ���� �ۼ�
 * ������ �Է¹޾Ҵٸ�
 * ����� �Է¹޵��� ���� ����
 */
import java.util.Scanner;

public class IfGradeTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�̸��� ����� �Է��ϼ���: ");
		String name = sc.nextLine();
		String grade = sc.next();
		
		String msg = "";
		switch(grade) {
		case "A":
			msg = name + "�� ������� 90 ~ 100�Դϴ�.";
			break;
		case "B":
			msg = name + "�� ������� 80 ~ 89�Դϴ�.";
			break;
		case "C":
			msg = name + "�� ������� 70 ~ 79�Դϴ�.";
			break;
		default :
			msg = name + "�� ������ؾ��մϴ�.";	
		}
		
		System.out.println(msg);
	}
}
