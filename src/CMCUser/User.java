/**
 * 
 */
package CMCUser;

/**
 * @author Devin Murphy
 *
 */
public class User {
	private String firstName, lastName;
	private String userName, password;
	private char type, status;
	private boolean loginStatus;

	/**
	 * Constructs a User object
	 * 
	 * @param firstName the first name of the user
	 * @param lastName the last name of the user
	 * @param userName the userName for the user's account
	 * @param password the password for the user's account
	 * @param type the type of account, 'a' for admin or 'u' for non-admin
	 * @param status the status of the account, 'Y' for activated and 'N' for deactivated
	 */
	public User(String firstName, String lastName, String userName, String password, 
			char type) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.status = 'Y'; //default is activated
		this.loginStatus = false; //default is user is not logged in
	}

}
