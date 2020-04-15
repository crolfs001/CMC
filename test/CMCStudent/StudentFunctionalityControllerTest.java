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
import CMCUser.User;

/**
 * @author crolfs001
 *
 */
public class StudentFunctionalityControllerTest {
	private StudentFunctionalityController testsfc;
	private DBController database;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.testsfc = new StudentFunctionalityController();
		this.database = new DBController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		University uni = this.database.getSchool("ARIZONA STATE");
		User user1 = new User("Devin", "Murphy", "dmurphy00", "myPassword", 'u');
		this.database.removeSavedSchool(user1, uni);
	}

	@Test
	public void testpressSaveButton() {
		University uni = this.database.getSchool("ARIZONA STATE");
		User user1 = new User("Devin", "Murphy", "dmurphy00", "myPassword", 'u');
		User user2 = new User("Hongtao", "Wang", "hwang003", "fakePassword", 'u'); 
		Assert.assertEquals("Saved successfully", "Saved successfully!", this.testsfc.pressSaveButton(user1, uni.getName()));
		
		Assert.assertEquals("This user name is not correct", "The user is invalid!", this.testsfc.pressSaveButton(user2, uni.getName()));
		
		Assert.assertEquals("This university is exited", "An error was found!", this.testsfc.pressSaveButton(user1, uni.getName()));
	}

}
