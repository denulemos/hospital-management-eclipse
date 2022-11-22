
package controllers;

import provider.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DoctorDAO;


public class DoctorController implements DoctorDAO{
    Connection connection = ConnectionProvider.connection;
    
     public ResultSet getAllDoctors () throws SQLException {
        Statement statement = connection.createStatement();
         ResultSet result;
        
         result = statement.executeQuery("SELECT * FROM users WHERE specialty IS NOT NULL");
        
        return result;
    }
     
     public void addDoctor (String id, String name, String lastname, String password, String specialty, int price) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO users (`ID`, `Name`, `Lastname`, `Password`, `Specialty`, `Price`) VALUES('"+id+"', '"+name+"', '"+lastname+"', '"+password+"', '"+ specialty +"', "+price+")");
    }
    
     
      public ResultSet getDoctorBySpecialty (String specialty) throws SQLException {
        Statement statement = connection.createStatement();
         ResultSet result;
        
         result = statement.executeQuery("SELECT * FROM users WHERE specialty LIKE '" + specialty +"%'");
        
        return result;
    }

    public ResultSet getDoctor (String id) throws SQLException {
        Statement statement = connection.createStatement();
         ResultSet result;
        
         result = statement.executeQuery("SELECT * FROM users WHERE id LIKE '" + id +"%'");
        
        return result;
    }

     public ResultSet getDoctor (String name, String lastname) throws SQLException {
        Statement statement = connection.createStatement();
         ResultSet result;
        
        if (name.isEmpty() && !lastname.isEmpty()) {
          result = statement.executeQuery("SELECT * FROM users WHERE lastname LIKE '" + lastname +"%'");
          return result;
        
        }
         
         if (!name.isEmpty() && lastname.isEmpty()){
          result = statement.executeQuery("SELECT * FROM users WHERE name LIKE '" + name +"%'");
          return result;
         }
        
         result = statement.executeQuery("SELECT * FROM users WHERE lastname LIKE '" + lastname +"%' AND name LIKE '" + name +"%'");
          return result;
        
    }

}
