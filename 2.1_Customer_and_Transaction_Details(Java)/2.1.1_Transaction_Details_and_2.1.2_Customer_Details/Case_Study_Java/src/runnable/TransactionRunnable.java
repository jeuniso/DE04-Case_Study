package runnable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import objects.Transaction;
import dao.TransactionDAO;

//Used to pass user input into the methods in TransactionDAO
//and output data returned by the methods to the user
public class TransactionRunnable {
	
	//1: View Transaction By Zipcode
	public void getTransactionByZipcode() throws ClassNotFoundException, SQLException {
		
		//Ask user for zipcode
		System.out.println("Enter zipcode (ONLY the numbers): ");
		 
		Scanner input = new Scanner(System.in);
		
		//Store zipcode
		int zipcode_in = input.nextInt();
		
		//Ask user for month
		System.out.println("Enter month (as a number): ");
		
		//Store month
		int month_in = input.nextInt();
		
		//Ask user for year
		System.out.println("Enter year (as a 4-digit number): ");
		
		//Store year
		int year_in = input.nextInt();
		
		//Create an instance of the DAO 
		TransactionDAO tdao = new TransactionDAO();
		
		//Create an ArrayList to store the result from the DAO function
		//(zipcode, month, and year are passed in)
		ArrayList<Transaction> t = tdao.getTransactionByZipcode(zipcode_in, month_in, year_in);
		
		//Display transaction details for a given zipcode, month, and year
		for(int i = 0; i < t.size(); i++) {
			Transaction transaction = t.get(i);
			System.out.println("--------------------------------------");
			System.out.println("Transaction ID: " + transaction.getTransaction_id());
			System.out.println("Transaction Date: " + transaction.getYear() + "/" + transaction.getMonth() + "/" + transaction.getDay());
			System.out.println("Credit Card Number: " + transaction.getCredit_card_no());
			System.out.println("Customer SSN: " + transaction.getCust_ssn());
			System.out.println("Branch Code: " + transaction.getBranch_code());
			System.out.println("Transaction Type: " + transaction.getTransaction_type());
			System.out.println("Transaction Value: " + transaction.getTransaction_value());
		}
		 
		input.close();
		 
	}
	 
	//2: View Total For A Transaction Type
	public void getTotalByType() throws ClassNotFoundException, SQLException {
		
		//Ask user for transaction type
		System.out.println("Enter type of transactions (Education, Entertainment, Grocery, Gas, Bills, Test, Healthcare): ");
		
		Scanner input = new Scanner(System.in);
		
		//Store type
		String type_in = input.nextLine();
		
		//Create an instance of the DAO
		TransactionDAO tdao = new TransactionDAO();
		
		//Create an array to store the result from the DAO function
			//(type is passed in)
		Object[] o = tdao.getTotalByType(type_in);
		
		//Display type and its total number of transactions and value
		System.out.println("Type: " + type_in);
		System.out.println("Total number: " + o[0]);
		System.out.println("Total value: " + o[1]);
		
		input.close();
		
	}
	 
	//3: View Total For A State
	public void getTotalByState() throws ClassNotFoundException, SQLException {
		
		//Ask user for state
		System.out.println("Enter state: ");
		
		Scanner input = new Scanner(System.in);
		
		//Store state
		String state_in = input.nextLine();
		
		//Create an instance of the DAO
		TransactionDAO tdao = new TransactionDAO();
		
		//Create an array to store the result from the DAO function
			//(state is passed in)
		Object[] o = tdao.getTotalByState(state_in);

		//Display state and its total number of transactions and value
		System.out.println("Type: " + state_in);
		System.out.println("Total number: " + o[0]);
		System.out.println("Total value: " + o[1]);
		
		input.close();
		
	}
	
}
