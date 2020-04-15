/**
 * 
 */
package CMCUniversity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;
import CMCUser.AccountController;
import CMCUser.User;
import CMCUser.UserInteraction;
import junit.framework.Assert;

/**
 * @author crolfs001
 *
 */
public class UniversityControllerTest {
	private UniversityController universityController;
	private DBController database;
	private UserSchool testUserSchool;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		this.database = new DBController();
		AccountController accountController = new AccountController(database);
		this.universityController = new UniversityController(database);
	
		//List<University> universitys;
		//universitys.add("SJU");
		
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
	
	@Test
	public void testGetTopFiveClosestSchool() {
		String schoolName = database.getSchoolList().get(0).getName();
		
		ArrayList<String>  calculated5ClosestSchools = this.universityController.getTopFiveClosestSchool(schoolName);
		ArrayList<String> actualClosestSchools = database.getTopFiveClosestSchool(schoolName);
		
		Assert.assertEquals("Top Five Recommended Schools for the first School in the list", actualClosestSchools, calculated5ClosestSchools);
	}

}
