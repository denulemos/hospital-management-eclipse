
package validators;

import models.UserModel;
import exceptions.UserAlreadyExistsException;
import implementations.UserDAOImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UserValidator {
    public static boolean isDoctor (UserModel user) {
        return !(user.getSpecialty() == null);
    }
    
    public static boolean userExists (String id) throws UserAlreadyExistsException, SQLException {
        UserDAOImp userController = new UserDAOImp();
        ResultSet result = userController.getUser(id);
            if (result.next()) {
                throw new UserAlreadyExistsException(id);
            }
        return true;
    }
}
