package gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrivilegeController {
	private String choice;
	@FXML
	private Button coin;
	@FXML
	private Button woodAndStone;
	@FXML
	private Button faithPoint;
	@FXML
	private Button militaryPoint;
	@FXML
	private Button servant;
	private BoardController boardController;
	private Stage stage;
	private String type;

	@FXML
	public void coinPrivilege() {
		choice = "coin";
		switch ("type") {
		case "councilPalace": {
			boardController.putRelativeOnCouncilPalace(choice);
			break;
		}
		case "territory1": {
			boardController.putRelativeOnTerritory1Privilege(choice);
			break;
		}
		case "territory2": {
			boardController.putRelativeOnTerritory2Privilege(choice);
			break;
		}
		case "territory3": {
			boardController.putRelativeOnTerritory3Privilege(choice);
			break;
		}
		case "territory4": {
			boardController.putRelativeOnTerritory4Privilege(choice);
			break;
		}
		case "venture1": {
			boardController.putRelativeOnVenture1Privilege(choice);
			break;
		}
		case "venture2": {
			boardController.putRelativeOnVenture2Privilege(choice);
			break;
		}
		case "venture3": {
			boardController.putRelativeOnVenture3Privilege(choice);
			break;
		}
		case "venture4": {
			boardController.putRelativeOnVenture4Privilege(choice);
			break;
		}
		case "market4":{
			boardController.putRelativeOnMarket4(choice);
			break;
		}
		}

		stage.close();
	}

	@FXML
	public void woodAndStonePrivilege() {
		choice = "woodAndStone";
		switch ("type") {
		case "councilPalace": {
			boardController.putRelativeOnCouncilPalace(choice);
			break;
		}
		case "territory1": {
			boardController.putRelativeOnTerritory1Privilege(choice);
			break;
		}
		case "territory2": {
			boardController.putRelativeOnTerritory2Privilege(choice);
			break;
		}
		case "territory3": {
			boardController.putRelativeOnTerritory3Privilege(choice);
			break;
		}
		case "territory4": {
			boardController.putRelativeOnTerritory4Privilege(choice);
			break;
		}
		case "venture1": {
			boardController.putRelativeOnVenture1Privilege(choice);
			break;
		}
		case "venture2": {
			boardController.putRelativeOnVenture2Privilege(choice);
			break;
		}
		case "venture3": {
			boardController.putRelativeOnVenture3Privilege(choice);
			break;
		}
		case "venture4": {
			boardController.putRelativeOnVenture4Privilege(choice);
			break;
		}
		case "market4":{
			boardController.putRelativeOnMarket4(choice);
			break;
		}
		}

		stage.close();
	}

	@FXML
	public void militaryPointPrivilege() {
		choice = "militaryPoint";
		switch ("type") {
		case "councilPalace": {
			boardController.putRelativeOnCouncilPalace(choice);
			break;
		}
		case "market4":{
			boardController.putRelativeOnMarket4(choice);
			break;
		}
		case "territory1": {
			boardController.putRelativeOnTerritory1Privilege(choice);
			break;
		}
		case "territory2": {
			boardController.putRelativeOnTerritory2Privilege(choice);
			break;
		}
		case "territory3": {
			boardController.putRelativeOnTerritory3Privilege(choice);
			break;
		}
		case "territory4": {
			boardController.putRelativeOnTerritory4Privilege(choice);
			break;
		}
		case "venture1": {
			boardController.putRelativeOnVenture1Privilege(choice);
			break;
		}
		case "venture2": {
			boardController.putRelativeOnVenture2Privilege(choice);
			break;
		}
		case "venture3": {
			boardController.putRelativeOnVenture3Privilege(choice);
			break;
		}
		case "venture4": {
			boardController.putRelativeOnVenture4Privilege(choice);
			break;
		}
		}

		stage.close();
	}

	@FXML
	public void faithPointPrivilege() {
		choice = "faithPoint";
		switch ("type") {
		case "councilPalace": {
			boardController.putRelativeOnCouncilPalace(choice);
			break;
		}
		case "market4":{
			boardController.putRelativeOnMarket4(choice);
			break;
		}
		case "territory1": {
			boardController.putRelativeOnTerritory1Privilege(choice);
			break;
		}
		case "territory2": {
			boardController.putRelativeOnTerritory2Privilege(choice);
			break;
		}
		case "territory3": {
			boardController.putRelativeOnTerritory3Privilege(choice);
			break;
		}
		case "territory4": {
			boardController.putRelativeOnTerritory4Privilege(choice);
			break;
		}
		case "venture1": {
			boardController.putRelativeOnVenture1Privilege(choice);
			break;
		}
		case "venture2": {
			boardController.putRelativeOnVenture2Privilege(choice);
			break;
		}
		case "venture3": {
			boardController.putRelativeOnVenture3Privilege(choice);
			break;
		}
		case "venture4": {
			boardController.putRelativeOnVenture4Privilege(choice);
			break;
		}
		}

		stage.close();
	}

	@FXML
	public void servantPrivilege() {
		choice = "servant";
		switch ("type") {
		case "councilPalace": {
			boardController.putRelativeOnCouncilPalace(choice);
			break;
		}
		case "market4":{
			boardController.putRelativeOnMarket4(choice);
			break;
		}
		case "territory1": {
			boardController.putRelativeOnTerritory1Privilege(choice);
			break;
		}
		case "territory2": {
			boardController.putRelativeOnTerritory2Privilege(choice);
			break;
		}
		case "territory3": {
			boardController.putRelativeOnTerritory3Privilege(choice);
			break;
		}
		case "territory4": {
			boardController.putRelativeOnTerritory4Privilege(choice);
			break;
		}
		case "venture1": {
			boardController.putRelativeOnVenture1Privilege(choice);
			break;
		}
		case "venture2": {
			boardController.putRelativeOnVenture2Privilege(choice);
			break;
		}
		case "venture3": {
			boardController.putRelativeOnVenture3Privilege(choice);
			break;
		}
		case "venture4": {
			boardController.putRelativeOnVenture4Privilege(choice);
			break;
		}
		}

		stage.close();
	}

	public String getChoice() {
		return choice;
	}

	public void setBoardController(BoardController boardController) {
		this.boardController = boardController;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setType(String string) {
		this.type = string;
	}

}
