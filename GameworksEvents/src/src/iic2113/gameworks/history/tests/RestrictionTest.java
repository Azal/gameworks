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
public class RestrictionTest {

	//Restriction
	@Test
	public void CreateRestrictionTest() {
		org.junit.Assert.assertNotNull("should not be null", new Restriction("Restriction"));
	}
	@Test
	public void CheckRestrictionTest() {
		Restriction r = new Restriction("Restriction");
		r.check();
		org.junit.Assert.assertTrue("should be true", r.done );
	}


}