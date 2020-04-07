package FunctionalityTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;
import CMCUniversity.UniversityController;
import CMCUser.AccountController;
import CMCUser.UserInteraction;

public class LoginTest {
	private UserInteraction userInteraction;

	@Before
	public void setUp() throws Exception {
		DBController database = new DBController();
		AccountController accountController = new AccountController(database);
		UniversityController universityController = new UniversityController(database);
		this.userInteraction = new UserInteraction(accountController, universityController);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSuccessfulLogin() {
		String Username = "juser";
		String Password = "user";
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Successful Login", "Login Successful", outputMessage);
	}
	
	@Test
	public void testIncorrectUsername() {
		String Username = "wrongUsername";
		String Password = "user";		
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Incorrect Username", "Login Error: invalid username", outputMessage);
	}
	
	@Test
	public void testIncorrectPassword() {
		String Username = "juser";
		String Password = "wrongPassword";
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Incorrect Password", "Login Error: invalid password", outputMessage);
	}
	
	@Test
	public void testDeactivatedAccount() {
		String Username = "luser";
		String Password = "user";
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Deactivated Account", "Login Error: Account is deactivated", outputMessage);
	}
	
	@Test
	public void testAlreadyLoggedIn() {
		String Username = "juser";
		String Password = "user";
		userInteraction.login(Username, Password);
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Already Logged On", "Login Error: user is already logged in on another device", outputMessage);
	}

}