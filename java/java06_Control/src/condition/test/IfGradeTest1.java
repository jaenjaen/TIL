package condition.test;
/*
 * ��� �־��� ������ ���� ���� �ش� �ڵ���� �����ϴ� ����
 * ������ �帧�� ���������ν� �� �� ������ ���α׷��� ������� �� �ִ�.
 * 
 * if/ else if / else
 * switch ~ case
 */

public class IfGradeTest1 {

	public static void main(String[] args) {
		int grade = 87;
		
		if(grade >= 90 && grade <= 100) System.out.println("�����մϴ� A~");
		else if(grade >=80 && grade < 90) System.out.println("B~");
		else if(grade >=70 && grade<80) System.out.println("c~");
		else System.out.println("�� �����");

	}

}
