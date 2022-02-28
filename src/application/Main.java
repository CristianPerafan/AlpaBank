package application;
	
import java.io.IOException;

import controller.InitialViewController;
import controller.MainMenuController;
import controller.MenuBarController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Stage currentStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			showInitialView();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showInitialView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/InitialView.fxml"));
			BorderPane root;
			root = (BorderPane)loader.load();
			
			InitialViewController controller = loader.getController();
			
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage = stage;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void showMenuBarAndMainMenuInSameStage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MenuBar.fxml"));
			BorderPane root = (BorderPane)loader.load();
			
			MenuBarController controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			
			Stage stage = new Stage();
			
			stage.setScene(scene);
			
			//stage.show();
			currentStage = stage;
			
			BorderPane newRoot;
			
			BorderPane mainMenu = (BorderPane)FXMLLoader.load(getClass().getResource("../ui/MainMenu.fxml"));
			
			newRoot = (BorderPane)stage.getScene().getRoot();
			newRoot.setCenter(mainMenu);
			
			stage.show();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
