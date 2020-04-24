package service;

import vo.Customer;
import vo.Product;

/*
 * ��ǰ�� �����ϴ� ��, ������ ������ ��ǰ�� ���� ��ɵ��� �ٷ��  service class
 */
public class OutletStoreService {
	
	/*
	 * getAllProductMaker() :Ư�� ���� �� ��� ��ǰ�� 
	 * getAllCustomer()
	 * getACustomer()
	 * maxPriceProduct()
	 * getMoreAvgProduct() : Ư���� ���� ������ ��ǰ�� �߿��� 
	 */
	
	public String[] getAllProductMaker(Customer customer) {
		Product[] pros = customer.getProducts();
		String[] makers = new String[pros.length];
		
		for(int i=0; i<customer.getProducts().length; i++)
			makers[i] = pros[i].getMaker();
		return makers;
	}
	
	public String[] getAllCustomer(Customer[] customers) {
		String[] cstnames = new String[customers.length];
		for(int i =0; i<customers.length;i++) {
			cstnames[i] = customers[i].getName();
		}
		return cstnames;
	}
	
	public Customer getACustomer(Customer[] customer, int ssn) {
		Customer c = null;
		
		for(Customer cust : customer)
		if (ssn == cust.getSsn()) c = cust;
		
		return c;
	}
	
	public int maxPriceProduct(Customer customer) {
		Product[] pros = customer.getProducts();
		int max = -1;
		
		if(pros != null)
			for(Product pro: pros) {
				if(max < pro.getPrice()) max = pro.getPrice();
			}
		
		return max;
	}
	public float getAvgPrice(Customer customer) {
		Product[] pros = customer.getProducts();
		int tot = 0;
		float avg = 0.0f;
		for(Product pro : pros) tot+= pro.getPrice();
		avg = tot/pros.length;
		
		return avg;
	}
	public String[] getMoreAvgProduct(Customer customer) {
		Product[] pros = customer.getProducts();
		String[] proname = new String[pros.length];
		
		if(pros != null) {
			float avg = getAvgPrice(customer);
			for(int i=0; i< pros.length; i++) {
				if(avg <= pros[i].getPrice())
					proname[i] = pros[i].getMaker();
			}
		}
		
		return proname;
	}
	
	
	
}
