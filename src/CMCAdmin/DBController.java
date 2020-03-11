/**
 * DBController class holds the systems information, holding all the different
 * user account information as well as the information on the different
 * Universities
 */
package CMCAdmin;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import dblibrary.project.csci230.*;

import CMCUser.User;
import CMCUniversity.University;

public class DBController {
	private ArrayList<User> userList;
	private ArrayList<University> schoolList;
	private UniversityDBLibrary database;

	/**
	 * constructs a  DBController object
	 */
	public DBController() {
		userList = new ArrayList<User>();
		schoolList = new ArrayList<University>();
		database = new UniversityDBLibrary("breakingmatrix","csci230");
		
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
		String [] a = {"a","b"};
		University uni = new University("SJU", "MN", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, a);
		University uni2 = new University("CSB", "MN", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, a);
		schoolList.add(uni);
		schoolList.add(uni2);
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
		ArrayList<Double> distanceList = new ArrayList<Double>();
		
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
				distance += Math.abs((u1.getNumStudents()-u2.getNumStudents()))/(this.getMaxNumStudents()-this.getMinNumStudents());
				//%female
				distance += Math.abs((u1.getPercentFemal()-u2.getPercentFemal()))/100;
				//SAT verbal
				distance += Math.abs((u1.getSatVerbal()-u2.getSatVerbal()))/600;
				//sat math
				distance += Math.abs((u1.getSatMath()-u2.getSatMath()))/600;
				//expenses
				distance += Math.abs((u1.getExpenses()-u2.getExpenses()))/(this.getMaxExpenses()-this.getMinExpenses());
				//financial aid
				distance += Math.abs((u1.getPercentFinancialAid()-u2.getPercentFinancialAid()))/100;
				//number of applicants
				distance += Math.abs((u1.getNumApplications()-u2.getNumApplications()))/(this.getMaxApplicants()-this.getMinApplicants());
				//admitted
				distance += Math.abs((u1.getPercentAdmitted()-u2.getPercentAdmitted()))/100;
				//enrolled
				distance += Math.abs((u1.getPercentEnrolled()-u2.getPercentEnrolled()))/100;
				//academic scale
				distance += Math.abs((u1.getAcademicsScale()-u2.getAcademicsScale()))/4;
				//social skill
				distance += Math.abs((u1.getSocialScale()-u2.getSocialScale()))/4;
				//quality of life
				distance += Math.abs((u1.getQualityOfLifeScale()-u2.getQualityOfLifeScale()))/4;
				//emphases
				String[] u1emphasis = u1.getEmphases();
				String[] u2emphasis = u2.getEmphases();
				int numEmphasesFound = 0;
				int numEmphasesNotFound = 0;
				for (int c = 0; c < u1emphasis.length; c++) {
					boolean found = false;
					String emphasis = u1emphasis[c];
					if (!emphasis.equals(null)) {
						for (int j = 0; j < u2emphasis.length; j++) {
							if (emphasis.equals(u2emphasis[j])) {
								numEmphasesFound++;
								found = true;
								j = u2emphasis.length;
							}
						}
						if (!found) {
							numEmphasesNotFound += 1;
						}
						
					}
				}
				distance += Math.abs((numEmphasesFound-numEmphasesNotFound))/5;
				//compare to current 5 closest schools
				for (int b = 0; b < distanceList.size();b++) {
					if (distanceList.isEmpty()) {
						distanceList.add(distance);
					}
					else if (distance < distanceList.get(b)) {						
						distanceList.add(b, distance);
						collegeList.add(b,u2.getName());
					}
					else if (distanceList.size() < 5) {
						distanceList.add(distance);
						collegeList.add(b,u2.getName());
					}
					//checks length of list
					if (distanceList.size() > 5) {
						distanceList.remove(5);
						collegeList.remove(5);
					}
				}
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
