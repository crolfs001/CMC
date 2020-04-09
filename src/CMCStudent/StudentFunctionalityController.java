/**
 * 
 */
package CMCStudent;

import CMCUniversity.University;
import CMCUniversity.UniversityController;
import CMCUniversity.UserSchool;
import CMCUser.User;

/**
 * @author dmurphy001
 *
 */
public class StudentFunctionalityController {
	private String uniName;
	/**
	 * 
	 */
	public StudentFunctionalityController() {
		this.uniName = null;
	}

	/**
	 * 
	 * @param uniName the name of university
	 * @param uniName2 
	 */
	public void pressSaveButton(User user, String uniName) {
		UniversityController uc = new UniversityController();
		UserSchool userschool = new UserSchool(user);
		University uni = uc.getSchoolName(uniName);
		userschool.addSchool(user, uni);
	}
	
	/**
	 * get the name of university
	 * @return the name of university
	 */
	public String getSchool() {
		return this.uniName;
	}
}
