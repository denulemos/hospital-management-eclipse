
package validators;

import exceptions.PatientNotFoundException;
import implementations.PatientDAOImp;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PatientValidator {
    public static void checkIfUserExists (String id) throws PatientNotFoundException, SQLException {
        if (id == null) {
            return;
        }
        PatientDAOImp patientController = new PatientDAOImp();
        ResultSet result = patientController.getPatientById(id);
        
        if (result.next()){ 
            return;
        }
        else {
            throw new PatientNotFoundException(id);
        }
    }
}
