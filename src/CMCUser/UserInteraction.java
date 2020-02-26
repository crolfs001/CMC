/**
 * This class is used to create and manipulate the UserInteraction object. 
 * This is the class that an actual, living user interacts with when they interact with the system.
 * 
 */
package CMCUser;

/**
 * @author Devin Murphy
 *
 */
public class UserInteraction {
	private User user;

	/**
	 * Constructs a UserInteraction object
	 * @param user the User object for this UserInteraction
	 */
	public UserInteraction(User user) {
		this.setUser(user);
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
	 * logs the current user out of the system
	 * @return a boolean showing the user is logged out
	 */
	public boolean logout() {
		user.setLoginStatus(false);
		return user.getLoginStatus();
	}
	

}
