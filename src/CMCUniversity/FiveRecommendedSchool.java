package CMCUniversity;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FiveRecommendedSchool {

	/*
	 * @return top five recommended schools 
	 */
	public List<String> displayTopFive(String university ) {
	
		List<String> topFive = getTopFiveClosestSchool(university); 
		
		return topFive;
	}
	
	/*
	 * @param calculate the five closest school related to the 
	 * search school
	 * 
	 * @return five closest school graded
	 */
	private List<String> getTopFiveClosestSchool(String university) {
		
		List<String> collegeList = new ArrayList<String>();
		collegeList.add("UMD");
		collegeList.add("SJU");
		collegeList.add("UM");
		collegeList.add("SCU");
		collegeList.add("SPC");
		
		return collegeList;
	}
	
}

