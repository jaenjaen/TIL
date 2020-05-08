package broker.twotier.excetion;

public class InvaildTransactionException extends Exception{

	public InvaildTransactionException() {
		this("");
	}
	
	public InvaildTransactionException(String msg) {
		super(msg);
	}
}
