package controller;

import application.Main;

public class MainMenuController {
	
	private Main main;
	
	

	public MainMenuController() {
		// TODO Auto-generated constructor stub
	}
	
	public void openMainMenu() {
		main.showMenuBarAndMainMenuInSameStage();
	}
	
	public void setMain(Main main) {
		this.main = main;
	}

}
