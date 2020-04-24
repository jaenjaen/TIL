package array.test2;

import java.util.Arrays;
import java.util.Random;

/*
 * 정렬
 * 배열과 같은 자료구조에 대해서는 정렬에 대한 요구사항이 빈번하게 일어난다.
 * 정렬을 구현하기 위한 알고리즘 중 가장 대표적인 버블정렬에 대해서 살펴보겠다.
 * library
 */

public class ArrayBubbleSortingTest4 {
	
	public static void main(String[] args) {
		Random r = new Random();
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		System.out.println("초기화 완료");
		for(int i:arr) System.out.print(i+" ");
		
		Arrays.sort(arr);
		
		System.out.println("\n 정렬완료");
		for(int j:arr) System.out.print(j+" ");
		
	}
}
