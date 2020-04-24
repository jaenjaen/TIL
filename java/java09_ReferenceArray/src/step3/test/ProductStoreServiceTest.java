package step3.test;

import service.ProductStoreSerive;
import vo.Product;

public class ProductStoreServiceTest {

	public static void main(String[] args) {
		ProductStoreSerive service = new ProductStoreSerive();
		Product[] pros = {
				new Product("HP",120000,2),
				new Product("SAMSUNG",230000,3),
				new Product("LG",500000,13),
				new Product("HP",500000,1)
				};
		
		System.out.println("1. ��� ��ǰ�� Maker�� ����մϴ�.");
		service.printMakers(pros);
		
		System.out.println("\n2. ��� ��ǰ�� �Ѱ����� �޾ƿɴϴ�.");
		System.out.println(service.getTotalPrice(pros));
		
		System.out.println("3. ��� ��ǰ�� ��հ��� �޾ƿɴϴ�.");
		System.out.println(service.getAvgPrice(pros));
		
		System.out.println("4. Ư�� ���� �̻��� ��ǰ�� �޾ƿɴϴ�.");
		service.printOverPrice(pros, 200000);
		
		System.out.println("\n5. Ư�� ȸ���� ��ǰ�� �޾ƿɴϴ�.");
		Product[] prod = service.getcertainMaker(pros, "HP");
		for(Product p :prod) {
			if(p==null) continue;
			System.out.println(p.getMaker()+", "+p.getPrice());
		}

	}

}
