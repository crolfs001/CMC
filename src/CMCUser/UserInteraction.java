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
	public UserInteraction(AccountController accountController) {
		this.user = null;
		this.accountController = accountController;
		this.setUniversityController(null);
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
	 * finds top 5 schools similar to the input school
	 * @param university name the input school
	 * @return top5List the list of 5 schools that are closest to the input school
	 */
	public ArrayList<String> getTopFiveClosestSchool(String universityName) {
		return universityController.getTopFiveClosestSchool(universityName);
	}

	
	
}
