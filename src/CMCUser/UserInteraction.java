/**
 * This class is used to create and manipulate the UserInteraction object. 
 * This is the class that an actual, living user interacts with when they interact with the system.
 * 
 */
package CMCUser;
import java.util.ArrayList;

import CMCUniversity.UniversityController;

/**
 * @author Devin Murphy
 *
 */
public class UserInteraction {
	private User user;
	private AccountController accountController;
	private UniversityController universityController;

	/**
	 * Constructs a UserInteraction object
	 * Make sure to set the UniversityController if you are using it using the setter method since it is not apart of the constructor
	 * @param user the User object for this UserInteraction
	 */
	public UserInteraction(AccountController accountController, UniversityController universityController) {
		this.user = null;
		this.accountController = accountController;
		this.setUniversityController(null);
		this.universityController = universityController;
	}

	/**
	 * user getter
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * user setter
	 * @param user the new user for this UserInteraction object
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * accountController getter
	 * @return the accountController
	 */
	public AccountController getAccountController() {
		return accountController;
	}

	/**
	 * accountController setter
	 * @param accountController the accountController to set
	 */
	public void setAccountController(AccountController accountController) {
		this.accountController = accountController;
	}
	
	/**
	 * logs a user into the system
	 * @param username the username that is being used to login
	 * @param password the password that is being used to login
	 * @return outputMessage the message showing whether or not account was successfully logged in
	 */
	public String login(String username, String password) {
		String outputMessage = accountController.login(username, password);
		user = accountController.getUser();
		
		return outputMessage;
	}
	
	/**
	 * logs the current user out of the system
	 * @return a boolean showing the user is logged out
	 */
	public String logout() {
		String outputMessage = accountController.logout();
		user = null;
		return outputMessage;
	}
	
	public String activateAccount(String username) {
		String outputMessage = accountController.activateAccount(username);
		
		return outputMessage;
	}
	public String deactivateAccount(String username) {
		String outputMessage = accountController.deactivateAccount(username);
		
		return outputMessage;
	}

	/**
	 * @return the universityController
	 */
	public UniversityController getUniversityController() {
		return universityController;
	}

	/**
	 * @param universityController the universityController to set
	 */
	public void setUniversityController(UniversityController universityController) {
		this.universityController = universityController;
	}
	
	/**
	 * gets the top 5 recommended schools most similar to this school
	 * @param universityName the name of the university 
	 * @return top5List list of 5 closest schools to the input university
	 */
	public ArrayList<String> getTopFiveClosestSchool(String universityName) {
		return universityController.getTopFiveClosestSchool(universityName);
	}

	/**
	 * returns the list of users for the admin to see
	 * @returns the list of all users
	 */
	public ArrayList<User> viewListofUsers() {
		ArrayList<User> studentList = accountController.viewListofUsers();
		return studentList;
	}
	
	
}
