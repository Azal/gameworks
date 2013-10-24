package iic2113.gameworks.resources;

/**
 * @Version 0.1
 * @created_by @group2/Nicol?s Castro
 *
 */

public abstract class Factory {

	/*
	 * Esta clase es la base de todas las factories que hay en la seccion de 
	 * recursos. El objetivo de estas, es poder crear recursos de distintos tipos,
	 * segun su extension, sin que el cliente se de cuenta.  
	 */
	
	
	protected String getExtension(String path) {
		String extension = "";
		
		int i = path.lastIndexOf('.');
		if (i > 0) {
		    extension = path.substring(i+1);
		}
		return extension;
	}
}
