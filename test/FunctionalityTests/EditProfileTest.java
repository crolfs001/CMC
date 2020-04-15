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
import CMCStudent.StudentFunctionalityController;
import CMCStudent.StudentInteraction;
import CMCUniversity.UniversityController;
import CMCUser.AccountController;
import CMCUser.User;
import CMCUser.UserInteraction;

/**
 * @author crolfs001
 *
 */
public class EditProfileTest {

	private UserInteraction userInteraction;
	
	private AccountController ac;
	private DBController database;

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
	public void testEditProfile() {
		DBController database = new DBController();
		AccountController accountController = new AccountController(database);
		UniversityController universityController = new UniversityController(database);
		accountController.login("juser", "user");
		this.userInteraction = new UserInteraction(accountController, universityController);
		String user1Username= "juser";
		accountController.getUser();
		User user1 = database.findByUsername(user1Username);
		
		//change password
		Assert.assertEquals("Updated", accountController.updateProfile(user1.getUserName(), user1.getFirstName(), user1.getLastName(), "newpw"));
		Assert.assertEquals("newpw", user1.getPassword());	
		
		//change first name
		Assert.assertEquals("Updated",accountController.updateProfile(user1.getUserName(), "Charlie", user1.getLastName(), user1.getPassword()));
		Assert.assertEquals("Charlie", user1.getFirstName());	
		
		//change last name
		Assert.assertEquals("Updated",accountController.updateProfile(user1.getUserName(), user1.getFirstName(), "Rolfs", user1.getPassword()));
		Assert.assertEquals("Rolfs", user1.getLastName());
		
		//change password back to original
		accountController.updateProfile(user1.getUserName(), user1.getFirstName(), user1.getLastName(), "user");
	}

}
