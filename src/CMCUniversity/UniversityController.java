package CMCUniversity;

import java.util.ArrayList;
import CMCUniversity.University;
import CMCUser.User;
import java.util.List;
import CMCAdmin.DBController;;
/**
 * @author lyang001
 * The controller for universities where users can alter their list of universities
 */
public class UniversityController {
	private ArrayList<University> schoolList;
	private String uniName;
	private User userName;

	// a list of different universities that controller interacts with 
	private List<List> university;
	private DBController  database;

	/**
	 * 
	 * @param uniName
	 */
	public UniversityController() {
		this.uniName = null;
	}

	/**
	 * get the name of university
	 * @param uniName
	 * @return
	 */
	public University getSchoolName(String uniName) {
		DBController db = new DBController();
		return db.getSchool(uniName);
	}
	
	/**
	 * 
	 * @param database
	 */
	public UniversityController(DBController database) {
		this.database = database;
	}
	
	/**
	*@return returns the name of a university
	*/
	/*public List<University> getSchool() {
		return "SJU";
	}*/
	/**
	* @Username recognizes a students username
	* @University Matches a university to a Usernames and removes school from their list
	*/
	public ArrayList<University> searchSchool(){
		ArrayList<University> u = new ArrayList<University>();
		return u;
	}

	/**
	* @List<University> takes in a list of Universities and displays them
	* @Return return the list of universities
	*/
	public void showSchools(List<University> universitys) {
		return ;
	}
	
	/**
	 * gets the top 5 recommended schools most similar to this school
	 * @param universityName the name of the university 
	 * @return top5List list of 5 closest schools to the input university
	 */
	public ArrayList<String> getTopFiveClosestSchool(String universityName) {
		return database.getTopFiveClosestSchool(universityName);
	}
	
	/**
	 * @param Remove saved school from  student saved school
	 */
	public String removeSavedSchool(User n, University u) {
	 database.removeSavedSchool(n, u);
	 return "The save school have been reomved.";
	}
	
}
