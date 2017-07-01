package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AlternativeCostController {
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
	public void coinAlternative(){
		choice= "coin";
		boardController.setAlternativeCost(choice);
	}
	
	@FXML
	public void woodAndStoneAlternative(){
		choice= "woodAndStone";
		boardController.setAlternativeCost(choice);
	}
	
	@FXML
	public void militaryPointAlternative(){
		choice= "militaryPoint";
		boardController.setAlternativeCost(choice);
	}
	
	@FXML
	public void faithPointAlternative(){
		choice= "faithPoint";
		boardController.setAlternativeCost(choice);
	}
	
	@FXML
	public void servantAlternative(){
		choice= "servant";
		boardController.setAlternativeCost(choice);
	}

	public String getChoice() {
		return choice;
	}

	public void setBoardController(BoardController boardController) {
		this.boardController=boardController;
	}

	public void setAlternativeCost(boolean b) {
		this.boardController.setAlternativeCost(b);
	}
	
	


}
