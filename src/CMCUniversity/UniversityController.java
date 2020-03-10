package controller;

import java.util.List;
import University;
/**
 * @author lyang001
 * The controller for universities where users can alter their list of universities
 */
public class UniversityController {
	// a list of different universities that controller interacts with 
	private List<List> university;
	/**
	 * 
	 */
	public UniversityController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*@return returns the name of a university
	*/
	public List<university> getSchool() {
		return "SJU";
	}
	/**
	* @Username recognizes a students username
	* @University Matches a university to a Usernames and removes school from their list
	*/
	public void removeSavedSchool(Username N, University u){
		
	}
	public List<University> searchSchool(){
		return 0;
	}
	/**
	* @List<University> takes in a list of Universities and displays them
	* @Return return the list of universities
	*/
	public void showSchools(List<University> universitys) {
		return universitys;
	}
}
