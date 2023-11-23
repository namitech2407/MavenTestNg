package MavenTestNg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.annotations.Test;

public class databaseConnection {
	
	
  @Test
  public void DatabaseTesting() throws SQLException {
	  //webdriver setup
	  //fill form
	  //verify registration
	  //database interaction
	  String dbURL = "jdbc:sqlserver://172.16.1.231:1433;databaseName=AlarmDB;";
      String dbUSER = "sa";
	  String dbPASS = "simple@123";
	  
	  try(Connection connection = DriverManager.getConnection(dbURL, dbUSER, dbPASS)){
		  String selectQuery = "select * from tblAlarmWithIntegrationMode where userID =1313";
		  try(PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)){
		  ResultSet resultSet = preparedStatement.executeQuery();
		  if (resultSet.next()) {
			  String tblAlarmWithIntegrationMode = resultSet.getString("integrationModeDetail");
			  System.out.println("integration mode in the database : "+ tblAlarmWithIntegrationMode);
		  }
			
		else {
			System.out.println("integration mode not found");

		}
		  
	  }
	  
  }catch (SQLException e) {
	e.printStackTrace();
}
  }
}
