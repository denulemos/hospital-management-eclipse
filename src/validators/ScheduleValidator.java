
package validators;

import exceptions.CantTakeAppointmentWithoutPatientException;
import exceptions.ScheduleOccupedException;
import implementations.ScheduleDAOImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class ScheduleValidator {
    public static void isScheduleOccuped(LocalDateTime date, String doctor) throws ScheduleOccupedException, SQLException {
        ScheduleDAOImp controller = new ScheduleDAOImp();
        ResultSet result = controller.getScheduleByDateandDoctor(date, doctor);
        if (result.next()) {
            throw new ScheduleOccupedException();
        }
        return;
    }
    
    public static void validateTake(String patient, String take) throws CantTakeAppointmentWithoutPatientException, SQLException {
        if (patient == null && take.equals('1')) {
            throw new CantTakeAppointmentWithoutPatientException();
        }
        return;
    }
}
