package CMCUniversity;

import java.util.ArrayList;
import java.util.List;
import CMCAdmin.DBController;;
/**
 * @author lyang001
 * The controller for universities where users can alter their list of universities
 */
public class UniversityController {
	// a list of different universities that controller interacts with 
	private List<List> university;
	private DBController  database;
	/**
	 * 
	 */
	public UniversityController(DBController database) {
		this.database = database;
	}
	
	/**
	*@return returns the name of a university
	*/
	public List<University> getSchool() {
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
	
	/**
	 * gets the top 5 reccomended schools most similar to this school
	 * @param universityName the name of the university 
	 * @return top5List list of 5 closest schools to the input university
	 */
	public ArrayList<String> getTopFiveClosestSchool(String universityName) {
		return database.getTopFiveClosestSchool(universityName);
	}
}
