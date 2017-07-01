package gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
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
	
	public boolean waitClick(){
		if(coin.isPressed()||woodAndStone.isPressed() || faithPoint.isPressed() || militaryPoint.isPressed() ||servant.isPressed() ){
			return true;
		}
		
		else return false;
	}
	
	@FXML
	public void coinPrivilege(ActionEvent event){
		choice= "coin";
		boardController.setBonus(choice);
		boardController.setPrivilege(false);
	}
	
	@FXML
	public void woodAndStonePrivilege(ActionEvent event){
		choice= "woodAndStone";
		boardController.setBonus(choice);
		boardController.setPrivilege(false);
	}
	
	@FXML
	public void militaryPointPrivilege(ActionEvent event){
		choice= "militaryPoint";
		boardController.setBonus(choice);
		boardController.setPrivilege(false);
	}
	
	@FXML
	public void faithPointPrivilege(ActionEvent event){
		choice= "faithPoint";
		boardController.setBonus(choice);
		boardController.setPrivilege(false);
	}
	
	@FXML
	public void servantPrivilege(ActionEvent event){
		choice= "servant";
		boardController.setBonus(choice);
		boardController.setPrivilege(false);
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
