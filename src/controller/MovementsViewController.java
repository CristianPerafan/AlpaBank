package controller;

import java.util.Date;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.BankMovement;
import model.TypeOfMovement;

public class MovementsViewController {
	
	@SuppressWarnings("unused")
	private Main main;
	
	@FXML
	TableView<BankMovement> movementsTable;
	
	@FXML
	TableColumn<BankMovement, Double> amountColumn;
	
	@FXML
	TableColumn<BankMovement, String> descriptionColumn;
	
	@FXML
	TableColumn<BankMovement, TypeOfMovement> typeColumn;
	
	@FXML
	TableColumn<BankMovement, Date> dateColumn;
	
	public void initialize() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public MovementsViewController() {
		// TODO Auto-generated constructor stub
	}
	
	

	
	public void setMain(Main main) {
		this.main = main;
	}

}
