package iic2113.gameworks.resources;

import java.io.*;
import java.util.Locale;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Transmitter;
import javax.swing.JOptionPane;

//import org.apache.commons.lang3.*;

/**
 * @Version 0.1
 * @created_by @group2/Ignacio Carmach
 *
 */

public class SoundMidi implements ISound {
	/*
	 * Esta clase representa objetos de sonido .mid
	 */	
	
	private String fileName;
	
	public SoundMidi( String path ){
		fileName = path;
	}
	
	private static boolean useExternalSynth = false;
	
	
	public boolean playSynchronous() {
		MidiDevice receivingDevice = null;
		
		try {
			receivingDevice = getReceivingDevice();
			receivingDevice.open();
			File cancion = new File(fileName);
	        
	        Sequence sequence1 = MidiSystem.getSequence(cancion);
	        Sequencer sequencer1 = MidiSystem.getSequencer(false);
	        Transmitter tx1 = sequencer1.getTransmitter();
	        Receiver rx1 = receivingDevice.getReceiver();
	        tx1.setReceiver(rx1);

	        sequencer1.open();
	        sequencer1.setSequence(sequence1);
	        
	        sequencer1.start();
	        
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        JOptionPane.showMessageDialog(null, "Tocando cancion");
		
		return true;
	}


	public boolean playAsynchronous() {
		
		return true;
	}
	
	private MidiDevice getReceivingDevice() throws MidiUnavailableException {
        for (MidiDevice.Info mdi: MidiSystem.getMidiDeviceInfo()) {
            MidiDevice dev = MidiSystem.getMidiDevice(mdi);
            if (dev.getMaxReceivers() != 0) {
                //String lcName = StringUtils.defaultString(mdi.getName()).toLowerCase(Locale.ENGLISH);
                //if (lcName.contains(useExternalSynth? "usb": "java")) {
                //    return dev;
                //}
            }
        }
        return null;
    }
	
}
