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
	 * user setter
	 * @param user the new user for this AccountController
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
