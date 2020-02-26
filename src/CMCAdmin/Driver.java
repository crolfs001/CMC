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
	 * Method that tests the login functionality
	 * @param username the username of the account trying to login
	 * @param password the password of the account trying to login
	 */
	public void loginTester(String username, String password) {
		String outputMessage = userInteraction.login(username, password);
		System.out.println(outputMessage);
	}
	
	/**
	 * Method that tests the logout functionality
	 */
	public void logoutTester() {
		userInteraction.logout();
		System.out.println("user was successfully logged out");
	}

	/**
	 * Runs and displays methods from the driver class, showing the system successfully performs
	 * the given functionalities
	 */
	public static void main(String[] args) {
		

	}

}
