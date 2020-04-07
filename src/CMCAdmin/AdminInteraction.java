package CMCAdmin;

import java.util.ArrayList;

import CMCUniversity.UniversityController;
import CMCUser.AccountController;
import CMCUser.UserInteraction;
import CMCUser.User;

public class AdminInteraction extends UserInteraction{
	private User user;
	private AccountController accountController;
	private UniversityController universityController;
	
	/**
	 * constructs an adminInteraction
	 * @param accountController the account controller this interaction works with
	 * @param universityController the university controller this interaction works with
	 */
	public AdminInteraction(AccountController accountController, UniversityController universityController) {
		super(accountController, universityController);
	}
	
	/**
	 * returns the list of users for the admin to see
	 * @returns the list of all users
	 */
	public ArrayList<User> viewListofUsers() {
		ArrayList<User> studentList = accountController.viewListofUsers();
		return studentList;
	}
	

}
