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
		this.user = user;
	}

}
