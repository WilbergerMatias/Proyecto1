package EXCEPTIONS;

@SuppressWarnings("serial")
public class EmptyQueueException extends Exception{
	public EmptyQueueException (String msg) {
		super(msg);
	}
}
