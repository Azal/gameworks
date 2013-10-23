package src.iic2113.gameworks.persistence;

import java.io.File;
import java.io.FileWriter;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
-Send and ask information from other modules. They must be subscribed.
 *
 *	@version  0.1
    @author @group7/nomorejim
    @since 23/10/2013 - @group7/nomorejim
    @update_log
       
 */

static public class Log{
	private String path
	private Date date;

	public Log(){
		//add the folder, create it if it doen't exists
		path = ;
		date = getDate();
	}

	public void saveToLog(String action){

	}

	public Date getDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}