package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import application.Main;
import exceptions.InvalidDataException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	private Text wastedMoneyText,earnedMoneyText;
	
	
	
	private Main main;
	

	
	public void uptadeTable(ActionEvent e) {
		showTable();
	}
	public MovementsTableController() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize() {
		
	}
	
	public void showTable() {
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		ArrayList<BankMovement> movementsModel = new ArrayList<>();
		
		movementsModel = main.returnMovement();
		
		LocalDate date = LocalDate.now();
		
		try {
			movementsModel.add(new BankMovement(20000,"Transporte",0,date));
			movementsModel.add(new BankMovement(20000,"Pago prima",1,date));
		} catch (InvalidDataException e) {
			e.printStackTrace();
		}
		
		ObservableList<BankMovement> movements = FXCollections.observableArrayList(movementsModel);
		movementsTable.setItems(movements);
		
		double wastedMoney = 0;
		
		for(int i = 0;i<movementsModel.size();i++) {
			if(movementsModel.get(i).getType() == TypeOfMovement.GAST0) {
				wastedMoney += movementsModel.get(i).getAmount();
			}
		}
		wastedMoneyText.setText("$ "+String.valueOf(wastedMoney));
		wastedMoneyText.setVisible(true);
		
	
		double earnedMoney = 0;
		for(int i = 0;i<movementsModel.size();i++) {
			if(movementsModel.get(i).getType() == TypeOfMovement.INGRESO) {
				earnedMoney += movementsModel.get(i).getAmount();
			}
		}
		
		earnedMoneyText.setText("$ "+String.valueOf(earnedMoney));
		earnedMoneyText.setVisible(true);
		
		
	}
	
	
	
	
	public void setMain(Main main) {
		this.main = main;
	}
	

}
