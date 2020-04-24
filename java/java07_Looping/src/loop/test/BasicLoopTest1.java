package loop.test;
/*
 * 반복문
 * 해당하는 조건이 참인 동안 코드블럭을 계속 수행하는 로직
 * for/while/do-while
 */
public class BasicLoopTest1 {

	public static void main(String[] args) {
		
		System.out.println("for문");
		for(int i=0; i<=10;i++) {
			System.out.println(i+"hello for loop");
		}
		
		System.out.println("while문");
		int i =0;
		while(i<=10) {
			System.out.println(i+"hello for loop");
			i++;//update
		}
		
		System.out.println("do while문");
		
		int j = 0;
		do {
			System.out.println(j+"hello for loop");
			j++;//update
		} while(j<=10);
		
		System.out.println("예제1");
		int tot = 0;
		int num;
		
		for(num =1; num<=100; num++) {
			if(num%2==0)
				continue; //조건문이 True면 건너뜀
			tot +=num;
		}
		System.out.println("1부터 100까지 홀수의 합은: "+tot+"입니다.");
	
		System.out.println("예제2");
		int sum = 0;
		num = 0;
		
		for(num=0; ; num++) {
			sum+=num;
			if(sum>=100)
				break;
		}
		System.out.printf("sum: %d %n",sum);
		System.out.printf("num: %d %n",num);
	}
}
