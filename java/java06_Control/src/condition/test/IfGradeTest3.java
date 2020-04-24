package condition.test;
/*
 * 등급에 따라 해당하는 case문이 실행되도록
 * 로직 작성
 * 성적을 입력받았다면
 * 등급을 입력받도록 로직 수정
 */
import java.util.Scanner;

public class IfGradeTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름과 등급을 입력하세요: ");
		String name = sc.nextLine();
		String grade = sc.next();
		
		String msg = "";
		switch(grade) {
		case "A":
			msg = name + "의 점수대는 90 ~ 100입니다.";
			break;
		case "B":
			msg = name + "의 점수대는 80 ~ 89입니다.";
			break;
		case "C":
			msg = name + "의 점수대는 70 ~ 79입니다.";
			break;
		default :
			msg = name + "는 재수강해야합니다.";	
		}
		
		System.out.println(msg);
	}
}
