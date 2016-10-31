package application;

import java.io.IOException;

import extras.ConectionManager;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Content;
import view.HomePageController;
import view.Main;
import view.VideoScreenController;

public class SceneBuilder {

	private static Stage primaryStage;
	private static Scene scene;

	public static Object getComponent(String path) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(path));

		try {
			return loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static void setPrimaryStage(Stage stage) {

		primaryStage = stage;
		primaryStage.setResizable(false);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				ConectionManager.closeConection();
				System.out.println("fechou porra!!");
			}
		});
		
	}

	public static void createLogin() {

		AnchorPane pane = (AnchorPane) getComponent("LoginNerd.fxml");
		scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void createCadastro() {

		AnchorPane pane = (AnchorPane) getComponent("CadastroNerd.fxml");
		scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	
	public static void createHomePage() {

		AnchorPane pane = (AnchorPane) getComponent("HomePage.fxml");
		HomePageController.loadScreen();
		scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void createVideoScreen(String path) {

		AnchorPane pane = (AnchorPane) getComponent("VideoScreen.fxml");
		VideoScreenController.setPath(path);
		scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void createContentScreen() {

		AnchorPane pane = (AnchorPane) getComponent("ContentScreen.fxml");
		scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void createLoadScreen() {

		AnchorPane pane = (AnchorPane) getComponent("LS.fxml");
		scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void createHomePageADM() {

		AnchorPane pane = (AnchorPane) getComponent("HomePageADM.fxml");
		scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void createNewContent() {
		// TODO Auto-generated method stub
		AnchorPane pane = (AnchorPane) getComponent("CadastroNewContent.fxml");
		scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
}


