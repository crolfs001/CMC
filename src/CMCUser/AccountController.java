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
	 * performs a login for a given userName and passWord (takes the place of the setter)
	 * @param username the userName of the account we are trying to login
	 * @param password the password of the account we are trying to login
	 */
	public String login(String username, String password) {
		user = database.findByUsername(username); //checks to make sure it was a valid username
		String outputMessage = "";
		if (user != null) {
			//check passwords
			if (password.equals(user.getPassword()) != true) {
				outputMessage = "Login Error: invalid password";
				user = null;
			}
			//check activation status
			else if (user.getStatus() == 'N') {
				outputMessage = "Login Error: Account is deactivated";
				user = null;
			}
			//successful login since it passed the checks
			else {
				outputMessage = "Login Successful";
			}
		}
		else {
			outputMessage = "Login Error: invalid username";
			user = null;
		}
		return outputMessage;
	}

}
