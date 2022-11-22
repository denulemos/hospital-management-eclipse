package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public interface ScheduleDAO {

	public ResultSet getAvailableScheduleBySpecialty (String specialty) throws SQLException;
	public ResultSet getScheduleByDoctor (String doctor) throws SQLException;
	public ResultSet getFreeScheduleByDoctor (String doctor) throws SQLException;
	public ResultSet getScheduleByDoctorByDates (String doctor, LocalDateTime startDate, LocalDateTime endDate) throws SQLException;
	public ResultSet getScheduleByDoctorSingleDate (LocalDateTime date) throws SQLException;
	public ResultSet takeSchedule (String id) throws SQLException;
	public ResultSet getScheduleByDateandDoctor (LocalDateTime date, String doctor) throws SQLException;
	public void createSchedule (String doctor, LocalDateTime date, int price, String specialty) throws SQLException;
	public void updateSchedule (String id, String patient, int price, String taken) throws SQLException;
	public ResultSet getScheduleByPatient (String patient) throws SQLException;
}
