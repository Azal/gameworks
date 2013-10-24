package iic2113.gameworks.Preview.Test;

import iic2113.gameworks.Preview.MainFrame;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
		MainFrame frame = MainFrame.getInstance();
		Assert.assertEquals(frame.editCharacterBtn.getText(), "Edit Character");
	}
}