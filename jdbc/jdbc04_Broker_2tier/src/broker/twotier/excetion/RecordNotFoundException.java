package broker.twotier.excetion;

public class RecordNotFoundException extends Exception{

	public RecordNotFoundException() {
		this("");
	}
	
	public RecordNotFoundException(String msg) {
		super(msg);
	}
}
