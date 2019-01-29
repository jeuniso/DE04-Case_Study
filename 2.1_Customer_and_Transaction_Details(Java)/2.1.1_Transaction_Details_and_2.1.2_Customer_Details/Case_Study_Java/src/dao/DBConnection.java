package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Used to establish connection with the MySQL database (JDBC)
public abstract class DBConnection {

	protected Connection con = null;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected Statement st = null;
	
	//Establishes connection with the MySQL database
	protected void myConnection() throws ClassNotFoundException {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//Access information
			String dbUrl = "jdbc:mysql://localhost:3306/CDW_SAPP";
			String DBUserName = "root";
			String DBPassword = "password";
			
			con = DriverManager.getConnection(dbUrl, DBUserName, DBPassword);
			
			//Prints out message if the database connection is successful
			System.out.println("Database connection established");
			
			st = con.createStatement();
			
		} catch (SQLException e) {
			
			//Prints out message if the database connection is unsuccessful
			System.out.println("Database connection error");
			
		}
		
	}
	
}
