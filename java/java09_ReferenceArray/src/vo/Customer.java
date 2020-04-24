package vo;
/*
 * ��ǰ�� �����ϴ� �Һ��ڿ� ���� ������ ��� �ִ� Ŭ����
 * ��ǰ�� �����ϴ� ������
 * ��ǰ�� �������� ���� ��
 * 
 */
public class Customer {
	
	//������ ����
	private String name;
	private int ssn;
	private String address;
	
	//setter����
	private Product[] products;

	public String getName() {return name;}
	
	public int getSsn() {return ssn;}
	
	public String getAddress() {return address;}
	
	public Product[] getProducts() {return products;}
	
	public Customer(int ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.address = address;
		this.name = name;
	}
	
	public void buyProducts(Product[] products) {
		this.products = products;
	}
	

}
