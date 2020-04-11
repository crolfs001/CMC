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
	private UserSchool us;
	/**
	 * constructs a Driver class object
	 */
	public Driver() {
		
	}
	public void viewAndEditProfileTester(DBController database, AccountController accountController, UserInteraction userInteraction) {
		String user1Username = "juser";
		String user1Password = "user";
		User userTemp = database.findByUsername(user1Username);
		database.setLoginStatus(userTemp, false);
		System.out.println(accountController.login(user1Username, user1Password));
		accountController.getUser();
		User user1 = database.findByUsername(user1Username);
		System.out.println("--------------------------------------------------------------\nTesting View Profile\n");
		System.out.println("First: " + user1.getFirstName());
		System.out.println("Last: " + user1.getLastName());
		System.out.println("Username: " + user1.getUserName());
		System.out.println("Password: " + user1.getPassword());
		
		// Update password
		accountController.updateProfile(user1.getUserName(), user1.getFirstName(), user1.getLastName(), "newpw");
		

		// View updated profile
		System.out.println();
		System.out.println("--------------------------------------------------------------\nTesting Edited Password\n");
		System.out.println("First: " + user1.getFirstName());
		System.out.println("Last: " + user1.getLastName());
		System.out.println("Username: " + user1.getUserName());
		System.out.println("Password: " + user1.getPassword());
		// reset password back to original password
		accountController.updateProfile(user1.getUserName(), user1.getFirstName(), user1.getLastName(), "user");
		
		//Testing Edited first name
		accountController.updateProfile(user1.getUserName(), "Charlie", user1.getLastName(), user1.getPassword());
		

	
		System.out.println();
		System.out.println("--------------------------------------------------------------\nTesting Edited First Name\n");
		System.out.println("First: " + user1.getFirstName());
		System.out.println("Last: " + user1.getLastName());
		System.out.println("Username: " + user1.getUserName());
		System.out.println("Password: " + user1.getPassword());
		
		accountController.updateProfile(user1.getUserName(), user1.getFirstName(), "Rolfs", user1.getPassword());
		

		// View updated profileSystem.out.println(userInteraction.deactivateAccount(user1Username));
		System.out.println();
		System.out.println("--------------------------------------------------------------\nTesting Edited Last Name\n");
		System.out.println("First: " + user1.getFirstName());
		System.out.println("Last: " + user1.getLastName());
		System.out.println("Username: " + user1.getUserName());
		System.out.println("Password: " + user1.getPassword());
		
		userInteraction.logout();
		String outputMessage = userInteraction.login(user1Username, user1.getPassword());
		System.out.println(outputMessage);
		//View updated profile after loggin out and back in
		System.out.println();
		System.out.println("--------------------------------------------------------------\nTesting View Profile after logging back in\n");
		System.out.println("First: " + user1.getFirstName());
		System.out.println("Last: " + user1.getLastName());
		System.out.println("Username: " + user1.getUserName());
		System.out.println("Password: " + user1.getPassword());
		
		
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
		User user1 = new User("Hongtao", "Wang", "hwang003", "fakePassword", 'u');
		System.out.println(userInteraction.deactivateAccount(user1.getUserName()));
		String u = "SJU";
		this.st = new StudentInteraction();
		this.st.pressSaveButton(u);
		try {
		this.uni = this.dbc.getSchool(u);
		System.out.println(this.uni.getName());
		UserSchool t1 = new UserSchool(user1);
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
	System.out.println("--------------------------------------------------------------\nTesting ViewStudentInfo\n");
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
	public static void RemoveSavedSchoolTester(User userName, University school) {
		//boolean removeSchool = RemoveSavedSchool(userName, school);
		boolean removeSchool = true;
		if (removeSchool) {
			System.out.print(school + "has been removed from list");
		}
		else {
			System.out.print("Cancel removeal of school");
		}
		
	}
	private void accountStatusTester(DBController database, AccountController accountController,
			UserInteraction userInteraction) {
		String user1Username = "juser";
		System.out.println("Deactivate account");
		System.out.println(userInteraction.deactivateAccount(user1Username));
		System.out.println(userInteraction.deactivateAccount(user1Username));
		User user = database.findByUsername(user1Username);
		System.out.println(user.getStatus());
		System.out.println("Activate account");
		System.out.println(userInteraction.activateAccount(user1Username));
		System.out.println(user.getStatus());
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
		
		User newUser = new User("Devin", "Murphy", "dmurphy001", "myPassword", 'u');
		database.createUser(newUser);
		if (newUser.equals(database.findByUsername(newUser.getUserName()))) {
			System.out.println("Error: user with that username already exists");
		}
		else {
			System.out.println("hi");
		}
		
//		//runs loginTester
//		testDriver.loginTester(database, accountController, userInteraction);
//		//runs logoutTester
//		testDriver.logoutTester(database, accountController, userInteraction);
//		//runs topFiveRecommendedSchoolTester
//		testDriver.viewAndEditProfileTester(database, accountController, userInteraction);
//		testDriver.accountStatusTester(database, accountController, userInteraction);
//		
//		//runs viewAndEditTester
//		testDriver.viewAndEditProfileTester();
//		//run addSchoolTester
//		testDriver.addSchoolTester();
//		//run ViewStudentInfoTester6s
//		testDriver.ViewStudentInfoTester();	A2`1 5		
		
//		//use to find specific user info from database
//		DBController database = new DBController();
//		AccountController accountController = new AccountController(database);
//		UserInteraction userInteraction = new UserInteraction(accountController);
//		ArrayList<User> list = database.getUserList();
//		System.out.println(list.get(0).getFirstName());
//		System.out.println(list.get(0).getLastName());
//		System.out.println(list.get(0).getUserName());
//		System.out.println(list.get(0).getPassword());
//		System.out.println(list.get(0).getType());
//		System.out.println(list.get(0).getStatus());
//		System.out.println("--------");
//		database.showSchoolList();

		
	}
	
}
