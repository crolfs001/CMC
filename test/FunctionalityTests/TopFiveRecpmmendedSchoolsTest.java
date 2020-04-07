package FunctionalityTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import CMCAdmin.DBController;
import CMCUniversity.UniversityController;
import CMCUser.AccountController;
import CMCUser.UserInteraction;
import junit.framework.Assert;

public class TopFiveRecpmmendedSchoolsTest {

	@Test
	public void test() {
		DBController database = new DBController();
		AccountController accountController = new AccountController(database);
		UniversityController universityController = new UniversityController(database);
		UserInteraction userInteraction = new UserInteraction(accountController, universityController);
		
		String schoolName = database.getSchoolList().get(0).getName();
		
		ArrayList<String>  calculated5ClosestSchools = userInteraction.getTopFiveClosestSchool(schoolName);
		ArrayList<String> actualClosestSchools = database.getTopFiveClosestSchool(schoolName);
		
		Assert.assertEquals("Top Five Recommended Schools for the first School in the list", actualClosestSchools, calculated5ClosestSchools);
	}

}
