/**
 * The AccountController class is used to manage interactions between a type of UserInteraction 
 * object, the database, and User objects.
 */
package CMCUser;

import java.util.ArrayList;

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
			//check loginStatus to see if user is already logged in
			else if (user.getLoginStatus()) {
				outputMessage = "Login Error: user is already logged in on another device";
				user = null;
			}
			//successful login since it passed the checks
			else {
				outputMessage = "Login Successful";
				
				user.setLoginStatus(true);
				database.setLoginStatus(user, true);
			}
		}
		else {
			outputMessage = "Login Error: invalid username";
			user = null;
		}
		return outputMessage;
	}
	
	/**
	 * logs out a user
	 * @param user the User object we are logging out
	 */
	public String logout() {
		if (user != null) {
			database.setLoginStatus(user, false);
			user = null;
		}
		String outputMessage = "User has been logged out successfully";
		return outputMessage;
	}
	public User findByUsername(String username) {
		 	this.user = database.findByUsername(username);	
		 	return this.user;
	}

	/**
	 * allows user to edit account based off of below info. Does not change username because username cannot be changed
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @return
	 */
	public String updateProfile(String userName, String firstName, String lastName, String password) {
		this.user.setFirstName(firstName);
		this.user.setLastName(lastName);
		this.user.setPassword(password);
		database.updateUser(this.user);
		return "Updated";
	}
	/**
	 * 
	 * @param username the username of the account to activate status
	 * @return Strings that correspond with what the action was
	 */
	public String activateAccount(String username) {
		user = database.findByUsername(username);
		
		if (user.getStatus() == 'N') {
			user.setStatus('Y');
			database.updateUser(user);
			return "Account is now activated";
			
		}
		else if(user.getStatus() == 'Y'){
			return "Account is already activated";
		}
		else {
			return "Invalid character. N = Inactive account. Y = Active Account";
		}
	}
	
	/**
	 * deactivates the account status of the user based off the user's username 
	 * @param username
	 * @return
	 */
	public String deactivateAccount(String username) {
		user = database.findByUsername(username);
		
		if (user.getStatus() == 'Y') {
			user.setStatus('N');
			database.updateUser(user);
			return "Account is now deactivated";
			
		}
		else if(user.getStatus() == 'N'){
			return "Account is already deactivated";
		}
		else {
			return "Invalid character. N = Inactive account. Y = Active Account";
		}
	}
	
	/**
	 * gets a list of users for the admin to look at
	 * @return the list of users
	 */
	public ArrayList<User> viewListofUsers() {
		return database.getUserList();
	}
	
	/**
	 * creates a new user object
	 * @param user the user we are creating and adding to the database
	 * @return output the string containing if the user was successfully added
	 */
	public String createUser(User user) {
		return this.database.createUser(user);
	}
	
	/**
	 * deletes a user from database
	 */
	public String deleteUser(User user) {
		return database.deleteUser(user);
	}
	
}
	
