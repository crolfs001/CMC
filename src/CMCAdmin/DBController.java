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
	ArrayList<User> userList;
	private ArrayList<University> schoolList;
	private UniversityDBLibrary database;

	/**
	 * constructs a  DBController object
	 */
	public DBController() {
		userList = new ArrayList<User>();
		schoolList = new ArrayList<University>();
		database = new UniversityDBLibrary("breakingmatrix","csci230");
		String[][] universityArray = database.university_getUniversities();
		String[][] userArray = database.user_getUsers();
		//translates database schools to the schoolList
		for (int i = 0; i < universityArray.length;i++) {
			University temp = new University(universityArray[i][0],universityArray[i][1], universityArray[i][2], universityArray[i][3], 
					Integer.parseInt(universityArray[i][4]), Double.parseDouble(universityArray[i][5]), Double.parseDouble(universityArray[i][6]), 
					Double.parseDouble(universityArray[i][7]), Double.parseDouble(universityArray[i][8]), Double.parseDouble(universityArray[i][9]), 
					Integer.parseInt(universityArray[i][10]), Double.parseDouble(universityArray[i][11]), Double.parseDouble(universityArray[i][12]), 
					Integer.parseInt(universityArray[i][13]), Integer.parseInt(universityArray[i][14]), Integer.parseInt(universityArray[i][15]));
			schoolList.add(temp);
		}
		//sets the emphases for the universities in the schoolList
		String[][] emphases = database.university_getNamesWithEmphases();
		for (int i = 0; i < emphases.length;i++) {
			String name = emphases[i][0];
			String singleEmphasis = emphases[i][1];
			if (name != null) {
				for (int j = 0; j < schoolList.size(); j++) {
					if (schoolList.get(j).getName().equals(name)) {
						schoolList.get(j).addEmphasis(singleEmphasis);
					}
				}
			}
		}
		
		//translates database users to the userList
		for (int i = 0; i < userArray.length;i++) {
			User tempUser = new User (userArray[i][0], userArray[i][1], userArray[i][2], userArray[i][3], userArray[i][4].charAt(0));
			if (userArray[i][5].charAt(0) == 'N') {
				tempUser.setStatus('N');
			}
			userList.add(tempUser);
		}
		
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
				ArrayList<String> u1emphasis = u1.getEmphases();
				ArrayList<String> u2emphasis = u2.getEmphases();
				int numEmphasesFound = 0;
				int numEmphasesNotFound = 0;
				for (int c = 0; c < u1emphasis.size(); c++) {
					boolean found = false;
					String emphasis = u1emphasis.get(c);
					if (!emphasis.equals(null)) {
						for (int j = 0; j < u2emphasis.size(); j++) {
							if (emphasis.equals(u2emphasis.get(j))) {
								numEmphasesFound++;
								found = true;
								j = u2emphasis.size();
							}
						}
						if (!found) {
							numEmphasesNotFound += 1;
						}
						
					}
				}
				distance += Math.abs((numEmphasesFound-numEmphasesNotFound))/5;
				//compare to current 5 closest schools
				if (distanceList.isEmpty()) {
					distanceList.add(distance);
					collegeList.add(u2.getName());
				}
				boolean inserted = false;
				for (int b = 0; b < distanceList.size() && !inserted;b++) {
					if (distance < distanceList.get(b)) {						
						distanceList.add(b, distance);
						collegeList.add(b,u2.getName());
						inserted = true;
					}
				}
				if (distanceList.size() < 5) {
					distanceList.add(distance);
					collegeList.add(u2.getName());
				}
				//checks length of list
				if (distanceList.size() > 5) {
					distanceList.remove(5);
					collegeList.remove(5);
				}
			}
		}
		//for displaying the distance measures so we know the top 5 are organized from most similar to least similar among the five schools
//		for (double distance : distanceList) {
//			System.out.println(distance);
//		}
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
	private double getMaxExpenses() {
		double max = schoolList.get(0).getExpenses();
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
	private double getMinExpenses() {
		double min = schoolList.get(0).getExpenses();
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
	
	/**
	 * @param Remove saved school from  student saved school
	 */
	public int RemoveSavedSchool(String name, String school) {
		 int result = this.RemoveSavedSchool(name, school);
		 if(result == -1) {
			  throw new IllegalArgumentException("A database error occured.");
		  }
		  else {
			  return result; //TROBINSON001
		  }
		
	}
	
	/**
	 * test method (delete)
	 */
	public void showSchoolList() {
		for(University u : this.schoolList) {
			System.out.println(u.getName());
		}
	}



	public void updateUser(User user) {
		database.user_editUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getType(), user.getStatus());
			
		
	}
}
