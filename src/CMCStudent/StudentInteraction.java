import java.util.List;
import Student;
/**
 * @author lyang001
 * The interactions that a student will go thorugh when navigating the program
 */
public class StudentInteraction {
	// An instance variable for a student to be used in the interaction
	private Student student;
	/**
	 * 
	 */
	public StudentInteraction() {
		// TODO Auto-generated constructor stub
	}

	public void openViewSavedSchools(){
		
	}
	/**
	*@University requires a university to save
	*@return returns the school name	
	*/
	public university pressSaveButton (University school) {
		
		return school;
	}
	public void viewSchoolInfo() {
		
	}
	/**
	* @List requires a list of recommeneded schools to return
	* @return returns a list of the top 5 recommended schools for a university
	*/
	public university displayTopFive(List<String> recSchools) {
		
		return recSchools;
		
	}
	public void viewProfilPage() {
		
	}
	public void promptRemove() {
		
	}
	/**
	* @return Returns a list of schools that match the criteria the student searched for
	*/
	public List<String> searchSchool(){
		List<university> searchResult;
		return searchResult;
	}
	public void resetSearch() {
		
	}
	public void confirmRemove() {
		
	}
	/**
	* @student requires a student in order to cancel change
	* @return returns the students previous info
	*/
	public Student cancelChange(Student s) {
		return s;	
	}
	public void makeEditAble() {
		
	}
}
