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
		
		System.out.println("1. 모든 상품의 Maker를 출력합니다.");
		service.printMakers(pros);
		
		System.out.println("\n2. 모든 상품의 총가격을 받아옵니다.");
		System.out.println(service.getTotalPrice(pros));
		
		System.out.println("3. 모든 상품의 평균가를 받아옵니다.");
		System.out.println(service.getAvgPrice(pros));
		
		System.out.println("4. 특정 가격 이상의 제품을 받아옵니다.");
		service.printOverPrice(pros, 200000);
		
		System.out.println("\n5. 특정 회사의 제품을 받아옵니다.");
		Product[] prod = service.getcertainMaker(pros, "HP");
		for(Product p :prod) {
			if(p==null) continue;
			System.out.println(p.getMaker()+", "+p.getPrice());
		}

	}

}
