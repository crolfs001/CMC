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

	private UserSchool testUserSchool;
	private DBController database;
	
	@Before
	public void setUp() throws Exception {
		User user0 = new User("Charlie", "Rolfs", "juser", "user", 'u'); 
		this.testUserSchool = new UserSchool(user0);
		this.database = new DBController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRemoveSavedSchool() {
		University uni = new University("CSBSJU", "MN", "Colegeville", "Private", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		University uni2 = new University("CSB", "DC", "Colegeville", "Public", 3000, 0.50, 1.00, 1.00,1.00, 1.00, 20, 0.5, 0.5, 10, 10, 10);
		User user1 = new User("Charlie", "Rolfs", "juser", "user", 'u'); 
		User user2 = new User("Devin", "Murphy", "duser", "dm", 'u');
		String outputMessage = this.testUserSchool.addSchool(user1, uni);
		
		String output = database.removeSavedSchool(user1, uni);
		//String message = this.testUserSchool.removeSchool(user1, uni);
		Assert.assertEquals("The university have been remove", "School have been remove.", output);
		
		output = database.removeSavedSchool(user1, uni2);
		Assert.assertEquals("The university is not found on the list", "School was not in the list", output);
		
		output = database.removeSavedSchool(user2, uni1);
		

		
		
	}

}
