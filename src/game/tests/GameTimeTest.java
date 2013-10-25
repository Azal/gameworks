package game.tests;

import static org.junit.Assert.*;
import game.*;
import org.junit.Test;

public class GameTimeTest {
	@Test
	public void time() {
		GameTime t = GameTime.Create();
		long time = t.getElapsedTime();
		t.Pause();
		try {
			Thread.sleep(2);
			t.Resume();
			assertEquals(t.getElapsedTime(), time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void singleton(){
		GameTime t1 = GameTime.Create();
		GameTime t2 = GameTime.Create();
		assertEquals(t1,t2);
	}
	@Test
	public void timeDifference(){
		double maxDiff = 1;
		GameTime gt = GameTime.Create();
		long time1 = System.currentTimeMillis();
		try {
			Thread.sleep(2);
			long time2 = System.currentTimeMillis();
			long time3 = gt.getElapsedTime();
			long diff = time2-time1;
			assertTrue( Math.abs(diff - time3) <= maxDiff );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}