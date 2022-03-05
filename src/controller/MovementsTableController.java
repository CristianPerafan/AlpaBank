package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.BankMovement;
import model.TypeOfMovement;

public class MovementsTableController {
	
	@FXML
	TableView<BankMovement> movementsTable;
	
	@FXML
	TableColumn<BankMovement, Double> amountColumn;
	
	@FXML
	TableColumn<BankMovement, String> descriptionColumn;
	
	@FXML
	TableColumn<BankMovement, TypeOfMovement> typeColumn;
	
	@FXML
	TableColumn<BankMovement, LocalDate> dateColumn;
	
	@FXML
	private Button uptadeTableButton;
	
	@FXML
	private Text wastedMoneyText,earnedMoneyText,moneyBalanceText;
	
	@FXML
	private DatePicker initialDatePicker;
	
	@FXML
	private DatePicker finalDatePicker;
	
	@FXML
	private Button filterButton;
	
	
	
	private Main main;
	

	
	public void uptadeTable(ActionEvent e) {
		filterButton.setVisible(true);
		showTable(getBankMovements());
	}
	
	public void filterMovements(ActionEvent e) {
		filterMovementsForDate();
	}
	
	public MovementsTableController() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void showTable(ArrayList<BankMovement> input) {
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		
		ArrayList<BankMovement> movementsModel = new ArrayList<>();
		movementsModel = input;
		
		/*
		movementsModel = main.returnMovement();
		*/
		
		
		ObservableList<BankMovement> movements = FXCollections.observableArrayList(movementsModel);
		movementsTable.setItems(movements);
		
		
		wastedMoneyText.setText("$ "+String.valueOf( calculateWastedMoney(movementsModel)));
		wastedMoneyText.setVisible(true);
		

		earnedMoneyText.setText("$ "+String.valueOf(calculateEarnedMoney(movementsModel)));
		earnedMoneyText.setVisible(true);
		
		moneyBalanceText.setText("$ "+String.valueOf( calculateMoneyBalance(movementsModel)));
		moneyBalanceText.setVisible(true);
	}
	
	public ArrayList<BankMovement> getBankMovements(){
		ArrayList<BankMovement> movementsModel = new ArrayList<>();
		movementsModel = main.returnMovement();
		return  movementsModel;
	}
	
	public void filterMovementsForDate(){
		
		ArrayList<BankMovement> filteredMovements = new ArrayList<>();
		filteredMovements = getBankMovements();
		ArrayList<BankMovement>  auxFilteredMovements = new ArrayList<>();
		
		LocalDate initialDate = initialDatePicker.getValue();
		LocalDate finalDate = finalDatePicker.getValue();
		
		
		for(int i = 0; i<filteredMovements.size();i++) {
			if(filteredMovements.get(i).getDate().isAfter(initialDate)) {
				
				if(filteredMovements.get(i).getDate().isBefore(finalDate)) {
					auxFilteredMovements.add(filteredMovements.get(i));
				}
			}
				
			
		}
		
		ObservableList<BankMovement> movements = FXCollections.observableArrayList(auxFilteredMovements);
		movementsTable.setItems(movements);

	}
	
	public double calculateWastedMoney(ArrayList<BankMovement> movementsModel) {
		double wastedMoney = 0;
		
		for(int i = 0;i<movementsModel.size();i++) {
			if(movementsModel.get(i).getType() == TypeOfMovement.GAST0) {
				wastedMoney += movementsModel.get(i).getAmount();
			}
		}
		
		return wastedMoney;
	}
	
	public double calculateEarnedMoney(ArrayList<BankMovement> movementsModel) {
		double earnedMoney = 0;
		for(int i = 0;i<movementsModel.size();i++) {
			if(movementsModel.get(i).getType() == TypeOfMovement.INGRESO) {
				earnedMoney += movementsModel.get(i).getAmount();
			}
		}
		
		return earnedMoney;
	}
	
	public double calculateMoneyBalance(ArrayList<BankMovement> movementsModel) {
		double balance = 0;
		
		double wastedMoney = 0;
		double earnedMoney = 0;
		
		for(int i = 0;i<movementsModel.size();i++) {
			if(movementsModel.get(i).getType() == TypeOfMovement.INGRESO) {
				earnedMoney += movementsModel.get(i).getAmount();
			}
			else if(movementsModel.get(i).getType() == TypeOfMovement.GAST0) {
				wastedMoney += movementsModel.get(i).getAmount();
			}
		}
		
		balance = earnedMoney-wastedMoney;
		
		return balance;
	}
	
	
	
	
	
	
	public void setMain(Main main) {
		this.main = main;
	}
	

}
