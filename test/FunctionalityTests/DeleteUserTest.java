package FunctionalityTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;
import CMCUniversity.UniversityController;
import CMCUser.AccountController;
import CMCUser.User;
import CMCUser.UserInteraction;
import junit.framework.Assert;

public class DeleteUserTest {
	private UserInteraction userInteraction;
	private User newUser;
	private DBController database;
	
	@Before
	public void setUp() throws Exception {
		this.database = new DBController();
		AccountController accountController = new AccountController(database);
		UniversityController universityController = new UniversityController(database);
		this.userInteraction = new UserInteraction(accountController, universityController);
	
		this.newUser = new User("Devin", "Murphy", "dmurphy0099023332", "myPassword", 'u');
	}

	@Test
	public void testSuccessfullUserDeletion() {
		database.createUser(newUser);
		Assert.assertEquals("successfully deleting a user", "User was successfully deleted", database.deleteUser(newUser));
	}
	
	@Test 
	public void testDeleteNullUser() {
		User nullUser = null;
		Assert.assertEquals("trying to delete a null user","Error: cannot remove a null user from the database", database.deleteUser(nullUser));
	}
	
	@Test 
	public void testDeleteUsernameNotFound() {
		Assert.assertEquals("trying to delete a user not in the database", "Error: cannot delete that user since that user doesn't exist", database.deleteUser(newUser));
	}

}
