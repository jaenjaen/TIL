package condition.test;

import java.util.Random;

public class ConditionTest6 {

	public static void main(String[] args) {
		String result = "";
		Random r = new Random(); //����
		
		System.out.println("ū��? ������?");
		
		//0~99������ ������ ����
		 int num1 = r.nextInt(100); //nextInt(����)
		 
		 if (num1>50) result = "ū ��";
		 else result = "���� ��";
		
		 System.out.println(num1+"�� "+result+" �Դϴ�.");
		 System.out.printf("%d��(��) %s�Դϴ�.%n",num1,result); //%d�� ���� %s�� ���ڿ� printf�� �������̶�� ��
		 
		 int num2 = r.nextInt(10)+1;
		 result = (num2 % 2 == 0)?"¦��":"Ȧ��";
		 
		 System.out.printf("%d�� %s�Դϴ�.",num2,result);

	}

}
