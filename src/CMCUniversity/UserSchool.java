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

	private ArrayList<String> savedUniversityList;
	private User student;
	private DBController database;
	/**
	 * UserSchool Constructor
	 */
	public UserSchool(User student) {
		this.savedUniversityList = new ArrayList<>();
		this.database = new DBController();
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
		this.savedUniversityList.add(uni.getName());
		return outputmessage;
	}
	
	/**
	 * remove school from savedSchool List
	 * @param school the university
	 * @param studentName the name of a student
	 */
	public String removeSchool(User user, University school) {
		String outputmessage = "";
		outputmessage = this.database.removeSavedSchool(user, school);
		for(int i = 0 , len= this.savedUniversityList.size();i<len;++i){
			  if(school.getName().equals(this.savedUniversityList.get(i))){
			       this.savedUniversityList.remove(i);
			       --len;
			       --i;
			 }
		}
		return outputmessage;
	}
	
	/**
	 * get saved universities of this student
	 * @param student
	 * @return
	 */
	public String[][] getSaveSchoolList(User student) {
		String[][] result = this.database.getAllSavedUniversityList();
		return result;
	}
	
	/**
	 * get user
	 * @return
	 */
	public User getUser() {
		return this.student;
	}
	/**
	 * get Unversity
	 * @param schoolName
	 * @return
	 */
	public University getSchool(String schoolName) {
		return this.database.getSchool(schoolName);
	}
	
}
