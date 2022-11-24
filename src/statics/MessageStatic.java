package statics;

import javax.swing.JOptionPane;

public class MessageStatic {
	public static void generateErrorMessage (String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	   }
	
	public static void generateMessage (String message) {
		JOptionPane.showMessageDialog(null, message);
	   }
}
