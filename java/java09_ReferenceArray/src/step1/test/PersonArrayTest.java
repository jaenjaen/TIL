package step1.test;

import vo.Product;

public class PersonArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product[] p = new Product[3];
		
		for(Product ps:p) {
			System.out.println(ps); //null null null
		}
		
		//3.배열의 주소값
		System.out.println("***배열의 주소값***");
		System.out.println(p);
		
		//4. 배열초기화 person타입으로 만들어진 객체만 들어감
		p[0] = new Product("HP",120000,2);
		p[1] = new Product("SAMSUNG",230000,3);
		p[2] = new Product("LG",50000,13);
		
		for(Product ps:p) {
			System.out.println(ps.getMaker()+", "+ps.getPrice()+", "+ps.getCount());
		}
	}

}
