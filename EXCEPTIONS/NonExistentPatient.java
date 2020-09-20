package EXCEPTIONS;

@SuppressWarnings("serial")
public class NonExistentPatient extends Exception {
	
	public NonExistentPatient (String s) {
		super(s);
	}
}
