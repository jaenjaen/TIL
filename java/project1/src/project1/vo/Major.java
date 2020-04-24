package project1.vo;

public class Major extends SalaryMan {
	private int tax;
	
	public Major(int ssn, String name, int salary, String position) {
		super(ssn, name, salary, position);
	}

	public double getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +  "세금: " + tax;
	}
	
	

}
