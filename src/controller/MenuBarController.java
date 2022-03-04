package controller;

import application.Main;

public class MenuBarController {
	
	private Main main;

	public MenuBarController() {
		// TODO Auto-generated constructor stub
	}
	
	public void registerMovement() {
		main.showRegisterAMovement();
	}

	public void viewMovements() {
		main.showMovementsTable();
	}
	
	public void backToMainView() {
		main.showMenuBarAndMainMenuInSameStage();
	}
	
	public void exit() {
		main.logOut();
	}
	
	public void setMain(Main main) {
		this.main = main;
	}

}
