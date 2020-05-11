package broker.twotier.vo;

/**
 * 
 * @author Jenny Lee
 * 누가 어떤 주식을 얼마나 보유하고 있는지에 대한 정보를 담는 클래스
 * 
 */

public class SharesRec {
	private String ssn;
	private String symbol;
	private int quantity;
	
	public SharesRec(){
		super();
	}
	
	public SharesRec(String ssn, String symbol, int quantity) {
		super();
		this.ssn = ssn;
		this.symbol = symbol;
		this.quantity = quantity;
	}

	public String getSsn() {return ssn;}

	public void setSsn(String ssn) {this.ssn = ssn;}

	public String getSymbol() {return symbol;}

	public void setSymbol(String symbol) {this.symbol = symbol;}

	public int getQuantity() {return quantity;}

	public void setQuantity(int quantity) {this.quantity = quantity;}

	@Override
	public String toString() {
		return "ShareRec [ssn=" + ssn + ", symbol=" + symbol + ", quantity=" + quantity + "]";
	}
	
	

}
