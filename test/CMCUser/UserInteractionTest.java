package CMCUser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMCAdmin.DBController;

public class UserInteractionTest {

	@Before
	public void setUp() throws Exception {
	
	DBController database = new DBController();
	this.UserInteraction = new UserInteraction(database);
	String user1 = "LYang001";
	String newName = "Dmurphy001";
	User newUser;
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUser() {
		
		newUser= UserInteraction.getUser();
		Assert.assertEquals("Username:", user1,user2);
	}

	@Test
	public void testsetUser() {
		String setName = UserInteraction.setUser(newName);
		Assert.assertEquals("User: ",setName ,newName );
		
	}
	
	@Test
	public void testLogin{
		String Username = newUser.getUserName();
		String Password = newUser.getPassword();
		UserInteraction userInteraction;
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Successful Login", "Login Successful", outputMessage);
	}
}
