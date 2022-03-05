package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import application.Main;
import exceptions.InvalidDataException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BankMovement;
import model.TypeOfMovement;

public class MovementsViewController {
	
	private Main main;
	
	
	public MovementsViewController() {
		
	}
	
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
	
	public void initialize() throws InvalidDataException{
		
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("Monto"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Descripción"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
		
		ArrayList<BankMovement> bankMovements = new ArrayList<>();
		
		bankMovements = main.returnMovement();
		
		
		
		LocalDate date = LocalDate.now();
		
		
		bankMovements.add(new BankMovement(2000,"Transporte",0,date));
		
        ObservableList<BankMovement> movements = FXCollections.observableArrayList(bankMovements);
		
		movementsTable.setItems(movements);		
		
	}
	
	@FXML
	public void doSomething() {
		
		BankMovement movements = movementsTable.getSelectionModel().getSelectedItem();
		System.out.println(movements);
	}
	
	
	

	
	public void setMain(Main main) {
		this.main = main;
	}

}
