package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.PatientModel;

public interface PatientDAO {
	public void addPatient(PatientModel patient) throws SQLException;

	public ResultSet getAllPatients(String id) throws SQLException;

	public ResultSet searchPatient(PatientModel patient) throws SQLException;

	public ResultSet getPatientById(String id) throws SQLException;

	public ResultSet fullSearch(PatientModel patient) throws SQLException;

	public ResultSet getPatientByName(String name, String lastname) throws SQLException;

	public void editPatient(String id, String name, String lastname, String history) throws SQLException;
}
