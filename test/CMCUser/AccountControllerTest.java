/**
 * 
 */
package CMCUser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMCUser.AccountController;
import CMCUser.User;
import CMCUser.UserInteraction;
import CMCAdmin.DBController;
import CMCUniversity.UniversityController;

/**
 * @author crolfs001
 *
 */
public class AccountControllerTest {

	
	private UserInteraction userInteraction;

	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		
					
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	
	}

	@Test
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
		
		
		
	}

}
