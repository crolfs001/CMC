/**
 * 
 */
package CMCAdmin;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMCUniversity.University;
import CMCUser.AccountController;
import CMCUser.User;
import CMCUser.UserInteraction;
//import junit.framework.Assert;

/**
 * @author crolfs001
 *
 */
public class DBControllerTest {
	private DBController database;
	private AccountController ac;
	private User user;
	private UserInteraction ui;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		database = new DBController();
		ac = new AccountController(database);
		String username= "juser";
		String password= "user";
		ac.login(username, password);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ac.logout();
		
	}


	
	@Test
	public void testUpdateUser() {
		//change first name of a user
		String u = "juser";
		user = database.findByUsername(u);
		user.setFirstName("Bill");
		database.updateUser(user);
		User user2 = database.findByUsername(u);
		Assert.assertEquals("Bill", user2.getFirstName());
		
		//change last name of a user
		user.setLastName("Hader");
		User user3 = database.findByUsername(u);
		Assert.assertEquals("Hader", user3.getLastName());
		
		//change password of a user
		user.setPassword("Password");
		Assert.assertEquals("Password", user3.getPassword());
	}
	
	@Test
	public void testFindByUsername() {
		//user is inside the database
		String user1Username = "juser";
		Assert.assertEquals("username is in the database", "juser" ,database.findByUsername(user1Username).getUserName());
		//user is not inside the database
		String user2Username = "not in the database";
		Assert.assertEquals("username not in the database", null, database.findByUsername(user2Username));
	}

	@Test
	public void testgetSchool() {
		String un = "ABILENE CHRISTIAN UNIVERSITY";
		String un1 = "CSBSJU";
		Assert.assertEquals("This university is in database list", "ABILENE CHRISTIAN UNIVERSITY", database.getSchool(un).getName());
		Assert.assertEquals("This university is not in the database list", null, database.getSchool(un1));
	}
	
	@Test
	public void testcreateUser() {
		//try to add null user
		User nullUser = null;
		Assert.assertEquals("trying to add a null user","Error: cannot add null User to database", database.createUser(nullUser));
		
		//successfully add a new user
		User newUser = new User("Devin", "Murphy", "dmurphy002", "myPassword", 'u');
		Assert.assertEquals("successfully creating a new user", "User was successfully added to the database", database.createUser(newUser));
		
		//try to add user with a username that is already used
		Assert.assertEquals("trying to add a user with a username that is already in use", "Error: user with that username already exists", database.createUser(newUser));
		database.deleteUser(newUser);
		
	}

	@Test
	public void testdeleteUser() {
		//try to delete null user
		User nullUser = null;
		Assert.assertEquals("trying to delete a null user","Error: cannot remove a null user from the database", database.deleteUser(nullUser));
				
		//successfully delete a new user
		User newUser = new User("Devin", "Murphy", "dmurphy0091", "myPassword", 'u');
		database.createUser(newUser);
		Assert.assertEquals("successfully deleting a user", "User was successfully deleted", database.deleteUser(newUser));
				
		//try to delete a user that is not in the database
		Assert.assertEquals("trying to delete a user not in the database", "Error: cannot delete that user since that user doesn't exist", database.deleteUser(newUser));
		database.deleteUser(newUser);
	}
	
	@Test
	public void testSetLoginStatus() {
		//default login status is false
		User newUser = new User("Devin", "Murphy", "dmurphy0091", "myPassword", 'u');
		database.createUser(newUser);
		
		//login status from false to true, returns true if it was successfully changed
		Assert.assertEquals("set login status from false to true", true, database.setLoginStatus(newUser,  true));
		
		//login status from true to false, returns true if it was successfully changed
		Assert.assertEquals("set login status from true to false", true, database.setLoginStatus(newUser,  false));
		
		database.deleteUser(newUser);
	}
}
