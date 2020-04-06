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
		if(studentName.equals(this.student.getUserName())) {
			for(University u : this.savedUniversityList) {
				if(u.getName().equals(school.getName())) {
					System.out.println("This university is already in the list!");
					return;
				}
			}
			this.savedUniversityList.add(school);
		}
	}
	
	/**
	 * remove school from savedSchool List
	 * @param school the university
	 * @param studentName the name of a student
	 */
	public void removeSchool(String studentName, University school) {
		if(studentName.equals(this.student.getUserName())) {
			for(University u : this.savedUniversityList) {
				if(u.getName().equals(school.getName())) {
					this.savedUniversityList.remove(u);
					System.out.println("This university is already removed!");
					return;
				}
			}
			System.out.println("This university is not exited!");
		}
	}
	
	/*
	 * 
	 */
	public void showSaveSchoolList() {
		for(University u : this.savedUniversityList) {
			System.out.println(u.getName());
		}
	}
}
