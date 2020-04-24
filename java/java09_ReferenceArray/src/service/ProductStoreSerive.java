package service;

import vo.Product;

/*
 * Product Store�� �ִ� �پ��� ��ǰ���� �ٷ�� ����� ��Ƴ��� ���� Ŭ����
 * �� Ŭ����������
 * 1) �پ��� ��ǰ���� MAKER�� ���
 * 2) ��ǰ���� �� �ݾ��� ����
 * 3) ��ǰ���� ��հ��� ����
 * 4) Ư�� �ݾ� �̻��� ��ǰ�� ������ ���
 * 5) Ư�� ȸ���� ��ǰ�� �����ϴ� ��� ���
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
			if(pro.getPrice()>=money) System.out.printf("%s�� ������%d�̰�, %d���� ��Դϴ�.",pro.getMaker(),pro.getPrice(),money);
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
