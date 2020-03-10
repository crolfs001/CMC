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
		User user3 = new User("Evin", "Murphy", "emurphy001", "fakePassword", 'u');
		user3.setStatus('N');
		User user4 = new User("Vin", "Murphy", "vmurphy001", "fakePassword", 'u');
		user4.setLoginStatus(true);
		userList.add(user);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
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
		
		University u1 = getSchool(university);
		
		ArrayList<String> collegeList = new ArrayList<String>();
		
		for(int i = 0; i < schoolList.size(); i++) {
			University u2 = schoolList.get(i);
			double distance = 0;
			
			//school name 
			if (u1.getName() != u2.getName()) {
				//state
				if (!u1.getState().equals(u2.getState())) {
					distance += 1;
				}
				//location
				if (!u1.getLocation().equals(u2.getLocation())) {
					distance +=1;
				}
				//control
				if (!u1.getControl().equals(u2.getControl())) {
					distance += 1;
				}
				//number of students
				
				//%female
				//SAT verbal
				//sat math
				//expenses
				//financial aid
				//number of applicants
				//admitted
				//enrolled
				//academic scale
				//social skill
				//quality of life
				//emphases
			}
		}
		
		return collegeList;
	}
	
	/**
	 * finds maximum NumStudents in the schoolList
	 * @return max the max number of students
	 */
	private int getMaxNumStudents() {
		int max = schoolList.get(0).getNumStudents();
		for (int i = 1; i < schoolList.size();i++) {
			if (schoolList.get(i).getNumStudents() > max) {
				max = schoolList.get(i).getNumStudents();
			}
		}
		
		return max;
	}
	
	/**
	 * finds maximum Expenses in the schoolList
	 * @return max the max number of Expenses
	 */
	private int getMaxExpenses() {
		int max = schoolList.get(0).getExpenses();
		for (int i = 1; i < schoolList.size();i++) {
			if (schoolList.get(i).getExpenses() > max) {
				max = schoolList.get(i).getExpenses();
			}
		}
		
		return max;
	}
	
	/**
	 * finds maximum Applicants in the schoolList
	 * @return max the max number of Applicants
	 */
	private int getMaxApplicants() {
		int max = schoolList.get(0).getNumApplications();
		for (int i = 1; i < schoolList.size();i++) {
			if (schoolList.get(i).getNumApplications() > max) {
				max = schoolList.get(i).getNumApplications();
			}
		}
		
		return max;
	}
	
	/**
	 * finds minimum NumStudents in the schoolList
	 * @return min the min number of students
	 */
	private int getMinNumStudents() {
		int min = schoolList.get(0).getNumStudents();
		for (int i = 1; i < schoolList.size();i++) {
			if (schoolList.get(i).getNumStudents() < min) {
				min = schoolList.get(i).getNumStudents();
			}
		}
		
		return min;
	}
	
	/**
	 * finds minimum Expenses in the schoolList
	 * @return min the min number of Expenses
	 */
	private int getMinExpenses() {
		int min = schoolList.get(0).getExpenses();
		for (int i = 1; i < schoolList.size();i++) {
			if (schoolList.get(i).getExpenses() < min) {
				min = schoolList.get(i).getExpenses();
			}
		}
		
		return min;
	}
	
	/**
	 * finds minimum Applicants in the schoolList
	 * @return min the min number of Applicants
	 */
	private int getMinApplicants() {
		int min = schoolList.get(0).getNumApplications();
		for (int i = 1; i < schoolList.size();i++) {
			if (schoolList.get(i).getNumApplications() < min) {
				min = schoolList.get(i).getNumApplications();
			}
		}
		
		return min;
	}
	
	

}
