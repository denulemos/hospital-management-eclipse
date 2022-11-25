package implementations;

import provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.UserDAO;

public class UserDAOImp implements UserDAO {

	static Connection connection = ConnectionProvider.connection;

	public ResultSet getUser(String id, String password) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement
				.executeQuery("SELECT * FROM users WHERE id = '" + id + "' AND password = '" + password + "';");

		return result;
	}

	public void addUser(String id, String fullname, String password) throws SQLException {
		int idNumber = Integer.parseInt(id);
		Statement statement = connection.createStatement();
		statement.executeUpdate(
				"INSERT INTO users VALUES(" + idNumber + ", '" + fullname + "', '" + password + "', " + null + ")");
	}

	public ResultSet getUser(String id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result;

		result = statement.executeQuery("SELECT * FROM users WHERE id LIKE '" + id + "';");

		return result;
	}

}
