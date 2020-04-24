package condition.test;

import java.util.Random;

public class ConditionTest6 {

	public static void main(String[] args) {
		String result = "";
		Random r = new Random(); //유용
		
		System.out.println("큰수? 작은수?");
		
		//0~99사이의 임의의 정수
		 int num1 = r.nextInt(100); //nextInt(범위)
		 
		 if (num1>50) result = "큰 수";
		 else result = "작은 수";
		
		 System.out.println(num1+"은 "+result+" 입니다.");
		 System.out.printf("%d는(은) %s입니다.%n",num1,result); //%d는 숫자 %s는 문자열 printf는 포맷팅이라는 뜻
		 
		 int num2 = r.nextInt(10)+1;
		 result = (num2 % 2 == 0)?"짝수":"홀수";
		 
		 System.out.printf("%d는 %s입니다.",num2,result);

	}

}
