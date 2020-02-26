package CMCAdmin;
/**
 * This class is able to run tests to demonstrate system functionalities
 */
import CMCUser.*;

/**
 * @author Devin Murphy
 *
 */
public class Driver {
	private DBController database; 
	private AccountController accountController;
	private UserInteraction userInteraction;

	/**
	 * constructs a Driver class object
	 */
	public Driver(DBController database, AccountController accountController, UserInteraction userInteraction) {
		this.database = database;
		this.accountController = accountController;
		this.userInteraction = userInteraction;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
