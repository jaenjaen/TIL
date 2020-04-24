package self.test;

import java.util.Scanner;

public class PatternGameTest {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		String ans = "";
	
		if((n/10)%3 ==0) {
			if ((n%10)%3 == 0) {
				System.out.println("@@");
				System.exit(0);
			}
			System.out.println("@");
		}
		else {
			if ((n%10)%3 == 0) { 
				System.out.println("@");
			System.exit(0);
			}
			ans = String.valueOf(n);
		}
	}
	
}
