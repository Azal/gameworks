package src.iic2113.gameworks.resources;

/**
 * @Version 0.1
 * @created_by @group2/Ignacio Carmach
 *
 */

public class VideoFactory extends Factory{
	
	public VideoFactory() {
		
	}
	
	public IVideo createVideo(String path) {
		if(getExtension(path).equals("wmv")) {
			return new VideoWMV(path);
		}
		
		else {
			return null;
		}
	}
	
	

}
