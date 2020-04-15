/**
 * 
 */
package CMCUser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;
import CMCUniversity.UniversityController;
import junit.framework.Assert;

/**
 * @author crolfs001
 *
 */
public class AccountControllerTest {
	private AccountController accountController;
	private DBController database;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.database = new DBController();
		this.accountController = new AccountController(database);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		String output;
		//for all correct inputs
		String user1Username = "juser";
		String user1Password = "user";
		output = accountController.login(user1Username, user1Password);
		Assert.assertEquals("all correct inputs", "Login Successful", output);
		
		//for incorrect username input
		String user2Username = "wrongUsername";
		String user2Password = "user";
		output = accountController.login(user2Username, user2Password);
		Assert.assertEquals("incorrect username", "Login Error: invalid username", output);
		
		//for incorrect password 
		String user3Username = "juser";
		String user3Password = "wrongPassword";
		output = accountController.login(user3Username, user3Password);
		Assert.assertEquals("incorrect password", "Login Error: invalid password", output);
		
		//for deactivated account
		String user4Username = "luser";
		String user4Password = "user";
		output = accountController.login(user4Username, user4Password);
		Assert.assertEquals("deactivated account", "Login Error: Account is deactivated", output);
		
		//for if user is already logged in
		String user5Username = "juser";
		String user5Password = "user";
		output = accountController.login(user1Username, user1Password);
		Assert.assertEquals("user is already logged on", "Login Error: user is already logged in on another device", output);
	}
	
	@Test
	public void testLogout() {
		User newUser = new User("Devin", "Murphy", "dmurphy111", "myPassword", 'u');
		database.createUser(newUser);
		this.accountController.login(newUser.getUserName(), newUser.getPassword());
		Assert.assertEquals("testing successful logout", "User has been logged out successfully", this.accountController.logout());
		database.deleteUser(newUser);
	}

	@Test
	public void testViewListOfUsers() {
		ArrayList<User> userList = accountController.viewListofUsers();
		ArrayList<User> actualUserList = database.getUserList();
		
		Assert.assertEquals("successful retrieval of the list of users", actualUserList, userList);
	}
}
