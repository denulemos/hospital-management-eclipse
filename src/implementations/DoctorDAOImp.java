
package implementations;

import provider.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.DoctorDAO;
import daos.MedicoDAOH2Impl;
import models.DoctorModel;

public class DoctorDAOImp implements DoctorDAO {
	private static DoctorDAOImp instance;
	
	public static DoctorDAOImp getInstance() {
		if (instance == null) {
			instance = new DoctorDAOImp();
		}
		
		return instance;
	}
	static Connection connection = ConnectionProvider.connection;


	@Override
	public void add(DoctorModel doctor) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(
				"INSERT INTO doctors (`ID`, `Fullname`, `Password`, `Specialty`, `Price`) VALUES('" + doctor.getId() + "', '"
						+ doctor.getFullName() + "', '" + doctor.getPassword() + "', '" + doctor.getSpecialty() + "', " + doctor.getPrice() + ")");
		
	}

	@Override
	public List<DoctorModel> getBySpecialty(String specialty) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement.executeQuery("SELECT * FROM doctors WHERE specialty LIKE '" + specialty + "%'");

		return result;
	}

	@Override
	public List<DoctorModel> getByName(String fullName) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement.executeQuery(
				"SELECT * FROM doctors WHERE fullname LIKE '" + fullName + "%'");
		return result;
	}

	@Override
	public DoctorModel getById(String id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement.executeQuery(
				"SELECT * FROM doctors WHERE id = '" + id + "%'");
		return result;
	}

	@Override
	public DoctorModel login(String id, String password) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement.executeQuery("SELECT * FROM doctors WHERE ID = '" + specialty + "' AND password = '" + password +"'");

		return result;
	}

}
