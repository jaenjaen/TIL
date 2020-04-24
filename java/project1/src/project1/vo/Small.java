package project1.vo;

public class Small extends SalaryMan {
	private int subsidy;
	
	public Small(int ssn, String name, int salary, String position) {
		super(ssn, name, salary, position);
	}


	public int getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(int subsidy) {
		this.subsidy = subsidy;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "지원금: " + subsidy;
	}
	
	

}
