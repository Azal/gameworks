
package iic2113.gameworks.history.tests;
import iic2113.gameworks.history.*;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;


/**
 * Tests for {@link Event}.
 *
 * @author @group4/Kulppi
 * @update_log
 *		26/09/2013 * @group4/kulppi - Created the class and test. 
 */
public class EventTest {

	
	//Events
    @Test
	public void CreateEventTest() {
		org.junit.Assert.assertNotNull("should not be null", new Event("event_test", null, null ));
		
		//restriccions 
		ArrayList<Restriction> restrictions = new ArrayList<Restriction>(); 
		restrictions.add(new Restriction("r_1") );
		org.junit.Assert.assertNotNull("should not be null", new Event("event_test", restrictions, null ));
		
		//results
    	ArrayList<Result> results = new ArrayList<Result>(); 
		results.add(new Result("r_1") );
		org.junit.Assert.assertNotNull("should not be null", new Event("event_test", restrictions, results ));

    	//repeat
		//org.junit.Assert.assertNotNull("should not be null", new Event("event_test", null, null, true ));
	}
    @Test
	public void EventBasicBehaviorTest() {
		Event e = new Event("event_test", null, null);
		org.junit.Assert.assertTrue("should be true", e.isDone());
		e.addRestriction(new Restriction("restriction_1")  );
		org.junit.Assert.assertFalse("should be false", e.isDone());
		e.getRestrictions().get(0).check();
		org.junit.Assert.assertTrue("should be true", e.isDone());
		e.triggerEvent();
	}







}