package vo;
/*
 * 상품을 구입하는 소비자에 대한 정보를 담고 있는 클래스
 * 상품을 구매하는 고객정보
 * 상품을 구매하지 않은 고객
 * 
 */
public class Customer {
	
	//생성자 주입
	private String name;
	private int ssn;
	private String address;
	
	//setter주입
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
