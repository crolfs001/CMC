package FunctionalityTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;
import CMCUniversity.UniversityController;
import CMCUser.AccountController;
import CMCUser.User;
import CMCUser.UserInteraction;

public class AddUserTest {
	private UserInteraction userInteraction;
	private User newUser;
	private DBController database;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.database = new DBController();
		AccountController accountController = new AccountController(database);
		UniversityController universityController = new UniversityController(database);
		this.userInteraction = new UserInteraction(accountController, universityController);
	
		this.newUser = new User("Devin", "Murphy", "dmurphy00023332", "myPassword", 'u');
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		database.deleteUser(newUser);
	}
	
	@Test
	public void testNullUser() {
		User nullUser = null;
		Assert.assertEquals("trying to add a null user","Error: cannot add null User to database", database.createUser(nullUser));
	}
	
	@Test
	public void testSuccessfulCreateUser() {
		Assert.assertEquals("successfully creating a new user", "User was successfully added to the database", userInteraction.createUser(newUser));
		//this tests trying to create a new user whose username is already taken. 
		Assert.assertEquals("trying to add a user with a username that is already in use", "Error: user with that username already exists", userInteraction.createUser(newUser));
		database.deleteUser(newUser);
	}
	
	

}
