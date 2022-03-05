package application;
	
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.InitialViewController;
import controller.MainMenuController;
import controller.MenuBarController;
import controller.MovementsTableController;
import controller.RegisterAMovementViewController;
import exceptions.InvalidDataException;
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
	
	public AlfaBank alfaBank;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		users = new Users();
		alfaBank = new AlfaBank();
		burnValues();
		
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
	
	
	public void showRegisterAMovement() {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MenuBar.fxml"));
			BorderPane root = (BorderPane)loader.load();
			
			MenuBarController controller = loader.getController();
			
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			
			Stage stage = new Stage();
			
			stage.setScene(scene);
			
			currentStage.close();
			
			
			BorderPane newRoot;
			
			//Addition
			FXMLLoader registerloader = new FXMLLoader(getClass().getResource("../ui/RegisterAMovementView.fxml"));
			BorderPane mainMenu = (BorderPane)registerloader.load();
			
			RegisterAMovementViewController registerController = registerloader.getController();
			System.out.print("Register a movement: "+this);
			registerController.setMain(this);
			
			
			newRoot = (BorderPane)stage.getScene().getRoot();
			newRoot.setCenter(mainMenu);
			
			currentStage = stage;
			stage.show();
			
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMovementsTable() {
		try {
			
			FXMLLoader tableViewLoader = new FXMLLoader(getClass().getResource("../ui/MovementsTable.fxml"));
			BorderPane root = (BorderPane)tableViewLoader.load();
			
			MovementsTableController viewController = tableViewLoader.getController();

			viewController.setMain(this);
			
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);

			stage.show();
		
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	public void logOut() {
		currentStage.close();
		showInitialView();
	}
	
	public void burnValues() {
		
		try {
			addAMomevent(new BankMovement(500000,"Venta bicicleta",1, LocalDate.of(2022,02, 23)));
			addAMomevent(new BankMovement(200000,"Cumpleaños hermana",0, LocalDate.of(2022,02, 24)));
			addAMomevent(new BankMovement(200000,"Zapatillas",0,LocalDate.of(2022,02,25)));
			addAMomevent(new BankMovement(200000,"Paseo",0,LocalDate.of(2022,01,06)));
			
			
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addAMomevent(BankMovement movement) {
		alfaBank.addMovement(movement);
	}
	
	public Main returnMain() {
		return this;
	}
	
	public ArrayList<BankMovement> returnMovement() {		
		ArrayList<BankMovement> arrayList = alfaBank.returnMovements();
		return arrayList;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
