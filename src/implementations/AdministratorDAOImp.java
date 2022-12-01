package implementations;

import provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.AdminDAO;
import models.UserModel;


public class AdministratorDAOImp implements AdminDAO{
	static Connection connection = ConnectionProvider.connection;

	@Override
	public void add(UserModel user) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(
				"INSERT INTO users VALUES(" + user.getId() + ", '" + user.getFullname() + "', '" + user.getPassword() + "')");
		
	}

	@Override
	public UserModel login(String id, String password) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement
				.executeQuery("SELECT * FROM users WHERE id = '" + id + "' AND password = '" + password + "';");

		return result;
	}

	@Override
	public UserModel get(String id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement.executeQuery("SELECT * FROM users WHERE id = '" + id + "';");

		return result;
	}
}
