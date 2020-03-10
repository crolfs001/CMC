/**
 * DBController class holds the systems information, holding all the different
 * user account information as well as the information on the different
 * Universities
 */
package CMCAdmin;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import CMCUser.User;
import  CMCUniversity.University;

public class DBController {
	private ArrayList<User> userList;
	private ArrayList<University> schoolList;

	/**
	 * constructs a  DBController object
	 */
	public DBController() {
		userList = new ArrayList<User>();
		schoolList = new ArrayList<University>();
		
		//DELETE THIS USER AFTER PHASE 2, IT IS ONLY USED FOR HARD CODE TESTING
		User user = new User("Devin", "Murphy", "dmurphy001", "fakePassword", 'u');
		User user2 = new User("Fue", "Vue", "fvue001", "fakePassword", 'u');
		userList.add(user);
		userList.add(user2);
		
	}
	
	/**
	 * userList getter
	 * @return the list of users for this Database
	 */
	public ArrayList<User> getUserList() {
		return userList;
	}
	
	/**
	 * schoolList getter
	 * @return the list of schools for this database
	 */
	public ArrayList<University>  getSchoolList() {
		return schoolList;
	}
	
	/**
	 * finds a User by their userName
	 * @param u the userName of the User we are trying to find
	 * @return the User with that userName
	 */
	public User findByUsername (String u) {
		User foundUser = null;
		int i = 0;
		while (i < userList.size() && foundUser == null) {
			String currUsername = userList.get(i).getUserName();
			if (u.equals(currUsername)) {
				foundUser = userList.get(i);
			}
			i++;
		}
		return foundUser;
	}
	
	/**
	 * get a university
	 * @return a university
	 */
	public University getSchool(String schoolName) {

		University u = null;
		
		for(int i = 0;i < schoolList.size(); i++)
		{
			if(schoolName.equals(schoolList.get(i).getName()))
			{
				u = schoolList.get(i);
			}
		}
		return u;
	}
	
	/** Sets the login status for a User object in the userList
	 * @param user the User object whose status we are updating
	 * @param loginStatus the login status for the User
	 */
	public boolean setLoginStatus(User user, boolean loginStatus) {
		boolean successfulStatusChange = false;
		int i = 0;
		while (i < userList.size()) {
			if (user.getUserName().equals(userList.get(i).getUserName())) {
				User temp = userList.get(i);
				temp.setLoginStatus(loginStatus);
				userList.set(i, temp);
				i = userList.size(); //breaks out of the loop
				successfulStatusChange = true;
			}
			i++;
		}
		
		return successfulStatusChange;
	}
	
	/*
	 * @return top five recommended schools 
	 */
	public ArrayList<String> displayTopFive(String university ) {
	
		List<String> topFive = getTopFiveClosestSchool(university); 
		
		return (ArrayList<String>) topFive;
	}
	
	/*
	 * @param calculate the five closest school related to the 
	 * search school
	 * 
	 * @return five closest school graded
	 */
	public ArrayList<String> getTopFiveClosestSchool(String university) {
		
		University searchUniversity = getSchool(university);
		
		ArrayList<String> collegeList = new ArrayList<String>();
		
		for(int i = 0; i < schoolList.size(); i++) {
			
		}
		
		return collegeList;
	}

}
