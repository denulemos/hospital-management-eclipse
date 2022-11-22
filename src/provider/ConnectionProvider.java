package provider;

import utils.Constants;
import java.sql.Connection;
import java.sql.DriverManager;

import exceptions.DBException;
import models.UserModel;


public class ConnectionProvider {

	public static Connection connection;
	
    public static void setConnection() throws DBException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Constants.CONNECTION_PATH, Constants.DB_USER, Constants.DB_PASSWORD);
        }
        catch (Exception e) {
        	throw new DBException(e.getMessage());
        }
    }
}
