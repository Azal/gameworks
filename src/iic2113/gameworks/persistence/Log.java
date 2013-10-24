package iic2113.gameworks.persistence;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
Keeps a track of all actions that have occurred, and saves them in the log file
 *
 *	@version  0.1
    @author @group7/nomorejim
    @since 23/10/2013 - @group7/nomorejim
    @update_log
       
 */

public class Log{
	private String path;
	private String date;

	public Log(){
		//add the folder, create it if it doen't exists
		path = "";
		date = getFormatedDate();
	}

	public void saveToLog(String action){

		FileWriter fStream;
        try {
            fStream = new FileWriter(".log", true);
            fStream.append("queryID=" + queryID + "         " + "recall=" + recall + "           Pres=" + presision);
            fStream.append(System.getProperty("line.separator"));
            fStream.flush();
            fStream.close();
        } catch (IOException ex) {
            Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	public String getFormatedDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}