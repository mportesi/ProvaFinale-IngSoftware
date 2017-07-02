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
	
	
	@FXML
	public void coinPrivilege(){
		choice= "coin";
		boardController.setBonus(choice);
		boardController.setPrivilege(false);
		boardController.putRelativeOnCouncilPalace();
		stage.close();
	}
	
	@FXML
	public void woodAndStonePrivilege(){
		choice= "woodAndStone";
		boardController.setBonus(choice);
		boardController.setPrivilege(false);
		boardController.putRelativeOnCouncilPalace();
		stage.close();
	}
	
	@FXML
	public void militaryPointPrivilege(){
		choice= "militaryPoint";
		boardController.setBonus(choice);
		boardController.setPrivilege(false);
		boardController.putRelativeOnCouncilPalace();
		stage.close();
	}
	
	@FXML
	public void faithPointPrivilege(){
		choice= "faithPoint";
		boardController.setBonus(choice);
		boardController.setPrivilege(false);
		boardController.putRelativeOnCouncilPalace();
		stage.close();
	}
	
	@FXML
	public void servantPrivilege(){
		choice= "servant";
		boardController.setBonus(choice);
		boardController.setPrivilege(false);
		boardController.putRelativeOnCouncilPalace();
		stage.close();
	}

	public String getChoice() {
		return choice;
	}

	public void setBoardController(BoardController boardController) {
		this.boardController=boardController;
	}

	public void setPrivilege(boolean b) {
		this.boardController.setPrivilege(b);
	}

	public void setStage(Stage stage) {
		this.stage=stage;
	}
	
	

}
