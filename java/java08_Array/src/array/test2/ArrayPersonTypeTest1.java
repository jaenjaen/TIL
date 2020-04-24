package array.test2;

import java.util.Scanner;

public class ArrayPersonTypeTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = -1;
		int ans = 0;
		
		//input
		int n = sc.nextInt();
		int[] people = new int[n];
		
		for(int i=0; i<people.length;i++) {
			people[i] = sc.nextInt();
		}
		
		//function
		int[] types = new int[n];
		for(int j = 0; j<types.length; j++){
			switch(j) {
			case 1:
				types[0]++;
				break;
			case 2:
				types[1]++;
				break;
			case 3:
				types[2]++;
				break;
			case 4:
				types[3]++;
				break;
			case 5:
				types[4]++;
				break;
			}
		}
		
		for(int p=0; p<types.length;p++) {
			if(max<types[p]) {
				max = types[p];
				ans = p+1;
			}
		}
	
		
		//output
		System.out.println(ans);

	}

}

/*
 * 6
 * 1 4 4 4 5 3
 */
