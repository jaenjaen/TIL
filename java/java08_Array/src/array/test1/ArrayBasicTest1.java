package array.test1;

public class ArrayBasicTest1 {

	String type = "�迭";
	public String type() {
		return type;
	}
	public static void main(String[] args) {
		
		//ArrayExam exam = new ArrayExam();
		//1. ����� ����
		int[] arr = new int[3];//��ü

/*		for(int i=0; i<arr.length;i++) { //length�� �Լ� �ƴ�
			System.out.println("Defalut Balude :: "+arr[i]);
		}
*/
		//���� for�� x�� y�ȿ��� ���ư��� �͸� �����ϸ� ��
		for(int p : arr) {
			System.out.print(p + " ");
		}
		System.out.println("\n");
		
		//System.out.println("\n"+exam); // array.test1���ִ� array Exam�� �ּҴ� ******�̴�. (����� ���� ���ڰ� �ּҰ�)
		//System.out.println("\n"+exam.tostring()); // ���� ���� ��� (tostring�� �����Ǵ� ��)
		System.out.println(arr);
		
		//2. �迭�� �ʱ�ȭ
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		
		for(int p: arr) {
			System.out.print(p+" ");
		}
		
		
		//3. ���� ���� �ʱ�ȭ �ѹ���
		
		int[] arr2 = {11,22,33};
		for(int p:arr2) {
			System.out.print(p+" ");
		}
		System.out.println();
		//4.�迭 ũ�� Ȯ��
		System.out.printf("�迭�� ũ���: %d \n",arr2.length);
		
		//5.�迭 Ȯ��? -> �迭�� �߰� resizing �Ұ� ������ ����� ���ο� ��ü�� ������
		
		
		arr2 = new int[5]; 
		arr2[3] = 44; arr2[4] =55;
		for(int p:arr2) {
			System.out.print(p+" ");
		}
	}

}
