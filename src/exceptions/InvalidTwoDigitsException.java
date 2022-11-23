package exceptions;

public class InvalidTwoDigitsException extends Exception {
	
	public InvalidTwoDigitsException(String value) {
		super("This value should be a number and a 2 digits one:" + value);
	}
}
