package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DoctorDAO {
	public ResultSet getAllDoctors () throws SQLException;
	 public void addDoctor (String id, String name, String lastname, String password, String specialty, int price) throws SQLException;
	 public ResultSet getDoctorBySpecialty (String specialty) throws SQLException;
	 public ResultSet getDoctor (String id) throws SQLException;
	 public ResultSet getDoctor (String name, String lastname) throws SQLException;
}
