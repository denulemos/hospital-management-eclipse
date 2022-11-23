
package exceptions;

public class InvalidHourException extends Exception {
	
	public InvalidHourException() {
		super("The hour entered is Invalid");
	}
}
