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
	private StudentInteraction st;
	private StudentFunctionalityController sfc;
	private UniversityController uc;
	private DBController dbc;
	private University uni;
	private User user1;
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
	public void loginTester(DBController database, AccountController accountcontroller, UserInteraction userInteraction) {
		System.out.println("--------------------------------------------------------------\nTesting Login Functionality\n");
		//Tests the login functionality
				//for all correct inputs
				String user1Username = "juser";
				String user1Password = "user";
				
				//for incorrect username input
				String user2Username = "wrongUsername";
				String user2Password = "user";
				
				//for incorrect password 
				String user3Username = "juser";
				String user3Password = "wrongPassword";
				
				//for deactivated account
				String user4Username = "luser";
				String user4Password = "user";
				
				//for if user is already logged in
				String user5Username = "juser";
				String user5Password = "user";
				
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
				userInteraction.logout();
	}
	
	/**
	 * Method that tests the logout functionality
	 */
	public void logoutTester(DBController database, AccountController accountController, UserInteraction userInteraction) {
		System.out.println("--------------------------------------------------------------------------------\nLogout Tester\n");		
		//initialize the needed classes
		User user1 = database.getUserList().get(0);
		
		System.out.println("Testing a successful logout (no other scenarios make sense):");
		userInteraction.login(user1.getUserName(), user1.getPassword());
		String outputMessage = userInteraction.logout();
		System.out.println(outputMessage);
		
	}

	public void addSchoolTester() {
		String u = "SJU";
		this.st = new StudentInteraction();
		this.st.pressSaveButton(u);
		try {
		this.uni = this.dbc.getSchool(u);
		System.out.println(this.uni.getName());
		this.user1 = new User("Hongtao", "Wang", "hwang003", "fakePassword", 'u');
		UserSchool t1 = new UserSchool(this.user1);
		t1.addSchool("hwang003", uni);
		t1.showSaveSchoolList();
		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
	}
	
	
/**
 * tests the top 5 recommended school functionality
 */
	public void topFiveRecommendedSchoolTester(DBController database, UniversityController universityController, UserInteraction userInteraction) {
		System.out.println("--------------------------------------------------------------------------------\nTop Five Recommended Schools Tester\n");
		String schoolName = database.getSchoolList().get(0).getName();
		ArrayList<String>  fiveClosestSchools = userInteraction.getTopFiveClosestSchool(schoolName);
		System.out.println("Top five recommended schools for " + schoolName +":");
		for (int i = 0; i < fiveClosestSchools.size(); i++) {
			System.out.println(fiveClosestSchools.get(i));
		}		
	}
	
	
	public void ViewStudentInfoTester() {
	DBController database = new DBController();
	AccountController controller = new AccountController(database);
	User u = controller.findByUsername("dmurphy001");
	System.out.println("First: " + u.getFirstName());
	System.out.println("Last: " + u.getLastName());
	System.out.println("Username: " + u.getUserName());
	System.out.println("Password: " + u.getPassword());
	System.out.println("Status: " + u.getStatus());
	}

	public void ViewSchoolSearchResults() {
	//	System.out.println("Results" + "\n" + SearchSchool.getSchool());
		
	}
	
	
	/*
	 * Test the remove saved school from DBController
	 */
	public void RemoveSavedSchoolTester() {
		University  SJU;
		User user = new User("Devin", "Murphy", "dmurphy001", "fakePassword", 'u');
		//us.addSchool("Devin", SJU);
		
	}
	
	/**
	 * Runs and displays methods from the driver class, showing the system successfully performs
	 * the given functionalities
	 */
	public static void main(String[] args) {
		Driver testDriver = new Driver();
		
		DBController database = new DBController();
		AccountController accountController = new AccountController(database);
		UniversityController universityController = new UniversityController(database);
		UserInteraction userInteraction = new UserInteraction(accountController, universityController);
		
		//runs loginTester
		testDriver.loginTester(database, accountController, userInteraction);
		//runs logoutTester
		testDriver.logoutTester(database, accountController, userInteraction);
		//runs topFiveRecommendedSchoolTester
		testDriver.topFiveRecommendedSchoolTester(database, universityController, userInteraction);
		
//		//runs viewAndEditTester
//		testDriver.viewAndEditProfileTester();
//		//run addSchoolTester
//		testDriver.addSchoolTester();
//		//run ViewStudentInfoTester6s
//		testDriver.ViewStudentInfoTester();		
		
//		//use to find specific user info from database
//		DBController database = new DBController();
//		AccountController accountController = new AccountController(database);
//		UserInteraction userInteraction = new UserInteraction(accountController);
//		ArrayList<User> list = database.getUserList();
//		System.out.println(list.get(1).getUserName());
//		System.out.println(list.get(1).getPassword());
//		System.out.println(list.get(1).getStatus());

		
	}
}
