package step4.test;

import service.OutletStoreService;
import vo.Customer;
import vo.Product;

public class OutletStoreServiceTest {

	public static void main(String[] args) {
		
		//������
		Customer[] csts = new Customer[3];
		csts[0] = new Customer(123,"�̳���","��赿");
		csts[1] = new Customer(321,"������","���ʵ�");
		csts[2] = new Customer(124,"����","��赿");
		
		//���� ������ ��ǰ�� ��������
		Product[] pros1 = {
				new Product("�����",8000,2),
				new Product("����ƾ ��Ǫ",18000,1),
				new Product("�ް�",5000,1),
				};
		
		Product[] pros2 = {
				new Product("�ƽ�Ŀ��",32000,3),
				new Product("���İ�Ƽ �ҽ�",55000,1),
				new Product("�ް�",6000,2),
				new Product("����û����",450000,1)
				};
		
		//�̳����� Ŀ��, ���İ�Ƽ�ҽ�, �ް�, ����û���⸦ ���� | ������ �����, ����ƾ, �ް� �����ϵ���
		//Customer�� Product�� Hasing�� �Ͼ (Has a Relation)
		
		csts[0].buyProducts(pros2);
		csts[1].buyProducts(pros1);
		
		
		//service ��ü ���� �޼ҵ� ȣ��
		OutletStoreService service = new OutletStoreService();
		
		
		System.out.println("1. Customer�� ������ ��� ��ǰ�� Maker�� ����մϴ�.");
		String[] prosname = service.getAllProductMaker(csts[0]);
		for(String name : prosname) System.out.printf("%s ",name);
		
		
		System.out.println("\n2. ��� ���� ������ �޾ƿɴϴ�.");
		String [] customerNames = service.getAllCustomer(csts);
		for(String name : customerNames) System.out.printf("%s ", name);
		
		System.out.println("\n3. Ư������ ��� ������ �޾ƿɴϴ�.");
		Customer c = service.getACustomer(csts, 123);
		
		System.out.println("4. ���� ������ ���� ��� ��ǰ�� ������ �޾ƿɴϴ�.");
		if(service.maxPriceProduct(csts[0]) == -1)
			System.out.println("���� ��ǰ�� �������� �ʽ��ϴ�.");
		else System.out.println(service.maxPriceProduct(csts[0]));
		
		System.out.println("5. ���� ��հ� �̻��� ��ǰ �̸��� �޾ƿɴϴ�.");
		String[] proname = service.getMoreAvgProduct(csts[0]);
		for(String name : proname) if (name != null)System.out.printf("%s ", name);
		

	}

}
