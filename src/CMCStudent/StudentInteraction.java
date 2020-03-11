<<<<<<< HEAD
package CMCStudent;

import java.util.ArrayList;
import CMCStudent.Student;
import CMCUniversity.University;
=======
import java.util.List;
import CMCUniversity.University;

>>>>>>> 227a0fc70f672924f06ff15fe34b7207b398d9a0
/**
 * @author lyang001
 * The interactions that a student will go thorugh when navigating the program
 */
public class StudentInteraction {
	// An instance variable for a student to be used in the interaction
	private Student student;
	private String uniName;
	
	/**
	 * 
	 */
	public StudentInteraction(String uniName) {
		this.uniName = uniName;
	}


	public void openViewSavedSchools(){
		
	}
<<<<<<< HEAD
	
	public String pressSaveButton() {
		return this.uniName;
=======

	/**
	*@University requires a university to save
	*@return returns the school name	
	*/
	public University pressSaveButton (University school) {
		
		return school;
>>>>>>> 227a0fc70f672924f06ff15fe34b7207b398d9a0
	}
	public void viewSchoolInfo() {
		
	}
<<<<<<< HEAD
	/*public University displayTopFive(ArrayList<String> recSchools) {
=======
	/**
	* @List requires a list of recommeneded schools to return
	* @return returns a list of the top 5 recommended schools for a university
	*/
	public university displayTopFive(List<String> recSchools) {
>>>>>>> 227a0fc70f672924f06ff15fe34b7207b398d9a0
		
		return recSchools;
		
	}*/
	public void viewProfilPage() {
		
	}
	public void promptRemove() {
		
	}
<<<<<<< HEAD
	public ArrayList<University> searchSchool(){
		ArrayList<University> searchResult = new ArrayList<University>();
=======
	/**
	* @return Returns a list of schools that match the criteria the student searched for
	*/
	public List<String> searchSchool(){
		List<University> searchResult;
>>>>>>> 227a0fc70f672924f06ff15fe34b7207b398d9a0
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
