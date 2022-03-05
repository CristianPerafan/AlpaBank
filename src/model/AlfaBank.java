package model;

import java.util.ArrayList;



public class AlfaBank {
	
	ArrayList<BankMovement> movementList  = new ArrayList<>();
	
	public AlfaBank() {
	
	}
	
	public void addMovement(BankMovement bankMovement) {
		
		movementList.add(bankMovement);
		
	}
	
	public ArrayList<BankMovement> returnMovements(){
		return movementList;
	}
	
	public String toString() {
		
		String out = "";
		
		for(int i = 0;i<movementList.size();i++) {
			out += movementList.get(i).toString()+"\n";
		}
		return out;
		
	}

}
