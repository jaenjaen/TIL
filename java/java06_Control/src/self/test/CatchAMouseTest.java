package self.test;

import java.util.Scanner;

public class CatchAMouseTest {
	
	public static String solve(int x, int y, int z) {
		int dis1 = Math.abs(x-z);
		int dis2 = Math.abs(y-z);
		String msg = "";
		
		if (dis1>dis2) return "Cat B catch Mouse";
		else if (dis1<dis2) return"Cat A catch Mouse";
		else return "Mouse Escape!";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//순서대로 값을 받음
		System.out.println(solve(a,b,c));
	}

}
