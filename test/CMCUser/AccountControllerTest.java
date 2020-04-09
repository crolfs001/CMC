/**
 * 
 */
package CMCUser;

import static org.junit.Assert.*;

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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		DBController database = new DBController();
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

}
