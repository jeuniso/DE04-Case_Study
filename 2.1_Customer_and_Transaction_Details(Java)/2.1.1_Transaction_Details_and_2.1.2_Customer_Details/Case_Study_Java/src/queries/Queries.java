package queries;

//Stores queries as variables to use in the prepared statements in 
//CustomrDAO and TransactionDAO 
public class Queries {

	//Transaction
	//1. select all transactions made by customers living in the given zipcode 
	//for a given month and year in desc order
	public String transactionByZipcodeQueryP = "SELECT * FROM cdw_sapp_creditcard t "
			+ "JOIN cdw_sapp_customer c ON t.CUST_SSN = c.SSN WHERE c.CUST_ZIP = ? "
			+ "AND t.MONTH = ? " + "AND t.YEAR = ? " + "ORDER BY t.DAY DESC;";
	
	//2. select count and total values of transactions for a given type
	public String totalByTypeQueryP = "SELECT COUNT(*), SUM(TRANSACTION_VALUE) "
			+ "FROM cdw_sapp_creditcard WHERE TRANSACTION_TYPE = ?;";
	
	//3. select count and total values of transactions for branches in a given state
	public String totalByStateQueryP = "SELECT COUNT(*), SUM(TRANSACTION_VALUE) "
			+ "FROM cdw_sapp_creditcard t JOIN cdw_sapp_branch b "
			+ "ON t.BRANCH_CODE = b.BRANCH_CODE WHERE b.BRANCH_STATE = ?;";
	
	
	//Customer
	//4. select * for a given ssn
	public String accountQueryP = "SELECT * FROM cdw_sapp_customer WHERE SSN = ?;";
	
	//5. String modifyAccountQuery = update?
	public String modifyAccountP = "UPDATE cdw_sapp_customer SET FIRST_NAME = ?, "
			+ "MIDDLE_NAME = ?, " + "LAST_NAME = ?, " + "APT_NO = ?, " + "STREET_NAME = ?, "
			+ "CUST_CITY = ?, " + "CUST_STATE = ?, " + "CUST_COUNTRY = ?, " + "CUST_ZIP = ?, " 
			+ "CUST_PHONE = ?, " + "CUST_EMAIL = ? " + "WHERE SSN = ?;";

	//6. select all for a credit card number for a given month and year
	public String monthBillQueryP = "SELECT * FROM cdw_sapp_creditcard WHERE "
			+ "CREDIT_CARD_NO = ? " + "AND MONTH = ? " + "AND YEAR = ? " + "ORDER BY DAY;";
	
	//7. select all transactions made by a customer between two dates, 
		//order by year, month and day in desc order
	public String transactionBetweenTwoDatesP = "SELECT * FROM cdw_sapp_creditcard WHERE CUST_SSN = ? "
			+ "AND STR_TO_DATE(CONCAT_WS('/', YEAR, MONTH, DAY), '%Y/%m/%d') > STR_TO_DATE(?, '%Y/%m/%d') "
			+ "AND STR_TO_DATE(CONCAT_WS('/', YEAR, MONTH, DAY), '%Y/%m/%d') < STR_TO_DATE(?, '%Y/%m/%d') "
			+ "ORDER BY YEAR DESC, MONTH DESC, DAY DESC;";
	
}
