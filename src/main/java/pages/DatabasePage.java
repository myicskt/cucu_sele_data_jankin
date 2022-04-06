package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage {

	Connection connnection;
	Statement statement;
	ResultSet resultset;
	String columnValue ;

	public String getData(String columnName) {
		// setting properties for mySql
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlUrl = "jdbc:mysql://localhost:3306/july2021";
			String sqlUserName = "root";
			String sqlPassword = "root";
			String query = "select* from user;";
			// Create connection to local database
			connnection = DriverManager.getConnection(sqlUrl, sqlUserName, sqlPassword);
			// Empowering the connection Reference variable execute queries
			statement = connnection.createStatement();
			//Delivering the query 
			resultset = statement.executeQuery(query);
			while(resultset.next()) {
				columnValue= resultset.getString(columnName);
				return columnValue;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connnection != null) {
				try {
					connnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

		return columnValue;

	}
}
