package PreviewModule.Test;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import PreviewModule.MainFrame;

public class MainFrameTest {

	public MainFrameTest(){}	
	private FrameFixture window;
	
	@Before 
	public void setUp() {
		  /*MainFrame frame = GuiActionRunner.execute(new GuiQuery<MainFrame>() {
		      protected MainFrame executeInEDT() {
		        return new MainFrame();  
		      }
		  });
		  window = new FrameFixture(frame);
		  window.show(); // shows the frame to test
		  */
	}
	
	@After
	public void tearDown() {
		//window.cleanUp();
	}
	
	@Test
	public void testButtons() {
		//window.label("lblGameWorksInterface").requireText("GameWorks Interface");
		//window.button("editCharacterBtn").click();
		MainFrame frame = new MainFrame();
		Assert.assertEquals(frame.editCharacterBtn.getText(), "Edit Character");
	}
}