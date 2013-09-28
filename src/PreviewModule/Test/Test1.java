package PreviewModule.Test;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.core.Robot;
import org.fest.swing.finder.FrameFinder;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JListFixture;
import org.fest.swing.launcher.ApplicationLauncher;

public class Test1 extends TestCase {
	private FrameFixture window;
	private Robot robot;
	ApplicationLauncher app;
	
	@Before
	protected void setUp() throws Exception {
		app = ApplicationLauncher.application(Main.class);
		app.start();

		robot = BasicRobot.robotWithCurrentAwtHierarchy();
		robot.settings().delayBetweenEvents(50);

		FrameFinder ff = WindowFinder.findFrame(MainForm.class);

		// Find the main window
		window = ff.using(robot);
	}

	@After
	public void tearDown()
	{
		window.cleanUp();
	}
	
	
}
