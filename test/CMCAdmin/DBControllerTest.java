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
//import junit.framework.Assert;

/**
 * @author crolfs001
 *
 */
public class DBControllerTest {
	private DBController database;
	private AccountController ac;
	private User u;
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
	}


	
	@Test
	public void testUpdateUser() {
		//change first name of a user
		String u = "juser";
		User user = database.findByUsername(u);
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
		
	}
}
