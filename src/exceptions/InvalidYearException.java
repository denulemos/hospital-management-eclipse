package exceptions;

public class InvalidYearException extends Exception {
	
	public InvalidYearException() {
		super("The year entered is Invalid" );
	}
}
