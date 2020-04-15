import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import CMCAdmin.DBControllerTest;
import CMCAdmin.DriverTest;
import CMCStudent.StudentFunctionalityControllerTest;
import CMCStudent.StudentInteractionTest;
import CMCStudent.StudentTest;
import CMCUniversity.UniversityControllerTest;
import CMCUniversity.UniversityTest;
import CMCUniversity.UserSchoolTest;
import CMCUser.AccountControllerTest;
import CMCUser.UserInteractionTest;
import CMCUser.UserTest;
import FunctionalityTests.*;

@RunWith(Suite.class)
@SuiteClasses({DBControllerTest.class,DriverTest.class,StudentFunctionalityControllerTest.class,StudentInteractionTest.class,
	StudentTest.class,UniversityControllerTest.class,UniversityTest.class, UserSchoolTest.class,AccountControllerTest.class,
	UserInteractionTest.class,UserTest.class,LoginTest.class,LogoutTest.class, TopFiveRecpmmendedSchoolsTest.class, ViewUserListTest.class,
	AddUserTest.class,DeleteUserTest.class,ActivateAndDeactivateTest.class, EditProfileTest.class})
public class AllTests {

}
