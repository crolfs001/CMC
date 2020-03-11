package CMCStudent;

import java.util.ArrayList;
import CMCStudent.Student;
import CMCUniversity.University;
/**
 * @author lyang001
 *
 */
public class StudentInteraction {
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
	
	public String pressSaveButton() {
		return this.uniName;
	}
	public void viewSchoolInfo() {
		
	}
	/*public University displayTopFive(ArrayList<String> recSchools) {
		
		return recSchools;
		
	}*/
	public void viewProfilPage() {
		
	}
	public void promptRemove() {
		
	}
	public ArrayList<University> searchSchool(){
		ArrayList<University> searchResult = new ArrayList<University>();
		return searchResult;
	}
	public void resetSearch() {
		
	}
	public void confirmRemove() {
		
	}
	public Student cancelChange(Student s) {
		return s;	
	}
	public void makeEditAble() {
		
	}
}
