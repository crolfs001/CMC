package CMCStudent;

import java.util.ArrayList;
import CMCStudent.Student;
import CMCUniversity.University;
import CMCUniversity.UniversityController;

import java.util.List;
import CMCUniversity.University;

/**
 * @author lyang001
 * The interactions that a student will go thorugh when navigating the program
 */
public class StudentInteraction {
	// An instance variable for a student to be used in the interaction
	private Student student;
	private String uniName;
	private UniversityController universityController;
	
	/**
	 * 
	 */
	public StudentInteraction(String uniName) {
		this.uniName = uniName;
		this.universityController = null;
	}


	public void openViewSavedSchools(){
		
	}

	/**
	*@University requires a university to save
	*@return returns the school name	
	*/
	public String pressSaveButton () {
		
		return this.uniName;
	}


	/**
	* finds the five closest schools for an input school name
	* @List requires a list of recommeneded schools to return
	* @return returns a list of the top 5 recommended schools for a university
	*/
	public ArrayList<String> displayTopFive(String universityName) {		
		return universityController.getTopFiveClosestSchool(universityName);
		
	}
	public void viewProfilPage() {
		
	}
	public void promptRemove() {
		
	}

	/**
	* @return Returns a list of schools that match the criteria the student searched for
	*/
	public List<String> searchSchool(){
		ArrayList<String> searchResult = new ArrayList<String>();
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
		


