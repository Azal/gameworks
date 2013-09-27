
public class Main 
{
	public static void main(String[] args) 
	{
		//Main, used to test the EventManager
		EventManager em = EventManager.getInstance();
		em.createEvent("Evento1",null, null);
		Restriction ret1 = new Restriction("Restriction1");
		Result res1 = new Result("Result1");
		em.addRestriction(ret1);
		em.addRestrictionToEvent("Evento1", "Restriction1");
		em.addResultToEvent("Evento1", res1);
		em.checkAllRestrictions();
		System.out.println(em.checkEventStatus("Evento1"));
		//em.checkEventStatus("Evento2");
		
	}

}
