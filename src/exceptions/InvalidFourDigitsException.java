package exceptions;

public class InvalidFourDigitsException extends Exception {
	
	public InvalidFourDigitsException() {
		super("The year should be a number and a 4 digits" );
	}
}
