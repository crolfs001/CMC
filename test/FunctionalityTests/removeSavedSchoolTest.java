package FunctionalityTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;
import CMCUniversity.University;
import CMCUniversity.UserSchool;
import CMCUser.User;
import dblibrary.project.csci230.UniversityDBLibrary;

public class removeSavedSchoolTest {

	//private UserSchool testUserSchool;
	private DBController database;
	private User user1;
	private University uni1, uni2, uni3;
	
	@Before
	public void setUp() throws Exception { 
		//this.testUserSchool = new UserSchool(user0);
		this.database = new DBController();
		
		this.user1 = new User("Devin", "Murphy", "duser", "dm", 'u');
		database.createUser(user1);
		
	}

	@After
	public void tearDown() throws Exception {
		database.deleteUser(user1);
	}

	@Test
	public void testRemoveSavedSchool() {
		uni1 = new University("CSBSJU", "MN", "Colegeville", "Private", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		user1 = new User("Devin", "Murphy", "duser", "dm", 'u');
		String outputMessage = this.database.updateSavedUniversityList(user1, uni1);
		Assert.assertEquals("The university have been remove", "School have been remove.", database.removeSavedSchool(user1, uni1));
		
		
		user1 = new User("Devin", "Murphy", "duser", "dm", 'u');
		uni1 = new University("CSB", "DC", "Colegeville", "Public", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		uni2 = new University("SJU", "ATL", "st.paul", "Public", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		outputMessage = this.database.updateSavedUniversityList(user1, uni1);
		Assert.assertEquals("The university is not found on the list", "School was not in the list", database.removeSavedSchool(user1, uni2));
		
		user1 = null;
		uni1 = new University("CSB", "DC", "Colegeville", "Public", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		outputMessage = this.database.updateSavedUniversityList(user1, uni1);
		Assert.assertEquals("An error was found due to user = null", "An error was found", database.removeSavedSchool(user1, uni1));
		
		user1 = new User("Devin", "Murphy", "duser", "dm", 'u');
		uni1 = null;
		outputMessage = this.database.updateSavedUniversityList(user1, uni1);
		Assert.assertEquals("An error was found due to uni1 = null", "An error was found", database.removeSavedSchool(user1, uni1));
		
		uni1 = new University("CSBSJU", "MN", "Colegeville", "Private", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		uni3 = new University("CSBSJU", "MN", "Colegeville", "Private", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		user1 = new User("Charlie", "Rolfs", "juser", "user", 'u'); 
		outputMessage = this.database.updateSavedUniversityList(user1, uni1);
		outputMessage = this.database.updateSavedUniversityList(user1, uni3);
		Assert.assertEquals("The are more than one school that were deleted", "More than one school was deleted", database.removeSavedSchool(user1, uni1));

	}

}
