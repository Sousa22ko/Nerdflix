package extras;

import java.io.File;
import javafx.scene.media.Media;
import model.Content;

public class ContentSettings {
	private static Content contentSelected;
	private static String time;
	private static Content video1;
	
	public static void setMedia(Content novo){
		video1 = novo;
		
		/*video1 = new Content();
		video1.setAtor("Capitao Nascimento");
		video1.setCategoria("Humor");
		video1.setDescricao("Video de humor");
		video1.setFaixaEtaria(0);
		video1.setImagepath("C:/Users/manom/workspace/NerdFlix/src/resources/imagens/Go shit.jpg");
		video1.setVideopath("C:/Users/manom/workspace/NerdFlix/src/resources/videos/Go shit.mp4");
		video1.setNome("Vai dar merda");
		video1.setTemporadas(0);*/
	}
	

	public static Media getMedia(Content novo) {
		//String path = new File(contentSelected.getImagepath()).getAbsolutePath();
		setMedia(novo);
		String path = video1.getVideopath();// "C:/Users/manom/workspace/NerdFlix/src/resources/videos/Go shit.mp4";
		return new Media(new File(path).toURI().toString());
	}

	public static void setTime(String time) {
		ContentSettings.time = time;
		System.out.println("setTime() + " + ContentSettings.time); 
	}


}
