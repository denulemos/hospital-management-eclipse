package controllers;

import provider.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import dao.ScheduleDAO;
import models.ScheduleModel;

public class ScheduleController implements ScheduleDAO {

	static Connection connection = ConnectionProvider.connection;

	public ResultSet getAvailableScheduleBySpecialty(String specialty) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement
				.executeQuery("SELECT * FROM schedule WHERE specialty LIKE '" + specialty + "%' AND patient IS NULL");

		return result;
	}

	public ResultSet getScheduleByDoctor(String doctor) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM schedule WHERE doctor LIKE '" + doctor + "%'");

		return result;
	}

	public ResultSet getFreeScheduleByDoctor(String doctor) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement
				.executeQuery("SELECT * FROM schedule WHERE doctor LIKE '" + doctor + "%' AND patient IS NULL");

		return result;
	}

	public ResultSet getScheduleByDoctorByDates(String doctor, LocalDateTime startDate, LocalDateTime endDate)
			throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM schedule WHERE doctor LIKE '" + doctor
				+ "%' AND date BETWEEN '" + startDate + "' and '" + endDate + "'");

		return result;
	}

	public ResultSet getScheduleByDoctorSingleDate(String string) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement.executeQuery("SELECT * FROM schedule WHERE date LIKE '%" + string + "%'");

		return result;
	}

	public ResultSet takeSchedule(String id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement.executeQuery("INSERT INTO schedule (`taken`) VALUES (1) WHERE id = " + id);

		return result;
	}

	public void createSchedule(String doctor, LocalDateTime date, int price, String specialty) throws SQLException {
		Statement statement = connection.createStatement();

		statement.executeUpdate("INSERT INTO schedule (`doctor`, `date`, `price`, `specialty`) VALUES ('" + doctor
				+ "','" + date + "', " + price + ", '" + specialty + "');");

	}

	public ResultSet getScheduleByPatient(String patient) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement.executeQuery("SELECT * FROM schedule WHERE patient LIKE '" + patient + "%'");

		return result;
	}

	public void updateSchedule(ScheduleModel schedule) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("UPDATE `schedule` SET `patient` =" + schedule.getPatient() + ", TAKEN = '" + schedule.getTaken() + "', PRICE = "
				+ schedule.getPrice() + " WHERE (`id` = " + schedule.getId() + ");");
	}

	public ResultSet getScheduleByDateandDoctor(LocalDateTime date, String doctor) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement
				.executeQuery("SELECT * FROM schedule WHERE date = '" + date + "%' and doctor = '" + doctor + "'");

		return result;
	}
}
