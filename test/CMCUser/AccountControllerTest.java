/**
 * 
 */
package CMCUser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

<<<<<<< HEAD
import CMCUser.AccountController;
import CMCUser.User;
import CMCUser.UserInteraction;
import CMCAdmin.DBController;
import CMCUniversity.UniversityController;
=======
import CMCAdmin.DBController;
import CMCUniversity.UniversityController;
import junit.framework.Assert;
>>>>>>> ea474b7f123e307c2fa59ad7c16fcb91b0d0e131

/**
 * @author crolfs001
 *
 */
public class AccountControllerTest {
	private AccountController accountController;

	
	private UserInteraction userInteraction;

	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
<<<<<<< HEAD
		
		
					
=======
		DBController database = new DBController();
		this.accountController = new AccountController(database);
>>>>>>> ea474b7f123e307c2fa59ad7c16fcb91b0d0e131
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	
	}

	@Test
<<<<<<< HEAD
	public void testUpdateProfile() {
		
		DBController database = new DBController();
		AccountController accountController = new AccountController(database);
		UniversityController universityController = new UniversityController(database);
		
		accountController.login("juser", "user");
		this.userInteraction = new UserInteraction(accountController, universityController);
		Assert.assertEquals("Updated", accountController.updateProfile("juser", "firstName", "lastName", "password"));
		
		//set password back
		accountController.updateProfile("juser", "firstName", "lastName", "user");
	}
	
	@Test
	public void testActivateAccount() {
		String username = "juser";
		DBController database = new DBController();
		AccountController ac = new AccountController(database);
		User user = database.findByUsername("juser");
		
		
		//starts as deactivated
		ac.deactivateAccount(username);
		//tests activating an account
		Assert.assertEquals("Account is now activated", ac.activateAccount(username));
		Assert.assertEquals('Y', user.getStatus());
		
		//tests activating an already activated account
		Assert.assertEquals("Account is already activated", ac.activateAccount(username));
		Assert.assertEquals('Y', user.getStatus());
		
		
		
	}
	
	@Test
	public void testDeactivateAccount() {
		String username = "juser";
		DBController database = new DBController();
		AccountController ac = new AccountController(database);
		User user = database.findByUsername("juser");
		
		
		//starts as deactivated
		ac.activateAccount(username);
		//tests activating an account
		Assert.assertEquals("Account is now deactivated", ac.deactivateAccount(username));
		Assert.assertEquals('N', user.getStatus());
		
		//tests activating an already activated account
		Assert.assertEquals("Account is already deactivated", ac.deactivateAccount(username));
		Assert.assertEquals('N', user.getStatus());
		
		//reactivates account
		ac.activateAccount(username);
		
		
		
=======
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
>>>>>>> ea474b7f123e307c2fa59ad7c16fcb91b0d0e131
	}

}
