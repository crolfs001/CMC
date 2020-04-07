package FunctionalityTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import CMCAdmin.DBController;
import CMCUniversity.UniversityController;
import CMCUser.AccountController;
import CMCUser.User;
import CMCUser.UserInteraction;
import junit.framework.Assert;

public class ViewUserListTest {

	@Test
	public void testGetUserList() {
		DBController database = new DBController();
		AccountController accountController = new AccountController(database);
		UniversityController universityController = new UniversityController(database);
		UserInteraction userInteraction = new UserInteraction(accountController, universityController);
		
		ArrayList<User> retrievedUserList = userInteraction.viewListofUsers();
		ArrayList<User> actualUserList = database.getUserList();
		Assert.assertEquals("View List of Users for an Admin", actualUserList, retrievedUserList);
	}

}
