/**
 * 
 */
package FunctionalityTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;
import CMCUniversity.UniversityController;
import CMCUser.AccountController;
import CMCUser.User;
import CMCUser.UserInteraction;

/**
 * @author crolfs001
 *
 */
public class ActivateAndDeactivateTest {
	private UserInteraction ui;
	private User user;
	private AccountController accountController;
	private UniversityController universityController;
	private DBController database;
	
	
	@Before
	public void setUp() throws Exception {
		database = new DBController();
		accountController = new AccountController(database);
		universityController = new UniversityController(database);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testActivateAndDeactive() {
		String user1Username = "juser";
		accountController.login("juser", "user");
		this.ui = new UserInteraction(accountController, universityController);
		accountController.getUser();
		User user = database.findByUsername(user1Username);
		User user2 = database.findByUsername(user1Username);
		//starts the account as activated
		ui.activateAccount(user1Username);
		
		//deactivate an account
		Assert.assertEquals("Account is now deactivated", ui.deactivateAccount(user1Username));
		Assert.assertEquals('N', user.getStatus());
		
		//deactivate an account that is already deactivated
		//created user2 as a way to make sure its going all the way back to the database
		Assert.assertEquals("Account is already deactivated", ui.deactivateAccount(user1Username));
		Assert.assertEquals('N', user2.getStatus());
		
		//activate an account
		Assert.assertEquals("Account is now activated", ui.activateAccount(user1Username));
		Assert.assertEquals('Y', user2.getStatus());
		
		//activate an account that is already activated
		Assert.assertEquals("Account is already activated", ui.activateAccount(user1Username));
		Assert.assertEquals('Y', user.getStatus());
	}
	

}
