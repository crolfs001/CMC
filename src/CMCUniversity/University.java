/**
 * 
 */
package CMCUniversity;

/**
 * @author dmurphy001
 *
 */
public class University {

	
	private String name, state, location, control;
	private int numStudents, percentFemal, 
			satVerbal, satMath, expenses, 
			percentFinancialAid, numApplications, percentAdmitted, 
			percentEnrolled, academicsScale, socialScale, qualityOfLifeScale;
	String[] emphases;
	
	/**
	 * Constructor method
	 */
	public University(String name, String state, int numStudents, int percentFemale, int satVerbal, int satMAth, 
			int expenses, int percentFinancialAid, int numApplicants, int percentAdmitted, int percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale, String[] emphases) {
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numStudents = numStudents;
		this.percentFemal = percentFemal;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.expenses = expenses;
		this.percentFinancialAid = percentFinancialAid;
		this.numApplications = numApplications;
		this.percentAdmitted = percentAdmitted;
		this.percentAdmitted = percentAdmitted;
		this.percentEnrolled = percentEnrolled;
		this.academicsScale = academicsScale;
		this.qualityOfLifeScale = qualityOfLifeScale;
		this.emphases = emphases;
	}

	/**
	 * getter for name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for state
	 */
	public String getState() {
		return state;
	}

	/**
	 * setter for state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * getter for location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * setter for location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * getter for control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * setter for control
	 */
	public void setcontrol(String control) {
		this.control = control;
	}

	
	/**
	 * getter for numStudents
	 */
	public int getNumStudents() {
		return numStudents;
	}

	/**
	 * setter for numStudents
	 */
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}

	/**
	 * getter for percentFemal
	 */
	public int getPercentFemal() {
		return percentFemal;
	}

	/**
	 * setter for percentFemal
	 */
	public void setPercentFemal(int percentFemal) {
		this.percentFemal = percentFemal;
	}

	/**
	 * getter for satVerbal
	 */
	public int getSatVerbal() {
		return satVerbal;
	}

	/**
	 * setter for satVerbal
	 */
	public void setSatVerbal(int satVerbal) {
		this.satVerbal = satVerbal;
	}

	/**
	 * getter for satMath
	 */
	public int getSatMath() {
		return satMath;
	}

	/**
	 * setter for satMath
	 */
	public void setSatMath(int satMath) {
		this.satMath = satMath;
	}

	/**
	 * getter for expenses
	 */
	public int getExpenses() {
		return expenses;
	}

	/**
	 * setter for expenses
	 */
	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}

	/**
	 * getter for percentFinancialAid
	 */
	public int getPercentFinancialAid() {
		return percentFinancialAid;
	}

	/**
	 * setter for percentFinancialAid
	 */
	public void setPercentFinancialAid(int percentFinancialAid) {
		this.percentFinancialAid = percentFinancialAid;
	}

	/**
	 * getter for numApplications
	 */
	public int getNumApplications() {
		return numApplications;
	}

	/**
	 * setter for numApplications
	 */
	public void setNumApplications(int numApplications) {
		this.numApplications = numApplications;
	}

	/**
	 * getter for percentAdmitted
	 */
	public int getPercentAdmitted() {
		return percentAdmitted;
	}

	/**
	 * setter for percentAdmitted
	 */
	public void setPercentAdmitted(int percentAdmitted) {
		this.percentAdmitted = percentAdmitted;
	}

	/**
	 * getter for percentEnrolled
	 */
	public int getPercentEnrolled() {
		return percentEnrolled;
	}

	/**
	 * setter for percentEnrolled
	 */
	public void setPercentEnrolled(int percentEnrolled) {
		this.percentEnrolled = percentEnrolled;
	}

	/**
	 * getter for academicsScale
	 */
	public int getAcademicsScale() {
		return academicsScale;
	}

	/**
	 * setter for academicsScale
	 */
	public void setAcademicsScale(int academicsScale) {
		this.academicsScale = academicsScale;
	}

	/**
	 * getter for socialScale
	 */
	public int getSocialScale() {
		return socialScale;
	}

	/**
	 * setter for socialScale
	 */
	public void setSocialScale(int socialScale) {
		this.socialScale = socialScale;
	}

	/**
	 * getter for qualityOfLifeScale
	 */
	public int getQualityOfLifeScale() {
		return qualityOfLifeScale;
	}

	/**
	 * setter for qualityOfLifeScale
	 */
	public void setQualityOfLifeScale(int qualityOfLifeScale) {
		this.qualityOfLifeScale = qualityOfLifeScale;
	}

	public void method() {
		
	}
	
}
