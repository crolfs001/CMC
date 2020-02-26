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
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUserName(userName);
		this.setPassword(password);
		this.setType(type);
		this.setStatus('Y'); //default is activated
		this.setLoginStatus(false); //default is user is not logged in
	}

	/**
	 * firstName getter
	 * @return firstName
	 */
	public String getFirstName() {return firstName;}

	/**
	 * firstName setter
	 * @param firstName the new firstName of this User
	 */
	public void setFirstName(String firstName) {this.firstName = firstName;}

	/**
	 * lastName getter
	 * @return lastName
	 */
	public String getLastName() {return lastName;}

	/**
	 * lastName setter
	 * @param lastName the new lastName for this User
	 */
	public void setLastName(String lastName) {this.lastName = lastName;}

	/**
	 * userName getter
	 * @return userName
	 */
	public String getUserName() {return userName;}

	/**
	 * userName setter
	 * @param userName the new userName for this User
	 */
	public void setUserName(String userName) {this.userName = userName;}

	/**
	 * password getter
	 * @return password
	 */
	public String getPassword() {return password;}

	/**
	 * password setter
	 * @param password the new password for this User
	 */
	public void setPassword(String password) {this.password = password;}

	/**
	 * type getter
	 * @return type
	 */
	public char getType() {return type;}

	/**
	 * type setter
	 * @param type the new type for this User
	 */
	public void setType(char type) {this.type = type;}

	/**
	 * status getter
	 * @return status
	 */
	public char getStatus() {return status;}

	/**
	 * status setter
	 * @param status the new status for this User
	 */
	public void setStatus(char status) {this.status = status;}

	/**
	 * loginStatus getter
	 * @return loginStatus
	 */
	public boolean isLoginStatus() {return loginStatus;}

	/**
	 * loginStatus setter
	 * @param loginStatus the new loginStatus for this User
	 */
	public void setLoginStatus(boolean loginStatus) {this.loginStatus = loginStatus;}
	
}



















