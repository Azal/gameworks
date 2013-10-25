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
 *		24/10/2013 * @group4/Squirrels - Updated the tests. 
 */
public class EventManagerTest {

	

    //Event Manager
    @Test
	public void CreateHistoryManagerTest() {
		org.junit.Assert.assertNotNull("should not be null", HistoryManager.getInstance());
	}
    @Test
	public void HistoryManagerCreateEventTest() {
    	HistoryManager em = HistoryManager.getInstance();

    	ArrayList<Result> results = new ArrayList<Result>(); 
		results.add(new Result("r_1") );
		ArrayList<Restriction> restrictions = new ArrayList<Restriction>(); 
		restrictions.add(new Restriction("r_1") );

		org.junit.Assert.assertNotNull("should not be null", em.createEvent("Event_1", restrictions, results));
	}

	
    @Test
	public void HistoryManagerCheckEventStatusTest() {
    	HistoryManager em = HistoryManager.getInstance();

    	ArrayList<Result> results = new ArrayList<Result>(); 
		results.add(new Result("r_1") );
		ArrayList<Restriction> restrictions = new ArrayList<Restriction>(); 
		restrictions.add(new Restriction("r_1") );

		em.createEvent("Event_2", restrictions, results);
		org.junit.Assert.assertFalse("should be false", em.checkEventStatus("Event_2") );
		em.markRestrictionAsDone("r_1") ;
		//TODO expand this test
		 em.triggerEvent("Event_2");
		//org.junit.Assert.assertTrue("should be true", em.checkEventStatus("Event_2") );
	}


	
    @Test
	public void HistoryManagerAddRestrictionToEventTest() {
    	HistoryManager em = HistoryManager.getInstance();

		//org.junit.Assert.testAssertNull("EM: Needs Restriction and Event", em.addRestrictionToEvent("Event_1", "Restriction_1") );


		ArrayList<Result> results = new ArrayList<Result>(); 
		results.add(new Result("r_1") );
		ArrayList<Restriction> restrictions = new ArrayList<Restriction>(); 
		restrictions.add(new Restriction("r_1") );

		em.createEvent("Event_4", restrictions, results);
		
		//org.junit.Assert.assertFalse("EM: Needs Restriction", em.addRestrictionToEvent("Event_1", "Restriction_1") );
		em.addRestriction(new Restriction("Restriction_1")) ;
		em.addRestrictionToEvent("Event_1", "Restriction_1") ;

		org.junit.Assert.assertFalse("EM: Should fail trigger, needs restrictions done", em.triggerEvent("Event_4") );
		em.markRestrictionAsDone("Restriction_1") ;
		em.markRestrictionAsDone("r_1") ;
		org.junit.Assert.assertFalse("EM: trigger event", em.triggerEvent("Event_4") );


		
	}





}