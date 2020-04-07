/**
 * 
 */
package CMCUniversity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMCUser.User;
/**
 * @author crolfs001
 *
 */
public class UserSchoolTest {
	private UserSchool testUserSchool;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		User user1 = new User("Hongtao", "Wang", "hwang003", "fakePassword", 'u'); 
		this.testUserSchool = new UserSchool(user1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testaddSchool() {
		University uni = new University("CSBSJU", "MN", "Colegeville", "Private", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		String outputmessage = this.testUserSchool.addSchool("hwang003", uni);
		Assert.assertEquals("The last school's name is 'CSBSJU'", "CSBSJU", this.testUserSchool.getLastSchool());
		Assert.assertEquals("This school is not exited in the list", "Saved successfully!", outputmessage);
		
		outputmessage = this.testUserSchool.addSchool("htwang021", uni);
		Assert.assertEquals("This user name is not correct", "The student name is not correct!", outputmessage);
		
		outputmessage = this.testUserSchool.addSchool("hwang003", uni);
		Assert.assertEquals("This university is exited", "This university is already in the list!", outputmessage);
	}

}
