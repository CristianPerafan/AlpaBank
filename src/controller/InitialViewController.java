package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Users;

//Class
import application.Main;
import exceptions.PasswordNotMatchException;
import exceptions.UserNotFoundException;

public class InitialViewController {
	
	private Users users;
	
	@FXML
	private Button getIntoButton;
	
	@FXML
	TextField userField;
	
	@FXML
	PasswordField passwordField;
	
	private Main main;
	
	public void openMainMenu(ActionEvent e) {
		validateLogin();
	}
	
	public void validateLogin() {
		
		String user = userField.getText();
		String password = passwordField.getText();
	
		try {
			
			users.validate(user, password);
			
			main.showMenuBarAndMainMenuInSameStage();
			
		}catch(UserNotFoundException | PasswordNotMatchException e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de ingreso!!");
			alert.setHeaderText("Usuario no registrado..");
			
			if(e instanceof UserNotFoundException) {
				alert.setContentText("El usuario no se encuentra registado");
			}
			else{
				alert.setContentText("La contraseña es incorrecta");
			}
			alert.showAndWait();
		}
	}
	
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	
}
