package banking;
/*
 * ������ �����ϰ��� �ϴ� ���� ������ �����ϰ� �ִ� Ŭ����..
 * Customer + Account ---> Has a Relation
 * 1. �ʵ忡 Account�� ����
 * 2. Account�� ���� ---- ������ / setter
 */
public class Customer {
	private String name;
	private int ssn;	
	//�߰�
	private Account account;	
	
	public Customer(String name, int ssn) {		
		this.name = name;
		this.ssn = ssn;
	}	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
	public String getCustInfo() {
		return name+", "+ssn;
	}	
}
