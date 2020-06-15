package encore;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kickboard {

		public static int execute(File path) throws FileNotFoundException {
			int result = 0;
			Scanner sc = new Scanner(path);
			
			int x=0;
			int y=0; //좌표의 위치
			int x1=x;
			int y1=y;
			
			//scanner로부터 n*m행렬 생성
			int n = sc.nextInt();
			int m = sc.nextInt();
			int [][] arr = new int[n][m];
			sc.nextLine(); //nextInt가 엔터키를 읽지 않기때문에 안하면 빈칸+3열이 생김)
			
			for(int i=0; i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					arr[i][j] = sc.nextInt();
					System.out.println(arr[i][j]);
				}
			}
			//상하좌우 비교해  작은값으로 이동
			int min = arr[x][y];
			while(x!=3 && y!=4) {
				x1 = x;
				y1 = y;
				//위로 이동 불가 || 옆(상,하)으로 이동불가 || 아래로 이동불가
				//상
				if(arr[x-1][y]<arr[x][y] && arr[x-1][y]<min) {
					min = arr[x-1][y];
					x1 = x-1;
				}
				//하
				if(arr[x+1][y]<arr[x][y] && arr[x+1][y]<min) {
					min = arr[x+1][y];
					x1 = x+1;
				}
				//좌
				if(arr[x][y-1]<arr[x][y] && arr[x][y-1]<min) {
					min = arr[x][y-1];
					y1 = y-1;
				}
				//우
				if(arr[x][y+1]<arr[x][y] && arr[x][y+1]<min) {
					min = arr[x][y-1];
					y1 = y+1;
				}
				//이동한 값이 n,m값이면 이동 종료 하고 result++;(3,4)
			}
			
			
			
			
			
			
			
			
			return result;
		}

		public static void main(String[] args) throws FileNotFoundException {
			System.out.println(execute(new File("input.txt")));
		}

}
