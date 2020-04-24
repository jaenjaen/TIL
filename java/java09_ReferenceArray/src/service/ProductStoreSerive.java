package service;

import vo.Product;

/*
 * Product Store에 있는 다양한 상품들을 다루는 기능을 모아놓은 서비스 클래스
 * 이 클래스에서는
 * 1) 다양한 상품들의 MAKER를 출력
 * 2) 상품들의 총 금액을 리턴
 * 3) 상품들의 평균가를 리턴
 * 4) 특정 금액 이상인 상품의 정보를 출력
 * 5) 특정 회사의 상품을 리턴하는 기능 출력
 */
public class ProductStoreSerive {
	public void printMakers(Product[] pros) {
		for(Product pro : pros) System.out.print(pro.getMaker()+" ");
	}
	
	public int getTotalPrice(Product[] pros) {
		int sum=0;
		for(Product pro : pros) sum+= pro.getPrice();
		return sum;
	}
	
	public float getAvgPrice(Product[] pros) {
		return getTotalPrice(pros)/pros.length;
	}
	
	
	public void printOverPrice(Product[] pros,int money) {
		for(Product pro : pros) {
			if(pro.getPrice()>=money) System.out.printf("%s의 가격은%d이고, %d보다 비쌉니다.",pro.getMaker(),pro.getPrice(),money);
		}
	}
	
	public Product[] getcertainMaker(Product[] pros, String name) {
		Product[] pp = new Product[pros.length];
		
		int idx = 0;
		for(Product pro : pros) {
			if(pro.getMaker().equals(name)) pp[idx++] = pro;
		}
		return pp;
	}

}
