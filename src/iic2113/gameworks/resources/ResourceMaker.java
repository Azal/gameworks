package src.iic2113.gameworks.resources;

/**
 * @Version 0.1
 * @created_by @group2/Nicolás Castro
 *
 */

public class ResourceMaker {

	/* 
	 * Esta clase es la fachada de entrada a todos los tipos de recursos que 
	 * el framework podrá manejar. A través de esta, se pueden crear
	 * los objetos de las distintas interfaces (ej: sonidos o imagenes).
	 */
	
	private SoundFactory soundMaker;
	private ImageFactory imageMaker;
	private VideoFactory videoMaker;
	private SpriteFactory spriteMaker;
	
	public ResourceMaker(){
		soundMaker = new SoundFactory();
		imageMaker = new ImageFactory();
		videoMaker = new VideoFactory();
		spriteMaker = new SpriteFactory();
	}
	
	
	public ISound createSound( String path ){
		return soundMaker.createSound( path );
	}
	
	public IImage createImage( String path ){
		return imageMaker.createImage(path);
	}
	
	public IVideo createVideo( String path ){
		return videoMaker.createVideo(path);
	}
	
	public ISprite createSprte( String path){
		return spriteMaker.createSprite(path);
	}
	
}
