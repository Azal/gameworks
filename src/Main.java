<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {
		System.out.println("Ingresa quŽ quieres calcular: ");
		Calculator calc=new Calculator();
		String mensaje="";
		while(!mensaje.equals("salir")){
			try{
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				 mensaje = bufferRead.readLine();
				 if(!mensaje.equals("salir"))
				System.out.println(calc.parseJS(mensaje));
				//System.out.println(s);
			}
			catch(IOException e)
			{
				e.printStackTrace();
=======
package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import src.net.Network;
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
	private Network network;
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.print("Enter String: ");
			String s = br.readLine();
			System.out.println(s);
			System.out.print("Enter Integer: ");
			try{
				int i = Integer.parseInt(br.readLine());
				System.out.println(i);
			}catch(NumberFormatException nfe){
				System.err.println("\nInvalid Format!");
>>>>>>> 2ac77006fa7e3ada89ebbf61dfa85b81c90fdbea
			}
		}
	}
}
