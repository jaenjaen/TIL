package oop.encapsulation;
/*
 * 월 먼저 입력
 * 날짜입력
 */
public class MyDate {
	public int month;
	public int day;
	
	public int getMonth() {
		return month;
	}
	//로컬변수와 필드의 이름이 같을때 구분하기 위해서 필드앞에 this를 지정한다.
	public void setMonth(int month) {
		if (month<1 || month>12) {
			System.out.println("존재하지 않는 월입니다.");
			System.exit(0); //프로그램 탈출 여기서 프로그램 종료 안되는 이유 : 스캐너가 안닫혀서
		}
		else this.month = month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		switch(month) {
		case 2:
			if(day>=1 && day<=28) this.day = day;
			else {
				System.out.println("존재하지 않는 일입니다.");
				System.exit(0); // 필드 초기화를 못함 == 0으로 반환
				}
			break;
		case 4: case 6: case 9: case 11:
			if(day>=1 && day<=30) this.day = day;
			else{
				System.out.println("존재하지 않는 일입니다.");
				System.exit(0); // 필드 초기화를 못함 == 0으로 반환
				}
			break;
		default :
			if(day>=1 && day<=28) this.day = day;
			else{
				System.out.println("존재하지 않는 일입니다.");
				System.exit(0); // 필드 초기화를 못함 == 0으로 반환
				}
		}
	}	
}
