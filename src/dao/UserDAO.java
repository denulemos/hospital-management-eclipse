package dao;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface UserDAO {
	public ResultSet getUser (String id, String password) throws SQLException;
	public void addUser (String id, String fullname, String password)  throws SQLException;
	public ResultSet getUser (String id) throws SQLException;
}
