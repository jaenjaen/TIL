package array.test1;

/*
 * �迭�� ����� ������ �� ������
 * ����� �ٸ� �迭�� ��Ҹ� copy�Ͽ� ������ �� ����
 */
public class ArraycopyTest2 {

	public static void main(String[] args) {
		 int[] target = {1,2,3,4,5,6};
		 int[] source = {10,9,8,7,6,5,4,3,2,1};
		 
		 //target�� 8 7 6 5 4 3���� �ϰ� ����
		 
		 System.arraycopy(source, 2, target, 0, target.length);
		 
		 for(int p:target) {
			 System.out.println(p+" ");
		 }

	}

}
