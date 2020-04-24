package step2.test;

import vo.Product;

public class PersonArrayTest {
	public static void main(String[ ] a) {
	//배열의 생성과 초기화를 한번에
	Product[] pros = {
			new Product("HP",120000,2),
			new Product("SAMSUNG",230000,3),
			new Product("LG",50000,13)
			};
	
	//product제품들의 기능을 출력
	System.out.println ("상품 메이커정보를 출력합니다.");
	for(Product pro:pros) System.out.println(pro.getMaker()+ " ");
	
	//제품중에서 가격대가 20만원을 호가하는 제품의 메이커와 가격
	
	for(Product pro: pros ) {
		if (pro.getPrice()>=200000) System.out.printf("%s의 가격은 %d 입니다.\n",pro.getMaker(),pro.getPrice());
	}
	
	//전체상품의 총 가격의 합을 출력
	int sum =0;
	for(Product pro:pros) {
		sum += pro.getPrice();
	}
	System.out.printf("가격의 총합은 %d",sum);
	}

}
