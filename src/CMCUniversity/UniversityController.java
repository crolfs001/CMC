package CMCUniversity;

import java.util.ArrayList;
import java.util.List;
import CMCAdmin.DBController;;
/**
 * @author lyang001
 *
 */
public class UniversityController {
	private List<List> university;
	private DBController  database;
	/**
	 * 
	 */
	public UniversityController(DBController database) {
		this.database = database;
	}
	public List<University> getSchool() {
		return 0;
	}
	public void removeSavedSchool(Username N, University u){
		
	}
	public List<University> searchSchool(){
		return 0;
	}
	public void showSchools(List<University> universitys) {
		
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
