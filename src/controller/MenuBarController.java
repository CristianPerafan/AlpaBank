package controller;

import application.Main;
import javafx.fxml.FXML;

public class MenuBarController {
	
	private Main main;

	public MenuBarController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	public void showMainMenuview() {
		main.showMenuBarAndMainMenuInSameStage();
	}
	
	public void setMain(Main main) {
		this.main = main;
	}

}
