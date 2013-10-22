import java.util.Scanner;

/**
-Main for internal use of Persistence Module.
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */


public class mainPersistence {

	public static void main(String[] args) {
		
		Encrypter s = new Encrypter();
		s.write("tardis");
		s.read("who");
		
		
	}

}
