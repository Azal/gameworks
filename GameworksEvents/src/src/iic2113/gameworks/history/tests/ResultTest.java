
package src.iic2113.gameworks.history.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import src.iic2113.gameworks.history.*;

import java.util.ArrayList;


/**
 * Tests for {@link Event}.
 *
 * @author @group4/Kulppi
 * @update_log
 *		26/09/2013 * @group4/kulppi - Created the class and test. 
 */
public class ResultTest {

	

	//Result
	@Test
	public void CreateResultTest() {
		org.junit.Assert.assertNotNull("should not be null", new Result("Result"));
	}
	@Test
	public void ExecuteResultTest() {
		Result r = new Result("Result");
		r.execute();
	}







}