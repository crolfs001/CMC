/**
 * 
 */
package CMCUniversity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;
import CMCUser.User;
import junit.framework.Assert;

/**
 * @author crolfs001
 *
 */
public class UniversityControllerTest {

	private DBController database;
	private UserSchool testUserSchool;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		
		User user0 = new User("Charlie", "Rolfs", "juser", "user", 'u'); 
		this.testUserSchool = new UserSchool(user0);
	}
	
	

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowSchools() {
		List<University> universitys;
		universitys.add("SJU");
		String list = database.showSchools(Universitys);
		Assert.assertEquals("SJU",list);	
	}
	
	@Test
	public void testRemoveSavedSchool() {
		University uni = new University("CSBSJU", "MN", "Colegeville", "Private", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		User user1 = new User("Charlie", "Rolfs", "juser", "user", 'u'); 
		String savelist = this.database.updateSavedUniversityList(user1, uni);
		
		Assert.assertEquals("School have been removed from saved school list", "The saved School whave been removed", database.removeSavedSchool(user1, uni));
	}

}
