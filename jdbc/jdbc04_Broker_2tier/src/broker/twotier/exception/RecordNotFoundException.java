package broker.twotier.exception;

public class RecordNotFoundException extends Exception{

	public RecordNotFoundException() {
		this("");
	}
	
	public RecordNotFoundException(String msg) {
		super(msg);
	}
}
