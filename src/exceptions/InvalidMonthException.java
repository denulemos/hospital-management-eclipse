package exceptions;

public class InvalidMonthException extends Exception {
	
	public InvalidMonthException(String month) {
		super("The month entered is Invalid: " + month);
	}
}
