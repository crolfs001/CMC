/**
 * 
 */
package CMCStudent;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;
import CMCUniversity.University;
import CMCUniversity.UniversityController;
import CMCUniversity.UserSchool;
import CMCUser.AccountController;
import CMCUser.User;

/**
 * @author crolfs001
 *
 */
public class StudentInteractionTest {
	
	private StudentInteraction interaction;
	private UserSchool testUserSchool;
	private DBController database;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		User user0 = new User("Charlie", "Rolfs", "juser", "user", 'u');
		this.interaction = new StudentInteraction();
		this.testUserSchool = new UserSchool(user0);
		this.database = new DBController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPromptRemove() {
		University uni = new University("CSBSJU", "MN", "Colegeville", "Private", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		User user1 = new User("Charlie", "Rolfs", "juser", "user", 'u'); 
		String outputmessage = this.database.updateSavedUniversityList(user1, uni);
		
		String output = interaction.promptRemove("y", user1, uni);
		Assert.assertEquals("'y' comfrim the remove school", "School will be remove", output);
		
		output = interaction.promptRemove("n", user1, uni);
		Assert.assertEquals("'n' cancel the removal of the school", "This School will not be remove", output);
	}

}
