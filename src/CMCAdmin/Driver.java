package CMCAdmin;
//ArrayList for FiveRecommendedSchool
import java.util.ArrayList;
import CMCStudent.Student;

/**
 * This class is able to run tests to demonstrate system functionalities
 */
import CMCUser.*;
import CMCStudent.*;
import CMCUniversity.*;
import CMCAdmin.*;

/**
 * @author Devin Murphy
 *
 */
public class Driver {
	private UserInteraction userInteraction;
	private StudentInteraction studentInteraction;
	private StudentFunctionalityController sfc;
	private UniversityController uc;
	private DBController dbc;
	private University uni;
	private User u1;
	private UserSchool us;
	/**
	 * constructs a Driver class object
	 */
	public Driver() {
		
	}
	public void viewAndEditProfileTester() {
		DBController database = new DBController();
		AccountController controller = new AccountController(database);
		
		// View profile
		User user = controller.findByUsername("dmurphy001");
		System.out.println("--------------------------------------------------------------\nTesting View Profile\n");
		System.out.println("First: " + user.getFirstName());
		System.out.println("Last: " + user.getLastName());
		System.out.println("Username: " + user.getUserName());
		System.out.println("Password: " + user.getPassword());
		
		// Update profile
		controller.updateProfile(user.getFirstName(), user.getLastName(), "newpw");
		

		// View updated profile
		System.out.println();
		System.out.println("--------------------------------------------------------------\nTesting Edited Password\n");
		user = controller.findByUsername("dmurphy001");
		System.out.println("First: " + user.getFirstName());
		System.out.println("Last: " + user.getLastName());
		System.out.println("Username: " + user.getUserName());
		System.out.println("Password: " + user.getPassword());
		
		controller.updateProfile("Mevin", user.getLastName(), user.getPassword());
		

		// View updated profile
		System.out.println();
		System.out.println("--------------------------------------------------------------\nTesting Edited First Name\n");
		user = controller.findByUsername("dmurphy001");
		System.out.println("First: " + user.getFirstName());
		System.out.println("Last: " + user.getLastName());
		System.out.println("Username: " + user.getUserName());
		System.out.println("Password: " + user.getPassword());
		
		controller.updateProfile(user.getFirstName(), "Durphy", user.getPassword());
		

		// View updated profile
		System.out.println();
		System.out.println("--------------------------------------------------------------\nTesting Edited Last Name\n");
		user = controller.findByUsername("dmurphy001");
		System.out.println("First: " + user.getFirstName());
		System.out.println("Last: " + user.getLastName());
		System.out.println("Username: " + user.getUserName());
		System.out.println("Password: " + user.getPassword());
	}
	
	/**
	 * Method that tests the login functionality
	 */
	public void loginTester() {
		System.out.println("--------------------------------------------------------------\nTesting Login Functionality\n");
		//Tests the login functionality
				DBController database = new DBController();
				String user1Username = "dmurphy001";
				String user1Password = "fakePassword";
				
				String user2Username = "wrongUsername";
				String user2Password = "fakePassword";

				String user3Username = "dmurphy001";
				String user3Password = "wrongPassword";

				String user4Username = "emurphy001";
				String user4Password = "fakePassword";

				String user5Username = "vmurphy001";
				String user5Password = "fakePassword";
				AccountController accountController = new AccountController(database);
				UserInteraction userInteraction = new UserInteraction(accountController);
				
				//tests login functionality for valid username, password, and activation status
				System.out.println("Testing all valid criteria:");
				String outputMessage = userInteraction.login(user1Username, user1Password);
				System.out.println(outputMessage);
				System.out.println();
				
				//tests login functionality for invalid username
				System.out.println("Testing invalid username:");
				outputMessage = userInteraction.login(user2Username, user2Password);
				System.out.println(outputMessage);
				System.out.println();
				
				//tests login functionality for invalid password
				System.out.println("Testing invalid password:");
				outputMessage = userInteraction.login(user3Username, user3Password);
				System.out.println(outputMessage);
				System.out.println();
				
				//tests login functionality for deactivated account
				System.out.println("Testing deactivated account:");
				outputMessage = userInteraction.login(user4Username, user4Password);
				System.out.println(outputMessage);
				System.out.println();
				
				//tests login functionality for already logged in account
				System.out.println("Testing already logged in account");
				outputMessage = userInteraction.login(user5Username, user5Password);
				System.out.println(outputMessage);
	}
	
	/**
	 * Method that tests the logout functionality
	 */
	public void logoutTester() {
		System.out.println("--------------------------------------------------------------------------------\nLogout Tester\n");
		
		//initialize the needed classes
		DBController database = new DBController();
		User user1 = new User("Devin", "Murphy", "dmurphy001", "fakePassword", 'u');
		AccountController accountController = new AccountController(database);
		UserInteraction userInteraction = new UserInteraction(accountController);
		userInteraction.setUser(user1);
		
		System.out.println("Testing a successful logout (no other scenarios make sense):");
		userInteraction.login(user1.getUserName(), user1.getPassword());
		String outputMessage = userInteraction.logout();
		System.out.println(outputMessage);
		
	}

	public void addSchoolTester() {
		this.studentInteraction = new StudentInteraction("SJU");
		this.sfc = new StudentFunctionalityController(this.studentInteraction.pressSaveButton());
		this.uc = new UniversityController(this.sfc.pressSaveButton());
		String u = this.uc.getSchool();
		System.out.println(u);
		try {
		this.uni = this.dbc.getSchool(u);
		this.u1 = new User("Hongtao", "Wang", "hwang003", "fakePassword", 'u');
		UserSchool t1 = new UserSchool(this.u1);
		t1.addSchool("hwang003", uni);
		t1.showSaveSchoolList();
		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
	}
	/**
	 * Runs and displays methods from the driver class, showing the system successfully performs
	 * the given functionalities
	 */
	public static void main(String[] args) {
		Driver testDriver = new Driver();
		//runs loginTester
		testDriver.loginTester();
		//runs logoutTester
		testDriver.logoutTester();
		//runs viewAndEditTester
		testDriver.viewAndEditProfileTester();
		//run addSchoolTester
		testDriver.addSchoolTester();
		
		// runs get/display TopfiveRecommendedSchool
		ArrayList<String> collegeList = new ArrayList<String>();
		collegeList.add("UMD");
		collegeList.add("SJU");
		collegeList.add("UM");
		collegeList.add("SCU");
		collegeList.add("SPC");
	}
	
	
/*	// get top five closest school
	public void getTopFiveClosestSchool() {
		
		getTopFiveClosestSchool.get(collegeList);
	}
		
	// display the top five closest school
	public void displayTopFive() {
		
		int i = 0;
		
		while (i < 4) {
			System.out.println(getTopFiveClosestSchool.get(collegeList.get(i)) + "/n");	
			i++;
	}

}*/
	public void ViewStudentInfoTester() {
	System.out.println("First: " + User.getFirstName());
	System.out.println("Last: " + User.getLastName());
	System.out.println("Username: " + User.getUserName());
	System.out.println("Password: " + User.getPassword());
	System.out.println("Status: " + User.getStatus());
	}

	public void ViewSchoolSearchResults() {
		System.out.println("Results" + "\n" + SearchSchool.getSchool());
		
	}
	
	
	/*
	 * Test the remove saved school from DBController
	 */
	public void RemoveSavedSchoolTester() {
		University SJU;
		User user = new User("Devin", "Murphy", "dmurphy001", "fakePassword", 'u');
		//us.addSchool("Devin", SJU);
		int expected = 1;
		//assertTrue("Remove Saved School", );
		//TROBINSON001
	}
}
