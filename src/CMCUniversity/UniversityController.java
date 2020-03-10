package CMCUniversity;

import java.util.ArrayList;

public class UniversityController {

	private ArrayList<University> schoolList;
	private String uniName;
	
	public UniversityController(String uniName) {
		this.uniName = uniName;
	}

	/**
	 * get a school
	 * @return a school
	 */
	public String getSchool() {
		return this.uniName;
	}
}
