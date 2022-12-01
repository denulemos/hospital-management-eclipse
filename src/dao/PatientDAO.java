package dao;

import java.sql.SQLException;
import java.util.List;

import exceptions.PatientNotFoundException;
import models.PatientModel;

public interface PatientDAO {
	public  void add(PatientModel patient) throws SQLException;

	public  PatientModel get(String id) throws SQLException, PatientNotFoundException;

	public  List<PatientModel> getByName(String fullname) throws SQLException;

	public  void edit(PatientModel patient) throws SQLException;
}
