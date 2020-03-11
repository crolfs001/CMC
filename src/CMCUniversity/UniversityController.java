package CMCUniversity;

import java.util.ArrayList;
import CMCUniversity.University;
import CMCUser.User;
/**
 * @author lyang001
 *
 */
public class UniversityController {
	private ArrayList<University> schoolList;
	private String uniName;
	
	/**
	 * 
	 * @param uniName
	 */
	public UniversityController(String uniName) {
		this.uniName = uniName;
	}
	/**
	 * get the name of university
	 * @return university name
	 */
	public String getSchool() {
		return this.uniName;
	}
	public void removeSavedSchool(User N, University u){
		
	}
	public ArrayList<University> searchSchool(){
		ArrayList<University> u = new ArrayList<University>();
		return u;
	}
	public void showSchools(ArrayList<University> universitys) {
		
	}
}
