package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {
	
	private Main main;
	
	@FXML
	private Button openButton;
	
	public MainMenuController() {
		// TODO Auto-generated constructor stub
	}
	
	public void openTablaView(ActionEvent e) {
		System.out.println(main);
		main.showMovementsTable();
	}
	
	public void setMain(Main main) {
		this.main = main;
	}

}
