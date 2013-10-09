Package Persistence.tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
-Class description goes here.-
	-Reference to external code-
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */


@RunWith(Suite.class)
@SuiteClasses({communicatorTest.class, encrypterTest.class,fileTest.class})
public class AllTests {}