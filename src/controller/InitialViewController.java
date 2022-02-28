package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

//Class
import application.Main;

public class InitialViewController {
	
	@FXML
	private Button getIntoButton;
	
	private Main main;
	
	public void openMainMenu(ActionEvent e) {
		main.showMenuBarAndMainMenuInSameStage();
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	
}
