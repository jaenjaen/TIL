package exception.user.test;

import java.util.Scanner;

class UnderAgeException extends Exception{
	public UnderAgeException() {
		this("19세 미만은 관람이 어렵습니다.");
	}
	
	public UnderAgeException(String msg) {
		super(msg);
	};
}


class AdultMovie{
	public void entrance(int age) throws UnderAgeException{
		//들어온 나이가 19세 미만이면 성인영화 관람불가 시키고
		//19세 이상이면 입장을 허용하도록 문장제어
		//사용자제외 예외 클래스 : UnderAgeException으로 함
		
		if(age < 19) {
			throw new UnderAgeException();
		}
		else System.out.println("영화관으로 입장하세요.");
	}
}

public class UserExceptionTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신의 나이를 입력:");
		int age = sc.nextInt();
		
		AdultMovie am = new AdultMovie();
		System.out.println("성인 영화관 입장 여부를 판단합니다.: ");
		try{
			am.entrance(age);
		}
		catch(UnderAgeException e){
			System.out.println(e.getMessage());
		}
		
	}

}
