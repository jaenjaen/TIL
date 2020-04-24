package condition.test;
/*
 * 제어문 주어진 조건이 참일 때만 해당 코드블럭을 수행하는 문장
 * 문장의 흐름을 제어함으로써 좀 더 정교한 프로그램이 만들어질 수 있다.
 * 
 * if/ else if / else
 * switch ~ case
 */

public class IfGradeTest1 {

	public static void main(String[] args) {
		int grade = 87;
		
		if(grade >= 90 && grade <= 100) System.out.println("축하합니다 A~");
		else if(grade >=80 && grade < 90) System.out.println("B~");
		else if(grade >=70 && grade<80) System.out.println("c~");
		else System.out.println("응 재수강");

	}

}
