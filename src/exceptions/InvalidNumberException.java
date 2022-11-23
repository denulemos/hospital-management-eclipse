package exceptions;

public class InvalidNumberException extends Exception {
	
	public InvalidNumberException() {
		super("Value must be a number");
	}
}
