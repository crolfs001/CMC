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

public class LoginTest {
	private UserInteraction userInteraction;
	private User newUser;
	private DBController database;

	@Before
	public void setUp() throws Exception {
		this.database = new DBController();
		AccountController accountController = new AccountController(database);
		UniversityController universityController = new UniversityController(database);
		this.userInteraction = new UserInteraction(accountController, universityController);
		
		this.newUser = new User("Devin", "Murphy", "dmurphy007", "myPassword", 'u');
		database.createUser(newUser);
	}

	@After
	public void tearDown() throws Exception {
		database.deleteUser(newUser);
	}
	
	@Test
	public void testSuccessfulLogin() {
		String Username = newUser.getUserName();
		String Password = newUser.getPassword();
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Successful Login", "Login Successful", outputMessage);
	}
	
	@Test
	public void testIncorrectUsername() {
		String Username = "wrongUsername";
		String Password = "user";		
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Incorrect Username", "Login Error: invalid username", outputMessage);
		database.setLoginStatus(newUser, false);
	}
	
	@Test
	public void testIncorrectPassword() {
		String Username = newUser.getUserName();
		String Password = "wrongPassword";
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Incorrect Password", "Login Error: invalid password", outputMessage);
	}
	
	@Test
	public void testDeactivatedAccount() {
		String Username = newUser.getUserName();
		String Password = newUser.getPassword();
		newUser.setStatus('N');
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Deactivated Account", "Login Error: Account is deactivated", outputMessage);
		newUser.setStatus('Y');
	}
	
	@Test
	public void testAlreadyLoggedIn() {
		String Username = newUser.getUserName();
		String Password = newUser.getPassword();
		userInteraction.login(Username, Password);
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Already Logged On", "Login Error: user is already logged in on another device", outputMessage);
		database.setLoginStatus(newUser, false);
	}

}