package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
	
	@FXML
	public void coinPrivilege(){
		choice= "coin";
		boardController.setBonus(choice);
	}
	
	@FXML
	public void woodAndStonePrivilege(){
		choice= "woodAndStone";
		boardController.setBonus(choice);
	}
	
	@FXML
	public void militaryPointPrivilege(){
		choice= "militaryPoint";
		boardController.setBonus(choice);
	}
	
	@FXML
	public void faithPointPrivilege(){
		choice= "faithPoint";
		boardController.setBonus(choice);
	}
	
	@FXML
	public void servantPrivilege(){
		choice= "servant";
		boardController.setBonus(choice);
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
	
	

}
