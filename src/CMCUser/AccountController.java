/**
 * The AccountController class is used to manage interactions between a type of UserInteraction 
 * object, the database, and User objects.
 */
package CMCUser;
import CMCAdmin.DBController;

/**
 * @author Devin Murphy
 *
 */
public class AccountController {
	private DBController database;
	private User user;
	

	/**
	 * Constructs an AccountController object
	 */
	public AccountController(DBController database) {
		this.setDatabase(database);
	}


	/**
	 * database getter
	 * @return the database
	 */
	public DBController getDatabase() {
		return database;
	}


	/**
	 * database setter
	 * @param database the new database for this AccountController
	 */
	public void setDatabase(DBController database) {
		this.database = database;
	}


	/**
	 * user getter
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	
	
	/**
	 * performs a login for a given userName and passWord
	 * @param u the userName of the account we are trying to login
	 * @param p the password of the account we are trying to login
	 */
	public User login(String u, String p) {
		
		return user;
	}

}
