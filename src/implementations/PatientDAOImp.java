package implementations;

import provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.PatientDAO;
import exceptions.PatientNotFoundException;
import models.PatientModel;

public class PatientDAOImp implements PatientDAO{
	
	Connection connection = ConnectionProvider.connection;
   
     

	@Override
	public void add(PatientModel patient) throws SQLException {
		Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO patients VALUES('"+patient.getId()+"', '"+patient.getFullname()+"', '"+patient.getHistory()+"')");
		
	}
	@Override
	public PatientModel get(String id) throws SQLException, PatientNotFoundException {
		 Statement statement = connection.createStatement();
	        ResultSet result;
	        
	        result = statement.executeQuery("SELECT * FROM patients WHERE ID LIKE '" + id +"%'");
	        
	        if (result.next()) {
	        	PatientModel patient = new PatientModel(result.getString(1), result.getString(2), result.getString(3));
	        	return patient;
	        }
	        else {
	        	throw new PatientNotFoundException(id);
	        }
	        
	}
	@Override
	public List<PatientModel> getByName(String fullname) throws SQLException {
		Statement statement = connection.createStatement();
        ResultSet result;
        
        
        result = statement.executeQuery("SELECT * FROM patients WHERE fullname LIKE '" + fullname +"%'");
        return result;
	}
	@Override
	public void edit(PatientModel patient) throws SQLException {
		Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE patients SET lastname='" + lastname + "', name='" + name + "', history='" + history + "' WHERE (ID = '" + id + "')");
		
	}
}
