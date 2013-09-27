

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link Event}.
 *
 * @author @group4/Kulppi
 */
@RunWith(JUnit4.class)
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
		org.junit.Assert.asser("should be true", r.done );
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
		org.junit.Assert.assertNotNull("should not be null", new Event("event_test", null, null, true ));
	}
    @Test
	public void EventBasicBehaviorTest() {
		Event e = new Event("event_test", null, null);
		org.junit.Assert.assert("should be true", e.isDone());
		e.addRestriction(new Restriction("restriction_1")  );
		org.junit.Assert.assert("should be false", e.isDone());
		e.getRestrictions().get(0).check();
		org.junit.Assert.assert("should be true", e.isDone());
		e.triggerEvent();
	}


    //Event Manager
    @Test
	public void CreateEventManagerTest() {
		org.junit.Assert.assertNotNull("should not be null", new EventManager());
	}
    @Test
	public void EventManagerCreateEventTest() {
		EventManager em = new EventManager();

    	ArrayList<Result> results = new ArrayList<Result>(); 
		results.add(new Result("r_1") );
		ArrayList<Restriction> restrictions = new ArrayList<Restriction>(); 
		restrictions.add(new Restriction("r_1") );

		org.junit.Assert.assertNotNull("should not be null", em.createEvent("Event_1", restrictions, results));
	}

	
    @Test
	public void EventManagerCheckEventTest() {
		EventManager em = new EventManager();

    	ArrayList<Result> results = new ArrayList<Result>(); 
		results.add(new Result("r_1") );
		ArrayList<Restriction> restrictions = new ArrayList<Restriction>(); 
		restrictions.add(new Restriction("r_1") );
		em.createEvent("Event_1", restrictions, results);
		
		org.junit.Assert.assert("should be true", em.checkEventStatus("Event_1") );
		org.junit.Assert.testAssertNull("should be null", em.checkEventStatus("Event_2") );
	}

	
    @Test
	public void EventManagerAddRestrictionToEventTest() {
		EventManager em = new EventManager();

		org.junit.Assert.testAssertNull("EM: Needs Restriction and Event", em.addRestrictionToEvent("Event_1", "Restriction_1") );


    	ArrayList<Result> results = new ArrayList<Result>(); 
		results.add(new Result("r_1") );
		ArrayList<Restriction> restrictions = new ArrayList<Restriction>(); 
		restrictions.add(new Restriction("r_1") );
		em.createEvent("Event_1", restrictions, results);
		
		org.junit.Assert.testAssertNull("EM: Needs Restriction", em.addRestrictionToEvent("Event_1", "Restriction_1") );
		org.junit.Assert.assert("EM: Add Restriction", em.addRestriction("Restriction_1") );
		
		org.junit.Assert.assert("EM: Add Restriction and Event", em.addRestrictionToEvent("Event_1", "Restriction_1") );

		org.junit.Assert.assertFalse("EM: Should fail trigger, needs restrictions done", em.triggerEvent("Event_1") );
		org.junit.Assert.assert("EM: check restriction", em.markRestrictionAsDone("Restriction_1") );
		org.junit.Assert.assert("EM: check restriction", em.markRestrictionAsDone("r_1") );
		org.junit.Assert.assertFalse("EM: trigger event", em.triggerEvent("Event_1") );


		
	}





}