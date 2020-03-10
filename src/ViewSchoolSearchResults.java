/**
 * 
 */
package Student;

import controller.UniversityController;

import java.util.List;

import controller.DatabaseController;
/**
 * @author lyang001
 *
 */
public class ViewSchoolSearchResults {
	private static String results;
	/**
	 * @param args
	 */
	public static void main() { 
		List<University> uList;
		// TODO Auto-generated method stub
		DatabaseController.getSchool();
		UniversityController.showSchools(uList);
		
	}
	

}
