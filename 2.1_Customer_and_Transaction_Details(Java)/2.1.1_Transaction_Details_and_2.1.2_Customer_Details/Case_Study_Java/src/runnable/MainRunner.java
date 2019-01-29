package runnable;

import java.sql.SQLException;
import java.util.Scanner;

//Asks user for the task to be done and calls the methods accordingly
//from either CustomerRunnable or TransactionRunnable
public class MainRunner {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//User inputs type of task
		Scanner input = new Scanner(System.in);
		
		//If user wants transaction details, run transaction runnable
		System.out.println("Choose the number of desired task:");
		System.out.println("1. View Transaction By Zipcode");
		System.out.println("2. View Total For A Transaction Type");
		System.out.println("3. View Total For A State");
		
		//If user wants customer details, run customer runnable
		System.out.println("4. View Customer Account By SSN");
		System.out.println("5. Modify Customer Account");
		System.out.println("6. View The Bill Of A Credit Card For A Month");
		System.out.println("7. View Transactions Made Between Two Dates");
		
		//Stores user's choice
		int choice = input.nextInt();
		
		//Instantiate 
		CustomerRunnable cr = new CustomerRunnable();
		TransactionRunnable tr = new TransactionRunnable();
		
		switch(choice) {
		case 1:
			tr.getTransactionByZipcode();
			break;
		case 2:
			tr.getTotalByType();
			break;
		case 3:
			tr.getTotalByState();
			break;
		case 4:
			cr.getAccount();
			break;
		case 5:
			cr.modifyAccount();
			break;
		case 6:
			cr.getMonthBill();
			break;
		case 7:
			cr.getTransactionBetweenDates();
			break;
		}
		
		input.close();
		
	}
	
}
