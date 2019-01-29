package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import objects.Customer;
import objects.Transaction;
import queries.Queries;

//Used to establish connection with the MySQL database 
//and get data directly from the database for customer details
public class CustomerDAO extends DBConnection {

	//Connects with database
	public CustomerDAO() throws ClassNotFoundException {
		myConnection();	
	}
	
	//4: View Customer Account By SSN
	public Customer getAccount(int ssn) throws SQLException {
		
		//Create an instance of Customer to return
		Customer cust = new Customer();
		
		//Create an instance of the Queries class
		Queries q = new Queries();
		
		//Create a prepared statement using Queries class
		PreparedStatement ps4 = con.prepareStatement(q.accountQueryP);
		
		//Fill in the statement
		ps4.setInt(1, ssn);
		
		//Store result from execution of the query
		ResultSet rs4 = ps4.executeQuery();
		
		//Copy result into the Customer object
		while(rs4.next()) {
			cust.setFirst_name(rs4.getString("FIRST_NAME"));
			cust.setMiddle_name(rs4.getString("MIDDLE_NAME"));
			cust.setLast_name(rs4.getString("LAST_NAME"));
			cust.setSsn(ssn);
			cust.setCredit_card_no(rs4.getString("CREDIT_CARD_NO"));
			cust.setApt_no(rs4.getString("APT_NO"));
			cust.setStreet_name(rs4.getString("STREET_NAME"));
			cust.setCust_city(rs4.getString("CUST_CITY"));
			cust.setCust_state(rs4.getString("CUST_STATE"));
			cust.setCust_country(rs4.getString("CUST_COUNTRY"));
			cust.setCust_zip(rs4.getString("CUST_ZIP"));
			cust.setCust_phone(rs4.getInt("CUST_PHONE"));
			cust.setCust_email(rs4.getString("CUST_EMAIL"));
			cust.setLast_updated(rs4.getString("LAST_UPDATED"));
		}
		
		return cust;
		
	}
	
	//5: Modify Customer Account
	public boolean modifyAccount(int response) throws SQLException {
		
		//Creates an instance of Queries and Scanner objects
		Queries q = new Queries();
		
		Scanner input = new Scanner(System.in);
		
		//Creates an instance of the customer account to be modified
		Customer cust = getAccount(response);
		
		//Displays customer account information
		System.out.println("Name: " + cust.getFirst_name() + " " + cust.getMiddle_name() + " " + cust.getLast_name());
		System.out.println("SSN: " + cust.getSsn());
		System.out.println("Credit Card No.: " + cust.getCredit_card_no());
		System.out.println("Address: " + cust.getStreet_name() + " " + cust.getApt_no());
		System.out.println("	" + cust.getCust_city() + " " + cust.getCust_state() + " " + cust.getCust_zip() + " " + cust.getCust_country());
		System.out.println("Phone: " + cust.getCust_phone());
		System.out.println("Email: " + cust.getCust_email());
		System.out.println("Account Last Updated: " + cust.getLast_updated());
		 
		System.out.println("Are you sure you want to modify this account? (Y/N) ");
		
		//Yes or No
		String ans = input.next();
		
		//If answer is yes:
		if(ans.equals("y") || ans.equals("Y") || ans.equals("Yes") || ans.equals("yes") || ans.equals("YES")) {
			
			//Ask user for the new information; SSN and credit card number is assumed to be unchangeable
			System.out.println("Enter new first name: ");
			input.nextLine();
			String new_first_name = input.nextLine();
			
			System.out.println("Enter new middle name: ");
			String new_middle_name = input.nextLine();
			
			System.out.println("Enter new last name: ");
			String new_last_name = input.nextLine();
			
			System.out.println("Enter new apartment no.: ");
			String new_apt_no = input.nextLine();
			
			System.out.println("Enter new street address: ");
			String new_street_name = input.nextLine();
			
			System.out.println("Enter new city: ");
			String new_city = input.nextLine();
			
			System.out.println("Enter new state: ");
			String new_state = input.nextLine();
			
			System.out.println("Enter new country: ");
			String new_country = input.nextLine();
			
			System.out.println("Enter new zipcode: ");
			String new_zipcode = input.nextLine();
			
			System.out.println("Enter new phone: ");
			String new_phone = input.nextLine();
			
			System.out.println("Enter new email: ");
			String new_email = input.nextLine();
			
			//Displays new information to confirm
			System.out.println("Are you sure you want to commit these changes? (Y/N)");
			System.out.println("Name: " + new_first_name + " " + new_middle_name + " " + new_last_name);
			System.out.println("Address: " + new_street_name + " " + new_apt_no);
			System.out.println("	" + new_city + " " + new_state + " " + new_zipcode + " " + new_country);
			System.out.println("Phone: " + new_phone);
			System.out.println("Email: " + new_email);
			
			//Yes or No
			String commit = input.next();
			
			//If the answer is yes:
			if(commit.equals("y") || commit.equals("Y") || commit.equals("Yes") || commit.equals("yes") || commit.equals("YES")) {
				
				//Create an instance of the prepared statement for modifying account
				PreparedStatement ps5 = con.prepareStatement(q.modifyAccountP);
				
				//If the user put in new information for first name
				if(!new_first_name.isEmpty()) {
					ps5.setString(1, new_first_name);
				} else { //If the user did NOT put in new information i.e. hit Enter
					ps5.setString(1, cust.getFirst_name());
				}
				
				//Follows the same logic as above
				if(!new_middle_name.isEmpty()) {
					ps5.setString(2, new_middle_name);
				} else {
					ps5.setString(2, cust.getMiddle_name());
				}
				
				if(!new_last_name.isEmpty()) {
					ps5.setString(3, new_last_name);
				} else {
					ps5.setString(3, cust.getLast_name());
				}
				
				if(!new_apt_no.isEmpty()) {
					ps5.setString(4, new_apt_no);
				} else {
					ps5.setString(4, cust.getApt_no());
				}
				
				if(!new_street_name.isEmpty()) {
					ps5.setString(5, new_street_name);
				} else {
					ps5.setString(5, cust.getStreet_name());
				}
				
				if(!new_city.isEmpty()) {
					ps5.setString(6, new_city);
				} else {
					ps5.setString(6, cust.getCust_city());
				}
				
				if(!new_state.isEmpty()) {
					ps5.setString(7, new_state);
				} else {
					ps5.setString(7, cust.getCust_state());
				}
				
				if(!new_country.isEmpty()) {
					ps5.setString(8, new_country);
				} else {
					ps5.setString(8, cust.getCust_country());
				}
				
				if(!new_zipcode.isEmpty()) {
					ps5.setString(9, new_zipcode);
				} else {
					ps5.setString(9, cust.getCust_zip());
				}
				
				if(!new_phone.isEmpty()) {
					int n_phone = Integer.parseInt(new_phone);
					ps5.setInt(10, n_phone);
				} else {
					ps5.setInt(10, cust.getCust_phone());
				}
				
				if(!new_email.isEmpty()) {
					ps5.setString(11, new_email);
				} else {
					ps5.setString(11, cust.getCust_email());
				}
				
				//Put in SSN for the desired customer
				ps5.setInt(12, response);
				
				//Test purpose: print out the SQL query
				System.out.println(ps5.toString());
				
				//Execute the query and update the database with new information
				ps5.executeUpdate();
				
				//Closes the statement
				ps5.close();
				
				//Customer account has been successfully modified
				return true;
			}
			
			//If no i.e. user does not want to commit the new information entered
			else if(commit.equals("n") || commit.equals("N") || commit.equals("No") || commit.equals("no") || commit.equals("NO")) {
				input.close();
				
				//Customer account has failed to be modified
				return false;
			}
			
		}
		
		//If no i.e. user does not want to modify the account
		else if(ans.equals("n") || ans.equals("N") || ans.equals("No") || ans.equals("no") || ans.equals("NO")) {
			input.close();
			
			//Customer account has failed to be modified
			return false;
		}
		
		input.close();
		
		//default return statement
		return false;
		
	}
	
