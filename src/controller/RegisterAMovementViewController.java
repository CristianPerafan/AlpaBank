package controller;

import java.time.LocalDate;


import application.Main;
import exceptions.InvalidDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.BankMovement;

public class RegisterAMovementViewController {
	
	@FXML
	private TextField textFieldAmount;
	
	@FXML
	private TextField textFieldDescription;
	
	@FXML 
	private RadioButton wasteRadioButton;
	
	@FXML
	private RadioButton incomeRadioButton;
	
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private Button saveMovementButton;
	
 
		
	private Main main;
	

	

	

	public RegisterAMovementViewController() {
		
	}
	
	public void saveMovement(ActionEvent e) {
		saveMovementInformation();
	}
	
	
	public void saveMovementInformation() {
		
		
		//To obtain the amount of the movement
		String auxAmount = textFieldAmount.getText();
		
	
		//To obtain the description of the movement
		String description = textFieldDescription.getText();
		
	
		//To obtain the type of the movement
		int typeOfMovement = 3;
	
		if(wasteRadioButton.isSelected() == true) {
			//Waste
			typeOfMovement = 0;
		}
		else if(incomeRadioButton.isSelected() == true) {
			//Income
			typeOfMovement = 1;
		}
		
		//To obtain the date of the movement
		LocalDate date = datePicker.getValue();
		
	
		
		try {
			double amount = Double.parseDouble(auxAmount);
			BankMovement obj = new BankMovement(amount,description,typeOfMovement,date);
			
			System.out.println("main rm :"+main);
			main.addAMomevent(obj);
			
			
			
			//
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Proceso exitoso!!");
			alert.setHeaderText("El movimiento ha sido registrado!!");
			alert.showAndWait();
			main.showMenuBarAndMainMenuInSameStage();
			
			
		
			
		
		}catch(InvalidDataException | RuntimeException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de registro!!");
			alert.setHeaderText("Los datos no son válidos o están incompletos..");
		    
			alert.showAndWait();
		}
		
	}
	

	

	public void setMain(Main main) {
		this.main = main;
	}
}
