package broker.twotier.exception;

public class InvalidTransactionException extends Exception{

	public InvalidTransactionException() {
		this("");
	}
	
	public InvalidTransactionException(String msg) {
		super(msg);
	}
}
