package Resources.src;


public class Main {

	/**
	-Class description goes here.-
		-Reference to external code-
	 *
	 *	@version  0.1
	    @created_by @group2/ijcarmach
	    @update_log
	    	26/09/2013 - @group8/maxfindel
	    	26/09/2013 - @group2/ijcarmach
	    	dd/mm/yyyy - @groupX/author[,author2,...]          
	 */
	
	/**  
    main documentation comment */
	public static void main(String[] args) {
		SoundFactory sf = new SoundFactory();
		
		ISound sound = sf.createSound("path");
		sound.Play();
	}

}
