package banking.test;

import banking.Account;
import banking.Customer;

public class BankClinetTest {
	public static void main(String[] args) {
		Customer custom1 = new Customer("James", 1234);
		Account acc1 = new Account(10000);
		Account acc2 = new Account(23000);
		custom1.setAccount(acc1); //James�� ������ �ϳ� ����...
		custom1.setAccount(acc2);
		
		Account james=custom1.getAccount();
		System.out.println("5000���� �Ա��մϴ�...");
		james.deposit(5000.0);
		
		System.out.println("12000���� �Ա��մϴ�...");
		james.deposit(12000.0);
		
		System.out.println("7000���� ������մϴ�...");
		james.withdraw(7000.0);
		
		System.out.println("James's GetBalance...");
		System.out.println(james.getBalance());
	}
}
