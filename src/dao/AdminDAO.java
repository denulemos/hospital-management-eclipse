package dao;

import java.sql.SQLException;

public interface AdminDAO {
	public void addAdmin (String id, String name, String lastname, String password) throws SQLException;
}
