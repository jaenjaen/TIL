package exception.user.test;

import java.util.Scanner;

class ZeroBoom extends Exception{
	ZeroBoom(){
		this("This is ZeroBoomException..");
	};
	ZeroBoom(String msg){
		super(msg);
	};
}

class User{
	public void go(int n) throws ZeroBoom{
		int j = 111;
		
		System.out.println("2. 0넣음 안됩니당");
		if(n == 0) {
			//고의적 폭탄발생: jvm대신 exception 객체 생성  ->ArithmeticException
			throw new ZeroBoom("분모가 0이면 터집니다!!!");
		}
		
		//연산 j/n
	}
}


public class UserExceptionTest1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요: ");
		int num = sc.nextInt();
		
		User user = new User();
		
		try{
			System.out.println("1. go Calling.. ");
			user.go(num);
		 }
		catch(ZeroBoom e) {
			//e.printStackTrace();// 자취를 따라가서 몇라인에 왜 에러가 났는지 출력 근데 보안이 매우 취약 배포할때 쓰면 안됨
			System.out.println(e.getMessage()); // 개발/배포때 다 가능
			
		}
		System.out.println("3. 모든 기능을 수행하고 정상종료 합니다.");
	}
}
