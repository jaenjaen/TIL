package array.test2;

import java.util.Random;

/*
 * ����
 * �迭�� ���� �ڷᱸ���� ���ؼ��� ���Ŀ� ���� �䱸������ ����ϰ� �Ͼ��.
 * ������ �����ϱ� ���� �˰��� �� ���� ��ǥ���� �������Ŀ� ���ؼ� ���캸�ڴ�.
 * ���� ��{9,2,5,3} -> ���� �� {2,3,5,9}
 * 
 * 2,5 �� --> 2,5 ����
 * 5,3 �� --> temp��� �ӽú����� ����� 5����-> swap
 * bubble sort
 * ������ �μ��� ���ؼ� �Ѥ����� �ڷ� ������ ���
 * 
 * ����!!
 */

public class ArrayBubbleSortingTest3 {
	
	public static void main(String[] args) {
		Random r = new Random();
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
		}
		System.out.println("�ʱ�ȭ �Ϸ�");
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
		
		System.out.println("\n ���ĿϷ�");
		for(int j:arr) System.out.print(j+" ");
		
	}
}
