/**
 * DBController class holds the systems information, holding all the different
 * user account information as well as the information on the different
 * Universities
 */
package CMCAdmin;
import java.util.ArrayList;
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
	public University getSchool(University school) {
		University u;
		for(int i = 0;i < school.length(); i++)
		{
			if(school == schoolList.get(i))
			{
				u = school.get(i);
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

}
