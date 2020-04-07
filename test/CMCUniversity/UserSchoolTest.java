/**
 * 
 */
package CMCUniversity;

import static org.junit.Assert.*;

import org.junit.After;
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
		this.testUserSchool.addSchool("hwang003", uni);
		Assert.assertEquals("The name of university should be 'CSBSJU'", "CSBSJU", this.testUserSchool.savedUniversityList.get(0).getName());
	}

}
