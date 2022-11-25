package implementations;

import provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dao.AdminDAO;


public class AdministratorDAOImp implements AdminDAO{
	static Connection connection = ConnectionProvider.connection;
	
    public void addAdmin (String id, String name, String lastname, String password) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO users  (`ID`, `Name`, `Lastname`, `Password`) VALUES('"+id+"', '"+name+"', '"+lastname+"', '"+password+"')");
    }
}