	//6: View The Bill Of A Credit Card For A Month
	public ArrayList<Transaction> getMonthBill(String card, int month, int year) throws SQLException {

		//Create the ArrayList to return
		ArrayList<Transaction> transactions = new ArrayList<>();
		
		//Create an instance of the Queries class
		Queries q = new Queries();
		
		//Create a prepared statement using Queries class
		PreparedStatement ps6 = con.prepareStatement(q.monthBillQueryP);
		
		//Fill in the statement
		ps6.setString(1, card);
		ps6.setInt(2, month);
		ps6.setInt(3, year);
	
		//Store result from execution of the query
		ResultSet rs6 = ps6.executeQuery();
		
		//Copy result into the ArrayList
		while(rs6.next()) {
			int id = rs6.getInt("TRANSACTION_ID");
			int day = rs6.getInt("DAY");
			int ssn = rs6.getInt("CUST_SSN");
			int code = rs6.getInt("BRANCH_CODE");
			String type = rs6.getString("TRANSACTION_TYPE");
			double value = rs6.getDouble("TRANSACTION_VALUE");
			
			//Create an instance defined by the current row from the ResultSet 
			Transaction t = new Transaction(id, day, month, year, card, ssn, code, type, value);
			
			//Add above to the ArrayList
			transactions.add(t);
		}
		
		return transactions;
	
	}
	
	//7: View Transactions Made Between Two Dates
	public ArrayList<Transaction> getTransactionBetweenDates(long ssn, String begin, String end) throws SQLException {
		
		//Create the ArrayList to return
		ArrayList<Transaction> transactions = new ArrayList<>();
		
		//Create an instance of the Queries class
		Queries q = new Queries();
		
		//Create a prepared statement using Queries class
		PreparedStatement ps7 = con.prepareStatement(q.transactionBetweenTwoDatesP);
		
		//Fill in the statement
		ps7.setLong(1, ssn);
		ps7.setString(2, begin);
		ps7.setString(3, end);
	
		//Store result from execution of the query
		ResultSet rs7 = ps7.executeQuery();
		
		//Copy result into the ArrayList
		while(rs7.next()) {
			int id = rs7.getInt("TRANSACTION_ID");
			int day = rs7.getInt("DAY");
			int month = rs7.getInt("MONTH");
			int year = rs7.getInt("YEAR");
			String card = rs7.getString("CREDIT_CARD_NO");
			int code = rs7.getInt("BRANCH_CODE");
			String type = rs7.getString("TRANSACTION_TYPE");
			double value = rs7.getDouble("TRANSACTION_VALUE");
			
			//Create an instance defined by the current row from the ResultSet 
			Transaction t = new Transaction(id, day, month, year, card, ssn, code, type, value);
			
			//Add above to the ArrayList
			transactions.add(t);
		}
		
		return transactions;
		
	}
	
}
