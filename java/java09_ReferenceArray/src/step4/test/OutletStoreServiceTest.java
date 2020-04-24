package step4.test;

import service.OutletStoreService;
import vo.Customer;
import vo.Product;

public class OutletStoreServiceTest {

	public static void main(String[] args) {
		
		//고객생성
		Customer[] csts = new Customer[3];
		csts[0] = new Customer(123,"이나영","방배동");
		csts[1] = new Customer(321,"김태희","서초동");
		csts[2] = new Customer(124,"원빈","방배동");
		
		//고객이 구매할 상품들 정보생성
		Product[] pros1 = {
				new Product("진라면",8000,2),
				new Product("엘라스틴 샴푸",18000,1),
				new Product("달걀",5000,1),
				};
		
		Product[] pros2 = {
				new Product("맥심커피",32000,3),
				new Product("스파게티 소스",55000,1),
				new Product("달걀",6000,2),
				new Product("공기청정기",450000,1)
				};
		
		//이나영이 커피, 스파게티소스, 달걀, 공기청정기를 구매 | 김태희 진라면, 엘라스틴, 달걀 구매하도록
		//Customer와 Product의 Hasing이 일어남 (Has a Relation)
		
		csts[0].buyProducts(pros2);
		csts[1].buyProducts(pros1);
		
		
		//service 객체 생성 메소드 호출
		OutletStoreService service = new OutletStoreService();
		
		
		System.out.println("1. Customer가 구매한 모든 상품의 Maker를 출력합니다.");
		String[] prosname = service.getAllProductMaker(csts[0]);
		for(String name : prosname) System.out.printf("%s ",name);
		
		
		System.out.println("\n2. 모든 고객의 정보를 받아옵니다.");
		String [] customerNames = service.getAllCustomer(csts);
		for(String name : customerNames) System.out.printf("%s ", name);
		
		System.out.println("\n3. 특정고객의 모든 정보를 받아옵니다.");
		Customer c = service.getACustomer(csts, 123);
		
		System.out.println("4. 고객이 구매한 가장 비싼 제품의 가격을 받아옵니다.");
		if(service.maxPriceProduct(csts[0]) == -1)
			System.out.println("구매 물품이 존재하지 않습니다.");
		else System.out.println(service.maxPriceProduct(csts[0]));
		
		System.out.println("5. 구매 평균값 이상의 제품 이름만 받아옵니다.");
		String[] proname = service.getMoreAvgProduct(csts[0]);
		for(String name : proname) if (name != null)System.out.printf("%s ", name);
		

	}

}
