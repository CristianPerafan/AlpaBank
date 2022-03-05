package model;

import java.time.LocalDate;

import exceptions.InvalidDataException;


public class BankMovement {
	
	//Attributes
	private double amount;
	private String description;
	private TypeOfMovement type;
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
	
	public double getAmount() {
		return amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public TypeOfMovement getType() {
		return type;
	}
	
	public LocalDate getDate() {
		return date;
	}

}
