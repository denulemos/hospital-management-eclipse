package dao;

import java.sql.SQLException;

import models.UserModel;

public interface AdminDAO {
	public void add(UserModel user) throws SQLException;

	public UserModel login(String id, String password) throws SQLException;
	
	public UserModel get(String id) throws SQLException;
}
