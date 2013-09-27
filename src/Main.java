package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	/**
		-Class description goes here.-
			-Reference to external code-
	 *
	 *	@version  0.1
	    @created_by @group8/maxfindel,jpeeblesg
	    @update_log
	    	23/09/2013 - @group8/maxfindel
	    	dd/mm/yyyy - @groupX/author[,author2,...]          
	 */

	/**  
	main documentation comment */
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection connection=new Connection();
		System.out.print("If you want to host type 1, if you want to be added type 2:");
		String chat_type = br.readLine();
		if(chat_type.equals("1")){
			System.out.print("Enter IP of other user");
			String IP = br.readLine();
			connection.addUser(IP, "6740");
		}
		else{
			System.out.println("Waiting");
		}
		while(true){
			System.out.print("Enter Message: ");
			String s = br.readLine();
			connection.sendMessage(s, " ");
			//System.out.print(s);
		}
	}
}
