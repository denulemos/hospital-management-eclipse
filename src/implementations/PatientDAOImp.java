package implementations;

import provider.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.PatientDAO;
import models.PatientModel;

public class PatientDAOImp implements PatientDAO{
	
	Connection connection = ConnectionProvider.connection;
    
    public void addPatient (PatientModel patient) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO patients VALUES('"+patient.getId()+"', '"+patient.getLastname()+"', '"+patient.getName()+"', '"+patient.getHistory()+"', '"+patient.getGender()+"')");
    }
    public ResultSet getAllPatients (String id) throws SQLException {
        Statement statement = connection.createStatement();
         ResultSet result;
        
         result = statement.executeQuery("SELECT * FROM patients");
        
        return result;
    }
    
    public ResultSet searchPatient (PatientModel patient) throws SQLException {
        ResultSet result;
        
        if (patient.getId().isEmpty()) {
            result = getPatientByName(patient.getName(), patient.getLastname());
            return result;
        }
        if (patient.getName().isEmpty() && patient.getLastname().isEmpty()) {
            result = getPatientById(patient.getId());
            return result;
        }
        
        result = fullSearch(patient);
        return result;
        
     }
    
     public ResultSet getPatientById (String id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result;
        
        result = statement.executeQuery("SELECT * FROM patients WHERE ID LIKE '" + id +"%'");
        
        return result;
    }
     
     
     public ResultSet fullSearch (PatientModel patient) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result;
        
        result = statement.executeQuery("SELECT * FROM patients WHERE ID LIKE '" + patient.getId() +"%' AND Name LIKE '" + patient.getName() +"%' AND Lastname LIKE '" + patient.getLastname() + "%'");
        
        return result;
    }
     
      public ResultSet getPatientByName (String name, String lastname) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result;
        
        if (name.isEmpty() && !lastname.isEmpty()) {
            result = statement.executeQuery("SELECT * FROM patients WHERE Lastname LIKE '" + lastname +"%'");
            return result;
        }
        if (lastname.isEmpty() && !name.isEmpty()) {
            result = statement.executeQuery("SELECT * FROM patients WHERE Name LIKE '" + name +"%'");
            return result;
        }
        
        result = statement.executeQuery("SELECT * FROM patients WHERE Name LIKE '" + name +"%' AND Lastname LIKE '"+lastname+"%'");
        return result;
    }
      
     
      public void editPatient (String id, String name,  String lastname, String history) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE patients SET lastname='" + lastname + "', name='" + name + "', history='" + history + "' WHERE (ID = '" + id + "')");
        
    }
}
