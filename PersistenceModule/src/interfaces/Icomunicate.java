package interfaces;

/**
-Class description goes here.-
	-Reference to external code-
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */

/**  
main documentation comment */

public interface Icomunicate {
	
	public boolean send(char module);
	
	public String ask(String s, char asktype);
	
	public boolean subscribe();

	/**class bottom**/	
}
