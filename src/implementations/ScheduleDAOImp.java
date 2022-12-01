package implementations;

import provider.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

import dao.ScheduleDAO;
import models.ScheduleModel;

public class ScheduleDAOImp implements ScheduleDAO {

	static Connection connection = ConnectionProvider.connection;


	@Override
	public List<ScheduleModel> getAvailableBySpecialty(String specialty) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement
				.executeQuery("SELECT * FROM schedule WHERE specialty LIKE '" + specialty + "%' AND patient IS NULL");

		return result;
	}

	@Override
	public List<ScheduleModel> getByDoctor(String doctor) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM schedule WHERE doctor LIKE '" + doctor + "%'");

		return result;
	}

	@Override
	public List<ScheduleModel> getFreeByDoctor(String doctor) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement
				.executeQuery("SELECT * FROM schedule WHERE doctor LIKE '" + doctor + "%' AND patient IS NULL");

		return result;
	}

	@Override
	public List<ScheduleModel> getByDoctorAndDates(String doctor, LocalDateTime startDate, LocalDateTime endDate)
			throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM schedule WHERE doctor LIKE '" + doctor
				+ "%' AND date BETWEEN '" + startDate + "' and '" + endDate + "'");

		return result;
	}

	@Override
	public void create(ScheduleModel schedule) throws SQLException {
		Statement statement = connection.createStatement();

		statement.executeUpdate("INSERT INTO schedule (`doctor`, `date`, `price`, `specialty`) VALUES ('" + doctor
				+ "','" + date + "', " + price + ", '" + specialty + "');");
		
	}

	@Override
	public void update(ScheduleModel schedule) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("UPDATE `schedule` SET `patient` =" + schedule.getPatient() + ", TAKEN = '" + schedule.getTaken() + "', PRICE = "
				+ schedule.getPrice() + " WHERE (`id` = " + schedule.getId() + ");");
		
	}

	@Override
	public ScheduleModel get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduleModel> getScheduleByDateandDoctor(LocalDateTime date, String doctor) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduleModel> getScheduleByPatient(String patient) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
