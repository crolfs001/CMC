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
			if(school.getName() == school.get(i).getName())
			{
				u = school.get(i);
			}
		}
		return u;
	}
	
	
}
