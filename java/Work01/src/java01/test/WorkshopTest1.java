package java01.test;

public class WorkshopTest1 {

	public static void main(String[] args) {
		int n = 1;
		for(int i=0; i<5;i++) {
			for(int j=0; j<5; j++) {
				if(j-i>=0) {
					System.out.print(n +" ");
					n++;
				}
				else System.out.print("  ");
		}
		System.out.println();
		}
	}
}
