package step1.test;

import vo.Product;

public class PersonArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product[] p = new Product[3];
		
		for(Product ps:p) {
			System.out.println(ps); //null null null
		}
		
		//3.�迭�� �ּҰ�
		System.out.println("***�迭�� �ּҰ�***");
		System.out.println(p);
		
		//4. �迭�ʱ�ȭ personŸ������ ������� ��ü�� ��
		p[0] = new Product("HP",120000,2);
		p[1] = new Product("SAMSUNG",230000,3);
		p[2] = new Product("LG",50000,13);
		
		for(Product ps:p) {
			System.out.println(ps.getMaker()+", "+ps.getPrice()+", "+ps.getCount());
		}
	}

}
