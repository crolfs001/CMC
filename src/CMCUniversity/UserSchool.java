/**
 * 
 */
package CMCUniversity;
import java.util.ArrayList;
import CMCUser.User;

/**
 * @author dmurphy001
 *
 */
public class UserSchool {

	private ArrayList<University> savedUniversityList;
	private User student;
	/**
	 * UserSchool Constructor
	 */
	public UserSchool(User student) {
		this.savedUniversityList = new ArrayList<>();
		this.student = student;
	}

	/**
	 * add school to savedschools List
	 * @param school the university
	 * @param studentName the name of a student
	 */
	public void addSchool(String studentName, University school) {
		if(studentName.equals(this.student.getUserName()) && !this.savedUniversityList.contains(school)) {
			this.savedUniversityList.add(school);
		}
	}
	
	/**
	 * remove school from savedSchool List
	 * @param school the university
	 * @param studentName the name of a student
	 */
	public void removeSchool(String studentName, University school) {
		if(studentName.equals(this.student.getUserName()) && this.savedUniversityList.contains(school)) {
			this.savedUniversityList.remove(school);
		}
	}
}
