import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {
		System.out.println("Ingresa qué quieres calcular: ");
		Calculator calc=new Calculator();
		while(true){
			try{
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				String s = bufferRead.readLine();

				System.out.println(calc.parse(s));
				//System.out.println(s);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
