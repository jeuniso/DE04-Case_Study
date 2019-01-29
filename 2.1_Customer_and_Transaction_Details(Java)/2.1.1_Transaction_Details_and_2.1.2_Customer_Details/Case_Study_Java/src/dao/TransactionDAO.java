package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objects.Transaction;
import queries.Queries;

//Used to establish connection with the MySQL database 
//and get data directly from the database for transaction details
public class TransactionDAO extends DBConnection {

	//Connects with database
	public TransactionDAO() throws ClassNotFoundException {
		myConnection();
	}
	
	//1: View Transaction By Zipcode
	public ArrayList<Transaction> getTransactionByZipcode(int zip, int mth, int yr) throws SQLException {
		
		//Create the ArrayList to return
		ArrayList<Transaction> transactions = new ArrayList<>();
		
		//Create an instance of the Queries class
		Queries q = new Queries();
		
		//Create a prepared statement using Queries class
		PreparedStatement ps1 = con.prepareStatement(q.transactionByZipcodeQueryP);
		
		//Fill in the statement
		ps1.setInt(1, zip);
		ps1.setInt(2, mth);
		ps1.setInt(3, yr);
		
		//Store result from execution of the query
		ResultSet rs1 = ps1.executeQuery();
		
		//Copy result into the ArrayList
		while(rs1.next()) {
			int id = rs1.getInt("TRANSACTION_ID");
			int day = rs1.getInt("DAY");
			int month = rs1.getInt("MONTH");
			int year = rs1.getInt("YEAR");
			String card = rs1.getString("CREDIT_CARD_NO");
			int ssn = rs1.getInt("CUST_SSN");
			int code = rs1.getInt("BRANCH_CODE");
			String type = rs1.getString("TRANSACTION_TYPE");
			double value = rs1.getDouble("TRANSACTION_VALUE");
			
			//Create an instance defined by the current row from the ResultSet 
			Transaction t = new Transaction(id, day, month, year, card, ssn, code, type, value);
			
			//Add above to the ArrayList
			transactions.add(t);
		}
		
		return transactions;
		
	}
	
	//2: View Total For A Transaction Type
	public Object[] getTotalByType(String type) throws SQLException {
		
		//Create an array to return
		Object[] obj = new Object[2];
		
		//Create an instance of the Queries class
		Queries q = new Queries();
		
		//Create a prepared statement using Queries class
		PreparedStatement ps2 = con.prepareStatement(q.totalByTypeQueryP);
		
		//Fill in the statement
		ps2.setString(1, type);
		
		//Store result from execution of the query
		ResultSet rs2 = ps2.executeQuery();
		
		//Copy result into the array
		while(rs2.next()) {
			Object one = rs2.getObject(1);
			Object two = rs2.getObject(2);
			
			obj[0] = one;
			obj[1] = two;
		}
		
		return obj;
		
	}
	
	//3: View Total For A State
	public Object[] getTotalByState(String state) throws SQLException {
		
		//Create an array to return
		Object[] obj = new Object[2];
		
		//Create an instance of the Queries class
		Queries q = new Queries();
		
		//Create a prepared statement using Queries class
		PreparedStatement ps3 = con.prepareStatement(q.totalByStateQueryP);
		
		//Fill in the statement
		ps3.setString(1, state);
		
		//Store result from execution of the query
		ResultSet rs3 = ps3.executeQuery();
		
		//Copy result into the array
		while(rs3.next()) {
			Object one = rs3.getObject(1);
			Object two = rs3.getObject(2);
			
			obj[0] = one;
			obj[1] = two;
		}
		
		return obj;
		
	}
	
}
