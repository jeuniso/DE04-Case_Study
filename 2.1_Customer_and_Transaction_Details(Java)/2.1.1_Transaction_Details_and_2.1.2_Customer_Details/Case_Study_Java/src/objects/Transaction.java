package objects;

//Defines the Transaction object that will be used to carry 
//data about a transaction in customer and transaction classes
public class Transaction {

	//Each variable corresponds to a column
	//found in table cdw_sapp_creditcard in CDW_SAPP database
	
	private int transaction_id, day, month, year, branch_code;
	private String credit_card_no, transaction_type;
	private double transaction_value;
	private long cust_ssn;
	
	public Transaction(int id, int day, int month, int year, String card, long ssn, int code, String type, double value) {
		setTransaction_id(id);
		setDay(day);
		setMonth(month);
		setYear(year);
		setCredit_card_no(card);
		setCust_ssn(ssn);
		setBranch_code(code);
		setTransaction_type(type);
		setTransaction_value(value);
	}
	
	//Getters and Setters for the variables
	public int getTransaction_id() {
		return transaction_id;
	}
	
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getCredit_card_no() {
		return credit_card_no;
	}
	
	public void setCredit_card_no(String credit_card_no) {
		this.credit_card_no = credit_card_no;
	}
	
	public long getCust_ssn() {
		return cust_ssn;
	}
	
	public void setCust_ssn(long cust_ssn) {
		this.cust_ssn = cust_ssn;
	}
	
	public int getBranch_code() {
		return branch_code;
	}
	
	public void setBranch_code(int branch_code) {
		this.branch_code = branch_code;
	}
	
	public String getTransaction_type() {
		return transaction_type;
	}
	
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	
	public double getTransaction_value() {
		return transaction_value;
	}
	
	public void setTransaction_value(double transaction_value) {
		this.transaction_value = transaction_value;
	}
		
}
