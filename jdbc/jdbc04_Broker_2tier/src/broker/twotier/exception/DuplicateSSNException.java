package broker.twotier.exception;

public class DuplicateSSNException extends Exception {
	
	public DuplicateSSNException() {
		this("");
	}
	
	public DuplicateSSNException(String msg) {
		super(msg);
	}
}
