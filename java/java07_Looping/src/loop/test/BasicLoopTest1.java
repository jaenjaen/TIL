package loop.test;
/*
 * �ݺ���
 * �ش��ϴ� ������ ���� ���� �ڵ���� ��� �����ϴ� ����
 * for/while/do-while
 */
public class BasicLoopTest1 {

	public static void main(String[] args) {
		
		System.out.println("for��");
		for(int i=0; i<=10;i++) {
			System.out.println(i+"hello for loop");
		}
		
		System.out.println("while��");
		int i =0;
		while(i<=10) {
			System.out.println(i+"hello for loop");
			i++;//update
		}
		
		System.out.println("do while��");
		
		int j = 0;
		do {
			System.out.println(j+"hello for loop");
			j++;//update
		} while(j<=10);
		
		System.out.println("����1");
		int tot = 0;
		int num;
		
		for(num =1; num<=100; num++) {
			if(num%2==0)
				continue; //���ǹ��� True�� �ǳʶ�
			tot +=num;
		}
		System.out.println("1���� 100���� Ȧ���� ����: "+tot+"�Դϴ�.");
	
		System.out.println("����2");
		int sum = 0;
		num = 0;
		
		for(num=0; ; num++) {
			sum+=num;
			if(sum>=100)
				break;
		}
		System.out.printf("sum: %d %n",sum);
		System.out.printf("num: %d %n",num);
	}
}
