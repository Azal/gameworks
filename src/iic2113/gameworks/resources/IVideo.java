package iic2113.gameworks.resources;

/**
 * @Version 0.1
 * @created_by @group2/Ignacio Carmach
 *
 */

public interface IVideo {
	
	/* 
	 * Esta interfaz representa a todas las distintas clases de videos
	 * que el framework podra manejar. La idea es que, para los que consuman
	 * el modulo de recursos, todos los videos se manejen de la misma manera,
	 * sin importar su extension
	 */
	
	public boolean play() ;
}
