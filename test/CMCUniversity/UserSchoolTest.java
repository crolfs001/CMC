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
		Assert.assertEquals("Saved successfully", "Saved successfully!", outputmessage); //valid student and university
		
		outputmessage = this.testUserSchool.addSchool(user2, uni);
		Assert.assertEquals("This user name is not correct", "The user is invalid or the university is already in the list!", outputmessage);//invalid student and valid university
		
		outputmessage = this.testUserSchool.addSchool(user1, uni);
		Assert.assertEquals("This university is exited", "The user is invalid or the university is already in the list!", outputmessage);//valid student and university, but is already in the list
	}
	
	@Test
	public void removeSchool() {
		University uni1 = new University("CSBSJU", "MN", "Colegeville", "Private", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		University uni2 = new University("CSB", "DC", "Colegeville", "public", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		User user1 = new User("Charlie", "Rolfs", "juser", "user", 'u'); 
		User user2 = new User("Hongtao", "Wang", "hwang003", "fakePassword", 'u'); 
		
		this.testUserSchool.addSchool(user1, uni1);
		String message = this.testUserSchool.removeSchool(user1, uni1);
		Assert.assertEquals("The school have been remove from student saved list", "This University is remove", message);
		
		this.testUserSchool.addSchool(user1, uni1);
		message = this.testUserSchool.removeSchool(user1, uni2);
		Assert.assertEquals("The school isn't on the user saved list", "school or user was not found", message);
		
		this.testUserSchool.addSchool(user1, uni1);
		message = this.testUserSchool.removeSchool(user2, uni1);
		Assert.assertEquals("The user is not found", "school or user was not found", message);
		
		this.testUserSchool.addSchool(user1, uni1);
		message = this.testUserSchool.removeSchool(user2, uni2);
		Assert.assertEquals("The school or user was not found", "school or user was not found", message);	

	}
	

}
