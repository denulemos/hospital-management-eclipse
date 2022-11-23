package exceptions;

public class InvalidDayException extends Exception {
	
	public InvalidDayException() {
		super("The day entered is Invalid");
	}
}
