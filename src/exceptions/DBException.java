package exceptions;

public class DBException extends Exception {
	
	public DBException(String e) {
		super("DB Error: " + e);
	}
}
