import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {
		System.out.println("Ingresa qué quieres calcular: ");
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
			}
		}
	}
}
