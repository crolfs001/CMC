/**
 * 
 */
package CMCUniversity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author crolfs001
 *
 */
public class UniversityControllerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	List<University> universitys;
	universitys.add("SJU");
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowSchools() {
		String list = UniversityController.showSchools(Universitys);
		Assert.assertEquals("SJU",list);
		
		
	}

}
