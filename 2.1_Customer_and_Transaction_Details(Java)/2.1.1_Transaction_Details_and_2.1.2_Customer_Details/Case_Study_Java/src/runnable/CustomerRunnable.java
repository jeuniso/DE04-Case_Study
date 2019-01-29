package runnable;

import dao.CustomerDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import objects.Customer;
import objects.Transaction;

//Used to pass user input into the methods in CustomerDAO
//and output data returned by the methods to the user
public class CustomerRunnable {

	//4: View Customer Account By SSN
	public void getAccount() throws ClassNotFoundException, SQLException {
		 
		//Ask user for SSN
		System.out.println("Enter the SSN of the account you wish to view (ONLY the numbers): ");
		 
		Scanner input = new Scanner(System.in);
		
		//Store SSN
		int response = input.nextInt();
		 
		//Create an instance of the DAO 
		CustomerDAO cdao = new CustomerDAO();
		
		//Store result from the DAO function
		//(SSN is passed in)
		Customer cust = cdao.getAccount(response);
		 
		//Display customer account information for the given SSN
		System.out.println("Name: " + cust.getFirst_name() + " " + cust.getMiddle_name() + " " + cust.getLast_name());
		System.out.println("SSN: " + cust.getSsn());
		System.out.println("Credit Card No.: " + cust.getCredit_card_no());
		System.out.println("Address: " + cust.getStreet_name() + " " + cust.getApt_no());
		System.out.println("	" + cust.getCust_city() + " " + cust.getCust_state() + " " + cust.getCust_zip() + " " + cust.getCust_country());
		System.out.println("Phone: " + cust.getCust_phone());
		System.out.println("Email: " + cust.getCust_email());
		System.out.println("Account Last Updated: " + cust.getLast_updated());
		 
		input.close();
		
	}
	 
	//5: Modify Customer Account
	public void modifyAccount() throws ClassNotFoundException, SQLException {
		
		//Ask user for SSN
		System.out.println("Enter the SSN of the account you with to modify: ");
		
		Scanner input = new Scanner(System.in);
		
		//Store SSN
		int response = input.nextInt();
		
		//Create an instance of the DAO
		CustomerDAO cdao = new CustomerDAO();
		
		//Store the result of the DAO function
		//(SSN is passed in)
		boolean success = cdao.modifyAccount(response);
		
		//Customer account has been successfully updated
		if(success) {
			System.out.println("The cutomer account has been successfully updated.");
		}
		
		//Customer account has failed to update
		else if(!success) {
			System.out.println("The customer account has not been updated");
		}
		
		input.close();
		
	}
	
	//6: View The Bill Of A Credit Card For A Month
	public void getMonthBill() throws ClassNotFoundException, SQLException {
		 
		//Ask user for the credit card number
		System.out.println("Enter the credit card number (ONLY the numbers): ");
		
		Scanner input = new Scanner(System.in);
		 
		//Store credit card number
		String card_in = input.nextLine();
		 
		//Ask user for month
		System.out.println("Enter the month (as a number): ");
		
		//Store month
		int month_in = input.nextInt();
		
		//Ask user for year
		System.out.println("Enter the year (as a 4-digit number): ");
		
		//Store year
		int year_in = input.nextInt();
		 
		//Create an instance of the DAO
		CustomerDAO cdao = new CustomerDAO();
		
		//Create an ArrayList to store the result from the DAO function
		//(card number, month, and year are passed in)
		ArrayList<Transaction> transactions = cdao.getMonthBill(card_in, month_in, year_in);
		
		//Display credit card bill for a given month and year
		for(int i = 0; i < transactions.size(); i++) {
			Transaction t = transactions.get(i);
			System.out.println("Transaction ID: " + t.getTransaction_id());
			System.out.println("Date: " + t.getMonth() + "/" + t.getDay() + "/" + t.getYear());
			System.out.println("Branch Code: " + t.getBranch_code());
			System.out.println("Transaction Type: " + t.getTransaction_type());
			System.out.println("Transaction Value: " + t.getTransaction_value());
			System.out.println("--------------------------------------");
		}
		 
		input.close();
		
	}
	 
	//7: View Transactions Made Between Two Dates
	public void getTransactionBetweenDates() throws ClassNotFoundException, SQLException {
		 
		//Ask user for SSN
		System.out.println("Enter the SSN (ONLY the numbers):");
		 
		Scanner input = new Scanner(System.in);
		long ssn_in = input.nextLong();
		//Store SSN
		//int ssn_in = input.nextInt();
		 
		//Ask user for beginning date
		System.out.println("Enter the beginning date (YYYY/MM/DD): ");
		
		//Store beginning date
		String date_begin = input.nextLine();
		 
		input.nextLine();
		
		//Ask user for ending date
		System.out.println("Enter the ending date (YYYY/MM/DD): ");
		
		//Store ending date
		String date_end = input.nextLine();
		 
		//Create an instance of the DAO
		CustomerDAO cdao = new CustomerDAO();
		
		//Create an ArrayList to store result from DAO function
		//(SSN, beginning date, and ending date are passed in)
		ArrayList<Transaction> transactions = cdao.getTransactionBetweenDates(ssn_in, date_begin, date_end);
		 
		//Display details of transactions made between beginning and ending dates
		for(int i = 0; i < transactions.size(); i++) {
			Transaction t = transactions.get(i);
			System.out.println("Transaction ID: " + t.getTransaction_id());
			System.out.println("Date: " + t.getMonth() + "/" + t.getDay() + "/" + t.getYear());
			System.out.println("Branch Code: " + t.getBranch_code());
			System.out.println("Transaction Type: " + t.getTransaction_type());
			System.out.println("Transaction Value: " + t.getTransaction_value());
			System.out.println("--------------------------------------");
		}
		 
		input.close();
		
	}
	
}
