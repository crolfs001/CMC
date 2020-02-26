/**
 * 
 */
package CMCUniversity;
import java.util.ArrayList;

/**
 * @author dmurphy001
 *
 */
public class UserSchool {

	private ArrayList<University> savedUniversityList;
	
	/**
	 * 
	 */
	public UserSchool() {
		this.savedUniversityList = new ArrayList<University>;
	}

	/**
	 * @param school the university
	 */
	public void addSchool(University school) {
		this.savedUniversityList.add(school);
	}
	
	/**
	 * @param school the university
	 */
	public void removeSchool(University school) {
		this.savedUniversityList.remove(school);
	}
}
