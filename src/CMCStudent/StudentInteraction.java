package CMCStudent;

import java.util.ArrayList;
import CMCStudent.Student;
import CMCUniversity.University;
import CMCUniversity.UniversityController;
import CMCUser.User;

import java.util.List;

import CMCAdmin.DBController;
import CMCUniversity.University;

/**
 * @author lyang001
 * The interactions that a student will go thorugh when navigating the program
 */
public class StudentInteraction extends DBController {
	// An instance variable for a student to be used in the interaction
	private Student student;
	private String uniName;
	private UniversityController universityController;
	private User userName;
	private University university;
	
	/**
	 * 
	 */
	public StudentInteraction() {
		this.uniName = null;
		this.universityController = null;
		this.university = null;
		this.userName = null;
	}


	public void openViewSavedSchools(){
		
	}

	/**
	 * save the name of university
	 * @param uniName name of university
	 */
	public void pressSaveButton (String uniName) {
		StudentFunctionalityController sfc = new StudentFunctionalityController();
		sfc.pressSaveButton(uniName);
	}

	/**
	 * get the name of university
	 * @return the name of university
	 */
	public String getSchool() {
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
		System.out.println("Would you like to remove this School from your list?");
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
	boolean confirmation = false;
	if ( confirmation == true) {
		//RemoveSavedSchool(userName, university);
		System.out.print("to be work on");
	}
	else {
		System.out.println("cancel");
	}
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
		


