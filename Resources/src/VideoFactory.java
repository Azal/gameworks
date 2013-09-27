package Resources.src;


public class VideoFactory extends Factory{
	
	public VideoFactory() {
		
	}
	
	public IVideo createVideo(String path) {
		if(GetExtension(path).equals("wmv")) {
			return new VideoWMV(path);
		}
		
		else {
			return null;
		}
	}
	
	

}
