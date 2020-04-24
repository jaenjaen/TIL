package array.test2;

public class ArrayMaxAndMinTest2 {

	public static void main(String[] args) {
		int[] score = {79,88,91,44,100,55,95};
		
		int min = score[0]; //�迭�� ù��° ������ �ʱ�ȭ
		int max = score[0]; // ���͵���
		
		/*
		 * Basic for
		for(int i=0; i<score.length;i++) {
			if(min> score[i]) min = score[i];
			if(max < score[i]) max = score[i];
		}*/
		
		
		//Advanced for
		for(int i : score) {
			if(min> i) min = i;
			if(max < i) max = i;
		}
		
		System.out.printf("�ּҰ��� %d �ִ밪�� %d \n",min,max);
	}

}
