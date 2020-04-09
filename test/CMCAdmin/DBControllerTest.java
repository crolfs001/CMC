/**
 * 
 */
package CMCAdmin;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
		
	}

}
