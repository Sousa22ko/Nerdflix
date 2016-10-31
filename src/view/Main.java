package view;
import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.dao.UserDao;
import application.SceneBuilder;
import javafx.application.Application;
import javafx.stage.Stage;
import model.User;

public class Main extends Application {


	@Override
	public void start(Stage primaryStage) {
		
		SceneBuilder.setPrimaryStage(primaryStage);
		SceneBuilder.createLogin();
	}

	public static void main(String[] args) {
		launch(args);
		 
	}
	

}


