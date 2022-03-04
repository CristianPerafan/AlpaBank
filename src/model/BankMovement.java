package model;

import java.time.LocalDate;

import exceptions.InvalidDataException;


public class BankMovement {
	
	//Attributes
	@SuppressWarnings("unused")
	private double amount;
	@SuppressWarnings("unused")
	private String description;
	@SuppressWarnings("unused")
	private TypeOfMovement type;
	@SuppressWarnings("unused")
	private LocalDate date;
	

	public BankMovement(double amount, String description,int identifier,LocalDate date) throws InvalidDataException {
		
		this.amount = amount;
		
		this.description = description;
		
		if(identifier > 1 ) {
			throw new InvalidDataException();
		}
		
		if(identifier == 0) {
			type = TypeOfMovement.GAST0;
		}
		else {
			type = TypeOfMovement.INGRESO;
		}
		
		this.date = date;
				
	}

}
