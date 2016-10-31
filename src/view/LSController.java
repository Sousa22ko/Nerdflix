package view;

import java.util.Random;

import application.SceneBuilder;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class LSController {
	
	
	@FXML
	private ImageView gif;

	@FXML
	private ImageView logo;
	
	
	public static void main(String[] args) {
		
		Random r = new Random();
		int n;
		n = r.nextInt(11);
		n = n + 5;
		System.out.println(n);
		
		try {
			Thread.currentThread().sleep(n*1000);


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
