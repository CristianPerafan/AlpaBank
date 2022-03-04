package application;
	
import java.io.IOException;

import controller.InitialViewController;
import controller.MainMenuController;
import controller.MenuBarController;
import controller.MovementsViewController;
import controller.RegisterAMovementViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.AlfaBank;
import model.BankMovement;
import model.Users;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


@SuppressWarnings("unused")
public class Main extends Application {
	
	private Stage currentStage;
	
	private Users users;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		users = new Users();
		
		users.addUser("admin","admin");
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
			controller.setUsers(users);
			
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
			

			currentStage.close();
			
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
	
	public void showMovementsTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MovementsView.fxml"));
			BorderPane root = (BorderPane)loader.load();
			
			MovementsViewController controller = loader.getController();
			
			
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			
			Stage stage = new Stage();
			
			stage.setScene(scene);
			
			stage.show();
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showRegisterAMovement() {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MenuBar.fxml"));
			BorderPane root = (BorderPane)loader.load();
			
			MenuBarController controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			
			Stage stage = new Stage();
			
			stage.setScene(scene);
			
			//stage.show();
			currentStage.close();
			currentStage = stage;
			
			BorderPane newRoot;
			
			BorderPane mainMenu = (BorderPane)FXMLLoader.load(getClass().getResource("../ui/RegisterAMovementView.fxml"));
			
			newRoot = (BorderPane)stage.getScene().getRoot();
			newRoot.setCenter(mainMenu);
			
			stage.show();
			
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Back() {
		currentStage.close();
		showMenuBarAndMainMenuInSameStage();
	}
	
	public void logOut() {
		currentStage.close();
		showInitialView();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
