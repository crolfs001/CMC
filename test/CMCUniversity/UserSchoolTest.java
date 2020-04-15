/**
 * 
 */
package CMCUniversity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;
import CMCUser.User;
/**
 * @author crolfs001
 *
 */
public class UserSchoolTest {
	private UserSchool testUserSchool;
	private DBController database;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		User user0 = new User("Devin", "Murphy", "dmurphy00", "myPassword", 'u');
		this.testUserSchool = new UserSchool(user0);
		this.database = new DBController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		User user1 = new User("Devin", "Murphy", "dmurphy00", "myPassword", 'u'); 
		University uni = this.database.getSchool("ARIZONA STATE");
		String out = this.testUserSchool.removeSchool(user1, uni);
	}
	
	@Test
	public void testaddSchool() {
		University uni = this.database.getSchool("ARIZONA STATE");
		User user1 = new User("Devin", "Murphy", "dmurphy00", "myPassword", 'u');
		User user2 = new User("Hongtao", "Wang", "hwang003", "fakePassword", 'u'); 
		String outputmessage = this.testUserSchool.addSchool(user1, uni);
		Assert.assertEquals("Saved successfully", "Saved successfully!", outputmessage);
		
		outputmessage = this.testUserSchool.addSchool(user2, uni);
		Assert.assertEquals("This user name is not correct", "The user is invalid!", outputmessage);
		
		outputmessage = this.testUserSchool.addSchool(user1, uni);
		Assert.assertEquals("This university is exited", "An error was found!", outputmessage);
	}

}
