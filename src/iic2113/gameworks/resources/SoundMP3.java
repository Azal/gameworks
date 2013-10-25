package iic2113.gameworks.resources;

import java.io.Console;
import java.io.File;

import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;

/**
 * @Version 0.1
 * @created_by @group2/Ignacio Carmach
 * @update_log
 * 	30/08/2013 * @group2/Nicol‡s Castro    
 *
 */


public class SoundMP3 implements ISound{
	
	private String path;
	private Format input1;
	private Format input2;
	private Format output;
	
	public SoundMP3(String path) {
		this.path = path;
		input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
		input2 = new AudioFormat(AudioFormat.MPEG);
		output = new AudioFormat(AudioFormat.LINEAR);
		PlugInManager.addPlugIn(
			"com.sun.media.codec.audio.mp3.JavaDecoder",
			new Format[]{input1, input2},
			new Format[]{output},
			PlugInManager.CODEC
		);
	}

	public boolean playSynchronous() {
		try{
			Player player = Manager.createPlayer(new MediaLocator(new File(path).toURI().toURL()));
			player.start();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return true;
	}

	public boolean playAsynchronous() {
		//play it.
		return true;
	}

}
