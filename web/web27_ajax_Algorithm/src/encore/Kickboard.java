package encore;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Kickboard {

		public static int execute(File path) throws FileNotFoundException {
			int result = 0;
			Scanner sc = new Scanner(path);
			
			int x=0;
			int y=0; //좌표의 위치
			
			//scanner로부터 n*m행렬 생성
			int n = sc.nextInt();
			int m = sc.nextInt();
			int [][] arr = new int[n][m];
			sc.nextLine(); //nextInt가 엔터키를 읽지 않기때문에 안하면 빈칸+3열이 생김)
			boolean[][] visit = new boolean[n][m];
			
			for(int i=0; i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			//상하좌우 비교해  작은값으로 이동(BFS)
			
			//이동하며 넣을 queue
			HashMap<String, Integer> tmp = new HashMap<String, Integer>();
			while(x!=3 && y!=4) {
				int min = arr[x][y];
				tmp.put(x+","+y,arr[x][y]);
				if (x-1>0 && visit[x-1][y]==false) tmp.put(x-1+","+y,arr[x-1][y]);
				if (y-1>0 && visit[x][y-1]==false) tmp.put(x+","+(y-1),arr[x][y-1]);
				if (x+1<4 && visit[x+1][y]==false) tmp.put(x+1+","+y,arr[x+1][y]);
				if (y+1<5 && visit[x][y+1]==false) tmp.put(x+","+(y+1),arr[x][y+1]);
				
			}
			
			tmp.get(0);
			tmp.remove(0);
			return result;
		}

		public static void main(String[] args) throws FileNotFoundException {
			System.out.println(execute(new File("input.txt")));
		}

}
