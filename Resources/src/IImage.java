package Resources.src;
import java.awt.image.*;

/**
 * @Version 0.1
 * @created_by @group2/Mauricio Vera
 *
 */

public interface IImage {
	public boolean rotate() ;
	public java.awt.Image getImageObject();
	public void filterGreyScale(int option);
}


