package step2.test;

import vo.Product;

public class PersonArrayTest {
	public static void main(String[ ] a) {
	//�迭�� ������ �ʱ�ȭ�� �ѹ���
	Product[] pros = {
			new Product("HP",120000,2),
			new Product("SAMSUNG",230000,3),
			new Product("LG",50000,13)
			};
	
	//product��ǰ���� ����� ���
	System.out.println ("��ǰ ����Ŀ������ ����մϴ�.");
	for(Product pro:pros) System.out.println(pro.getMaker()+ " ");
	
	//��ǰ�߿��� ���ݴ밡 20������ ȣ���ϴ� ��ǰ�� ����Ŀ�� ����
	
	for(Product pro: pros ) {
		if (pro.getPrice()>=200000) System.out.printf("%s�� ������ %d �Դϴ�.\n",pro.getMaker(),pro.getPrice());
	}
	
	//��ü��ǰ�� �� ������ ���� ���
	int sum =0;
	for(Product pro:pros) {
		sum += pro.getPrice();
	}
	System.out.printf("������ ������ %d",sum);
	}

}
