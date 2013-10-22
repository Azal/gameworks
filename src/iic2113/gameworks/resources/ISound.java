package src.iic2113.gameworks.resources;

/**
 * @Version 0.1
 * @created_by @group2/Ignacio Carmach
 *
 */

public interface ISound {
	
	/* 
	 * Esta interfaz representa a todas las distintas clases de sonidos
	 * que el framework podra manejar. La idea es que, para los que consuman
	 * el modulo de recursos, todos los sonidos se manejen de la misma manera,
	 * sin importar su extension
	 */
	
	
	public boolean playSynchronous();
	public boolean playAsynchronous();
}
