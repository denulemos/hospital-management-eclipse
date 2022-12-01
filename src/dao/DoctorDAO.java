package dao;

import java.sql.SQLException;
import java.util.List;

import models.DoctorModel;

public interface DoctorDAO {

	public void add(DoctorModel doctor)
			throws SQLException;

	public List<DoctorModel> getBySpecialty(String specialty) throws SQLException;

	public List<DoctorModel> getByName(String fullName) throws SQLException;
	
	public DoctorModel getById(String id) throws SQLException;
	
	public DoctorModel login(String id, String password) throws SQLException;

}
