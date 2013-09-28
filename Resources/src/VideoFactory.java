package Resources.src;


public class VideoFactory {
	
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
	
	private String GetExtension(String s) {
		return "wmv";
	}

}
