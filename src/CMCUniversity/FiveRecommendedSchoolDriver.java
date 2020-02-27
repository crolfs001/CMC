import FiveRecommendedSchool.*;
import java.util.ArrayList;

public class FiveRecommendedSchoolDriver {

	public static void main(String[] args) {
		
		int i = 0;
		
		ArrayList<String> collegeList = new ArrayList<String>();
		
		collegeList.add("UMD");
		collegeList.add("SJU");
		collegeList.add("UM");
		collegeList.add("SCU");
		collegeList.add("SPC");
		
		while (i < 4) {
		System.out.println(collegeList.get(i) + "/n");	
		i++;	
		}
	}
	
}
