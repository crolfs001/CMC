/**
 * 
 */
package CMCStudent;

import CMCUniversity.University;
import CMCUniversity.UniversityController;

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
	 */
	public void pressSaveButton(String uniName) {
		UniversityController uc = new UniversityController();
		uc.getSchoolName(uniName);
	}
	
	/**
	 * get the name of university
	 * @return the name of university
	 */
	public String getSchool() {
		return this.uniName;
	}
}
