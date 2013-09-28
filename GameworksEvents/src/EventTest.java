

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


    //Event Manager
    @Test
	public void CreateEventManagerTest() {
		org.junit.Assert.assertNotNull("should not be null", EventManager.getInstance());
	}
    @Test
	public void EventManagerCreateEventTest() {
		EventManager em = EventManager.getInstance();

    	ArrayList<Result> results = new ArrayList<Result>(); 
		results.add(new Result("r_1") );
		ArrayList<Restriction> restrictions = new ArrayList<Restriction>(); 
		restrictions.add(new Restriction("r_1") );

		org.junit.Assert.assertNotNull("should not be null", em.createEvent("Event_1", restrictions, results));
	}

	
    @Test
	public void EventManagerCheckEventStatusTest() {
		EventManager em = EventManager.getInstance();

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
	public void EventManagerAddRestrictionToEventTest() {
		EventManager em = EventManager.getInstance();

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