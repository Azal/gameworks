package game;

/**
The GameTime is the class responsible for calculating
the elapsed game time.

It does not count the time in which the game has been stopped.

@version  1.0  
@created_by @group6/muZk
@update_log
     22/10/2013 * @group6/muZk - Created the class.
*/

public class GameTime {

	/**
	 * Singleton instance
	 */
	private static GameTime instance;
	
	/**
	 * Saves the starting time of the game (in milliseconds)
	 */
	private long startedAt;
	
	/**	
	 * Saves the last time when the game was paused (in milliseconds)
	 */
	private long lastPausedAt;
	
	/**
	 * Saves the ammount of time that the game has been paused (in milliseconds)
	 */
	private long pausedTime;
	
	private GameTime(){
		startedAt = System.currentTimeMillis();
		pausedTime = 0;
	}
	
	/**
	 * Pauses the GameTime
	 */
	public void Pause(){
		lastPausedAt = System.currentTimeMillis();
	}
	
	/**	
	 * Resumes the GameTime
	 */
	public void Resume(){
		pausedTime = System.currentTimeMillis() - lastPausedAt;
	}
	
	/**
	 * @return the elapsed game time in milliseconds
	 */
	public long getElapsedTime(){
		return System.currentTimeMillis() - startedAt - pausedTime;
	}
	
	/**
	 * @return the elapsed game time in seconds
	 */
	public long getElapsedSeconds(){
		return getElapsedTime() / 1000;
	}

	/**
	 * Singleton Constructor
	 * @return GameTime unique instance
	 */
	public static GameTime Create() {
		if(instance == null)
			instance = new GameTime();
		return instance;
	}
	
	/**
	 * Cast an integer to a string with more than 1 digit.
	 * @param x integer to be casted
	 * @return string of length greater than 1
	 */
	private String cast(long x){
		return x < 10 ? "0"+x : ""+x;
	}
	
	@Override
	public String toString(){
		long totalSeconds = getElapsedTime()/1000;
		long hours = totalSeconds/3600;
		long minutes = (totalSeconds-totalSeconds/3600)/60;
		long seconds = totalSeconds - (totalSeconds-totalSeconds/3600)/60;
		return String.format("%s:%s:%s",cast(hours), cast(minutes), cast(seconds));
	}
	
}