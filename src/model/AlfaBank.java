package model;

import java.util.ArrayList;



public class AlfaBank {
	
	ArrayList<BankMovement> movementList;
	
	public AlfaBank() {
		movementList = new ArrayList<>();
	}
	
	public void addMovement(BankMovement bankMovement) {
		
		movementList.add(bankMovement);
		
		
	}

}
