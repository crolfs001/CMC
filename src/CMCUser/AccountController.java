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
		this.database = database;
	}

}
