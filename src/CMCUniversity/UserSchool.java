/**
 * 
 */
package CMCUniversity;
import java.util.ArrayList;

import CMCAdmin.DBController;
import CMCUser.User;

/**
 * @author dmurphy001
 *
 */
public class UserSchool {

	private ArrayList<University> savedUniversityList;
	private User student;
	private DBController database;
	/**
	 * UserSchool Constructor
	 */
	public UserSchool(User student) {
		this.savedUniversityList = new ArrayList<>();
		this.student = student;
	}

	/**
	 * add school to savedschools List
	 * @param object the university
	 * @param user the name of a student
	 * @return 
	 */
	public String addSchool(User user, University uni) {
		String outputmessage = "";
		outputmessage = this.database.updateSavedUniversityList(user, uni);
		return outputmessage;
	}
	
	/**
	 * remove school from savedSchool List
	 * @param school the university
	 * @param studentName the name of a student
	 */
	public void removeSchool(User user, University school) {
		if(user.getUserName().equals(this.student.getUserName())) {
			for(University u : this.savedUniversityList) {
				if(u.getName().equals(school.getName())) {
					this.savedUniversityList.remove(u);
					System.out.println("This university is removed!");
					return;
				}
			}
			System.out.println("This university is not exited!");
		}
	}
	
	/**
	 * 
	 */
	public void showSaveSchoolList() {
		for(University u : this.savedUniversityList) {
			System.out.println(u.getName());
		}
	}
	
	/**
	 * get the last university's name
	 * @return
	 */
	public String getLastSchool() {
		University u = null;
		int l = this.savedUniversityList.size();
		u = this.savedUniversityList.get(l-1);
		return u.getName();
	}
	
	/**
	 * get student's username
	 * @return
	 */
	public String getUserName() {
		return this.student.getUserName();
	}
}
