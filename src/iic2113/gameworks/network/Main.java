package iic2113.gameworks.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
-Class description goes here.-
	-Reference to external code-
*
*	@version  0.1
@created_by @group8/maxfindel,jpeeblesg
@update_log
	26/09/2013 - @group8/jpeeblesg
	23/09/2013 - @group8/maxfindel
	dd/mm/yyyy - @groupX/author[,author2,...]          
*/

public class Main {
	
	/**  
	main for chat documentation comment */
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection connection=new Connection();
		System.out.print("If you want to host type 1, if you want to join a game type 2:");
		String chat_type = br.readLine();
		if(chat_type.equals("2")){
			System.out.print("Enter IP of other user");
			String IP = br.readLine();
			connection.newUser(IP);
		}
		else{
			System.out.println("Your IP is: "+ Network.getFullIP());
		}
		while(true){
			String s = br.readLine();
			if(!s.equals("")){
				connection.sendMessage(s);
			}
		}
	}
}
