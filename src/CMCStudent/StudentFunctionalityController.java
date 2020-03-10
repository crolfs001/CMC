/**
 * 
 */
package CMCStudent;

import CMCUniversity.University;

/**
 * @author dmurphy001
 *
 */
public class StudentFunctionalityController {
	private String uniName;
	/**
	 * 
	 */
	public StudentFunctionalityController(String uniName) {
		this.uniName = uniName;
	}

	/**
	 * if students press the button, this method will get the name of the university
	 * @return if pressed, return the name of the university
	 */
	public String pressSaveButton() {
		return this.uniName;
	}
}
