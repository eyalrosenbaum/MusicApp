package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = getClass().getResource("MusicMainScene.fxml");
			AnchorPane pane = FXMLLoader.load(url);
			Scene scene = new Scene(pane);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("MusicApp");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
