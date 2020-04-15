/**
 * 
 */
package CMCUser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author crolfs001
 *
 */
public class UserTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetLoginStatus() {
		//default login status is false
		User newUser = new User("Devin", "Murphy", "dmurphy002", "myPassword", 'u');
		//tests setting login status from false to true
		newUser.setLoginStatus(true);
		Assert.assertEquals("Setting login status to true from false", true, newUser.getLoginStatus());
		//tests setting login status from true to false
		newUser.setLoginStatus(false);
		Assert.assertEquals("Setting login status to false from true", false, newUser.getLoginStatus());
	}

}
