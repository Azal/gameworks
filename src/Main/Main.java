package Main;

public class Main {

	/**
		-Class description goes here.-
			-Reference to external code-
	 *
	 *	@version  0.1
	    @created_by @group8/maxfindel,jpeeblesg
	    @update_log
	    	23/09/2013 - @group8/maxfindel
	    	dd/mm/yyyy - @groupX/author[,author2,...]          
	 */

	/**  
    main documentation comment 
	 * @throws Exception */
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello gaming world!");
		
		Game game = Game.Create("Test", 800, 400);
		game.Init();
	}

}
