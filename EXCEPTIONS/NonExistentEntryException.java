package EXCEPTIONS;

@SuppressWarnings("serial")
public class NonExistentEntryException extends Exception {

	public NonExistentEntryException (String msg) {
		super(msg);
	}
}
