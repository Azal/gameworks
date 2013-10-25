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
		org.junit.Assert.assertTrue("EM: trigger event", em.triggerEvent("Event_4") );		
	}
    
    @Test
	public void HistoryManagerPacManTest() {

    	HistoryManager em = HistoryManager.getInstance();
    	
    	// Event that allow access to level 2
	    	ArrayList<Result> results = new ArrayList<Result>(); 
			results.add(new Result("Pasar a nivel 2")
			{
				public void execute()
				{
					System.out.println("¡Has pasado al nivel 2!");
				}
			});
			ArrayList<Restriction> restrictions = new ArrayList<Restriction>(); 
			restrictions.add(new Restriction("Comerse 3 pelotas")
			{
				public void check(int pelotasComidas)
				{
					if(pelotasComidas >= 3)
						done = true;				
				}			
			});
	    	em.createEvent("Acceder Nivel 2", restrictions, results);
	    
    	results.clear();
    	restrictions.clear();
    	
	    // Event that determine the end of the game
	    	results.add(new Result("Se termina el juego")
			{
				public void execute()
				{
					System.out.println("¡Mala suerte, el juego se ha acabado!");
				}
			});
	    	restrictions.add(new Restriction("No tener vidas")
			{
				public void check(int vidas)
				{
					if(vidas <= 0)
						done = true;				
				}			
			});
	    	em.createEvent("GameOver", restrictions, results);
	    	
	    // The tests
	    	int vidas = 3;
	    	int pelotasComidas = 0;
	    	
	    	org.junit.Assert.assertFalse("You cannot access level 2", em.triggerEvent("Acceder Nivel 2"));
	    	org.junit.Assert.assertFalse("The Game isn't over", em.triggerEvent("GameOver"));
	    	
	    	em.markRestrictionAsDone("GameOver", vidas);
	    	em.markRestrictionAsDone("Acceder Nivel 2", pelotasComidas);
	    	
	    	org.junit.Assert.assertFalse("You still cannot access level 2", em.triggerEvent("Acceder Nivel 2"));
	    	org.junit.Assert.assertFalse("The Game isn't over again", em.triggerEvent("GameOver"));
	    		    	
	    	pelotasComidas = 3;	    	
	    	em.markRestrictionAsDone("Acceder Nivel 2", pelotasComidas);	    	
	    	org.junit.Assert.assertTrue("You can access level 2", em.triggerEvent("Acceder Nivel 2"));
	    	
	    	vidas = 0;
	    	em.markRestrictionAsDone("GameOver", vidas);
	    	org.junit.Assert.assertTrue("The Game is over", em.triggerEvent("GameOver"));
	    
    }





}