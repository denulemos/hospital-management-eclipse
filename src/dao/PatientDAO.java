package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PatientDAO {
	public void addPatient (String id, String name, String lastname, String history, String gender) throws SQLException;
	public ResultSet getAllPatients (String id) throws SQLException;
	public ResultSet searchPatient (String id, String name, String lastname) throws SQLException;
	public ResultSet getPatientById (String id) throws SQLException;
	public ResultSet fullSearch (String id, String name, String lastname) throws SQLException;
	public ResultSet getPatientByName (String name, String lastname) throws SQLException;
	public void editPatient (String id, String name,  String lastname, String history) throws SQLException;
}
