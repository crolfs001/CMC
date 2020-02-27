/**
 * 
 */
package CMCUniversity;
import java.util.ArrayList;
<<<<<<< HEAD
import CMCUser.User;
=======
import CMCUser;
>>>>>>> c3ec8b88773753898103101361192674e9595f27

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
		if(studentName == this.student.getUserName() && !this.savedUniversityList.contains(school)) {
			this.savedUniversityList.add(school);
		}
	}
	
	/**
	 * remove school from savedSchool List
	 * @param school the university
	 * @param studentName the name of a student
	 */
	public void removeSchool(String studentName, University school) {
		if(studentName == this.student.getUserName() && this.savedUniversityList.contains(school)) {
			this.savedUniversityList.remove(school);
		}
	}
}
