package condition.test;
/*
 * 성적과 대상자의 이름을 실행시에 입력 받아서 로직을 작성
 */
import java.util.Scanner;

public class IfGradeTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름과 성적을 입력하세요: ");
		String name = sc.nextLine();
		int grade = sc.nextInt();
		
		
		if(grade >= 90 && grade <= 100) {
			System.out.println(name + ", 축하합니다 A~");
		}
		
		else if(grade >=80 && grade < 90) {
			System.out.println(name + ", B~");
		}
		
		else if(grade >=70 && grade<80) {
			System.out.println(name +", c~");
		}
		
		else {
			System.out.println(name + ", 응 재수강");
		}

	}

}
