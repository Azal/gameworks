package Resources.src;
import java.awt.image.*;

/**
 * @Version 0.1
 * @created_by @group2/Mauricio Vera
 *
 */

public interface IImage {
	
	/* Esta interfaz representa a todas las distintas clases de imagenes
	 * que el framework podra manejar. La idea es que, para los que consuman
	 * el modulo de recursos, manejar distintos tipos de imagenes sea transparente
	 */
	
	public boolean rotate() ;
	public java.awt.Image getImageObject();
	public void filterGreyScale(int option);
	public boolean reloadImage();
}


