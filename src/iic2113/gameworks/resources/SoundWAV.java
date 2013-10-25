package iic2113.gameworks.resources;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.FloatControl; 
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @Version 0.1
 * @created_by @group2/Ignacio Carmach
 *
 */

public class SoundWAV extends Thread implements ISound{
	enum Position { 
        LEFT, RIGHT, NORMAL
    };

    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb 
    
    private Position curPosition;
    
    
    private String filename;

	public SoundWAV(String path) {
		filename = path;
		curPosition = Position.NORMAL;
	}

	public SoundWAV(String path, Position p) { 
        filename = path;
        curPosition = p;
    }

	public boolean playSynchronous() {
		File soundFile = new File(filename);
        if (!soundFile.exists()) { 
        	System.err.println("Wave file not found: " + filename);
        	return false;
        } 
 
        AudioInputStream audioInputStream = null;
        
        try { 
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (UnsupportedAudioFileException e1) { 
            e1.printStackTrace();
            return false;
        } catch (IOException e1) { 
            e1.printStackTrace();
            return false;
        } 
 
        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
 
        try { 
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
        } catch (LineUnavailableException e) { 
            e.printStackTrace();
            return false;
        } catch (Exception e) { 
            e.printStackTrace();
            return false;
        } 
 
        if (auline.isControlSupported(FloatControl.Type.PAN)) { 
            FloatControl pan = (FloatControl) auline
                    .getControl(FloatControl.Type.PAN);
            if (curPosition == Position.RIGHT) 
                pan.setValue(1.0f);
            else if (curPosition == Position.LEFT) 
                pan.setValue(-1.0f);
        } 
 
        auline.start();
        int nBytesRead = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
 
        try { 
            while (nBytesRead != -1) { 
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) 
                    auline.write(abData, 0, nBytesRead);
            }
        } catch (IOException e) { 
            e.printStackTrace();
            return false;
        } finally { 
            auline.drain();
            auline.close();
        }
        
        return true;
	}

	public boolean playAsynchronous() {
		new SoundWAV(filename).start();
		return true;
	}

	public void run() {
		playSynchronous();
	}
}