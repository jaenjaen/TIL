package broker.twotier.vo;

import java.util.Vector;

/**
 * @author Jenny Lee
 * 고객에 대한 정보를 저장하는 클래스
 * 해당고객은 주식을 사고파는데 연관이 있을 수도 있고 아닐 수도 있음 
 */
public class CustomerRec {
	private String ssn;
	private String name; // cust_name
	private String address;
	private Vector<ShareRec> portfolio;
	
	public CustomerRec() {
		super();
	}
	
	public CustomerRec(String ssn, String name, String address) {
		this(ssn,name,address,null);
	}
	
	public CustomerRec(String ssn, String name, String address, Vector<ShareRec> portfolio) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.portfolio = portfolio;
	}

	public String getSsn() {return ssn;}

	public void setSsn(String ssn) {this.ssn = ssn;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getAddress() {return address;}

	public void setAddress(String address) {this.address = address;}

	public Vector<ShareRec> getPortfolio() {return portfolio;}

	public void setPortfolio(Vector<ShareRec> portfolio) {this.portfolio = portfolio;}

	@Override
	public String toString() {
		return "CustomerRec [ssn=" + ssn + ", name=" + name + ", address=" + address + ", portfolio=" + portfolio + "]";
	}
}
