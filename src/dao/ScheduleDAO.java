package dao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import models.ScheduleModel;

public interface ScheduleDAO {

	public  List<ScheduleModel> getAvailableBySpecialty (String specialty) throws SQLException;
	public  List<ScheduleModel> getByDoctor (String doctor) throws SQLException;
	public  List<ScheduleModel> getFreeByDoctor (String doctor) throws SQLException;
	public  List<ScheduleModel> getByDoctorAndDates (String doctor, LocalDateTime startDate, LocalDateTime endDate) throws SQLException;
	public  List<ScheduleModel> getScheduleByDateandDoctor (LocalDateTime date, String doctor) throws SQLException;
	public  void create (ScheduleModel schedule) throws SQLException;
	public  void update (ScheduleModel schedule) throws SQLException;
	public 	ScheduleModel get (int id) throws SQLException;
	public  List<ScheduleModel> getScheduleByPatient (String patient) throws SQLException;
}
