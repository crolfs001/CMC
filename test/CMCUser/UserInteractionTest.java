package CMCUser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserInteractionTest {

	@Before
	public void setUp() throws Exception {
	}
	DBController database = new DBController();
	this.UserInteraction = new UserInteraction(database);
	user1 = "LYang001";
	User newName = "Dmurphy001";
	User newUser;
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUser() {
		
		newUser= UserInteraction.getUser();
		
		Assert.assertEquals(newUser,user1);
	}

	public void testsetUser() {
		String setName = UserInteraction.setUser(newName);
		Assert.assertEquals("User: ",setName ,newName );
		
	}
	public void testLogin{
		String Username = newUser.getUserName();
		String Password = newUser.getPassword();
		String outputMessage = userInteraction.login(Username, Password);
		Assert.assertEquals("Successful Login", "Login Successful", outputMessage);
	}
}
