package array.test2;

import java.util.Random;

/*
 * 정렬
 * 배열과 같은 자료구조에 대해서는 정렬에 대한 요구사항이 빈번하게 일어난다.
 * 정렬을 구현하기 위한 알고리즘 중 가장 대표적인 버블정렬에 대해서 살펴보겠다.
 * 정렬 전{9,2,5,3} -> 정렬 후 {2,3,5,9}
 * 
 * 2,5 비교 --> 2,5 유지
 * 5,3 비교 --> temp라는 임시변수를 만들어 5저장-> swap
 * bubble sort
 * 인접한 두수를 비교해서 ㅡㄴ수를 뒤로 보내는 방법
 * 
 * 주의!!
 */

public class ArrayBubbleSortingTest3 {
	
	public static void main(String[] args) {
		Random r = new Random();
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		System.out.println("초기화 완료");
		for(int i:arr) System.out.print(i+" ");
		
		int temp = 0;
		for(int j=0; j<arr.length; j++) {	
			for(int i=0; i<arr.length-1;i++) {
				if(arr[i] > arr[i+1]) {
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp; 
				}
			}
		}
		
		System.out.println("\n 정렬완료");
		for(int j:arr) System.out.print(j+" ");
		
	}
}
