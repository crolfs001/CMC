package FunctionalityTests;

import static org.junit.Assert.*;

import org.junit.Test;

import CMCAdmin.DBController;
import CMCUniversity.UniversityController;
import CMCUser.AccountController;
import CMCUser.User;
import CMCUser.UserInteraction;
import junit.framework.Assert;

public class LogoutTest {

	@Test
	public void testLogout() {
		DBController database = new DBController();
		AccountController accountController = new AccountController(database);
		UniversityController universityController = new UniversityController(database);
		UserInteraction userInteraction = new UserInteraction(accountController, universityController);
		
		User user1 = database.getUserList().get(0);
		userInteraction.login(user1.getUserName(), user1.getPassword());
		String outputMessage = userInteraction.logout();
		Assert.assertEquals("Successful Logout", "User has been logged out successfully", outputMessage);
	}

}
