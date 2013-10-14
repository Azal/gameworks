import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.plaf.FileChooserUI;


/**
-find and updates files path or create them if don't exists
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */

public class FileManager implements IFile  {

	List<File> results = null;
	
	@Override
	public boolean isFile(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String findFile(File root, String name) {		

		 results = new ArrayList<File>();//Cleans the results list at the beginning
		 
		if(!root.isDirectory()){
		    throw new IllegalArgumentException("File root is not a directory");
		  }
		  File[] files = root.listFiles();
		  for(int i=0; i<files.length; i++){
		    File file = files[i];
		    //if is directory, it starts to search in this directory
		    if(file.isDirectory()){
		      findFile(file, name);
		    }
		    //It compares to the file's name
		    if(file.getName().matches(name)){
		      addResult(file);
		    }
		  }
		 
		if(!results.isEmpty())
			return results.get(0).getAbsolutePath();
		else
			return null;
	}

	@Override
	public boolean newFile(File path, Object o) {
		
		if(!path.isDirectory()){
		    throw new IllegalArgumentException("File root is not a directory");
		 }
		
		File f = null;
		boolean bool;
	      
	      try{
	         // create new file
	         f = new File((File)o, path.getAbsolutePath());
	         
	         // tries to create new file in the system
	         bool = f.createNewFile();
	         
	         // prints
	         System.out.println("File created: "+bool);
	            
	      }catch(Exception e){
	         e.printStackTrace();
	      }
			
		
		
		
		return false;
	}
	
	//Print the path to the found files
	private void showResults(){
	  for(File archivo : results){
	    System.out.println(archivo.getAbsolutePath());
	  }
	}
	
	//Add a file to the search findings
	private void addResult(File file){
	  results.add(file);
	}
	
	
	
	/**class bottom**/	
}
