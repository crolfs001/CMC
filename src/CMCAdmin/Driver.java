package CMCAdmin;
//ArrayList for FiveRecommendedSchool
import java.util.ArrayList;

/**
 * This class is able to run tests to demonstrate system functionalities
 */
import CMCUser.*;

/**
 * @author Devin Murphy
 *
 */
public class Driver {
	private UserInteraction userInteraction;

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
				User user1 = new User("Devin", "Murphy", "dmurphy001", "fakePassword", 'u');
				User user2 = new User("Devin", "Murphy", "wrongUsername", "fakePassword", 'u');
				User user3 = new User("Devin", "Murphy", "dmurphy001", "wrongPassword", 'u');
				User user4 = new User("Devin", "Murphy", "dmurphy001", "fakePassword", 'u');
				user4.setStatus('N');
				AccountController accountController = new AccountController(database);
				UserInteraction userInteraction = new UserInteraction(user1, accountController);
				
				//tests login functionality for valid username, password, and activation status
				System.out.println("Testing all valid criteria:");
				String outputMessage = userInteraction.login(user1.getUserName(), user1.getPassword());
				System.out.println(outputMessage);
				System.out.println();
				
				//tests login functionality for invalid username
				System.out.println("Testing invalid username:");
				userInteraction.setUser(user2);
				outputMessage = userInteraction.login(user2.getUserName(), user2.getPassword());
				System.out.println(outputMessage);
				System.out.println();
				
				//tests login functionality for invalid password
				System.out.println("Testing invalid password:");
				userInteraction.setUser(user3);
				outputMessage = userInteraction.login(user3.getUserName(), user3.getPassword());
				System.out.println(outputMessage);
				System.out.println();
				
				//tests login functionality for deactivated account
				System.out.println("Testing deactivated account:");
				userInteraction.setUser(user4);
				outputMessage = userInteraction.login(user4.getUserName(), user4.getPassword());
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
		UserInteraction userInteraction = new UserInteraction(user1, accountController);
		
		System.out.println("Testing a successful logout (no other scenarios make sense):");
		userInteraction.login(user1.getUserName(), user1.getPassword());
		String outputMessage = userInteraction.logout();
		System.out.println(outputMessage);
		
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
	
}
