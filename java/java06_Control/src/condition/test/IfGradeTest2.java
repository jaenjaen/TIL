package condition.test;
/*
 * ������ ������� �̸��� ����ÿ� �Է� �޾Ƽ� ������ �ۼ�
 */
import java.util.Scanner;

public class IfGradeTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�̸��� ������ �Է��ϼ���: ");
		String name = sc.nextLine();
		int grade = sc.nextInt();
		
		
		if(grade >= 90 && grade <= 100) {
			System.out.println(name + ", �����մϴ� A~");
		}
		
		else if(grade >=80 && grade < 90) {
			System.out.println(name + ", B~");
		}
		
		else if(grade >=70 && grade<80) {
			System.out.println(name +", c~");
		}
		
		else {
			System.out.println(name + ", �� �����");
		}

	}

}
