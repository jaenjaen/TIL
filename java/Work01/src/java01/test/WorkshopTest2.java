package java01.test;

public class WorkshopTest2 {

	public static void main(String[] args) {
		int n = 1;
		int sp = 0;
		
		for(int i=0; i<6;i++) {
			for(int j=0; j<(6-sp); j++) {
				if(j > sp) {
					System.out.print(n +" ");
					n++;
				}
				else System.out.print("  ");
			}
			if(i<(5/2)) sp++;
			else sp--;
			System.out.println();
			}
	}
}
