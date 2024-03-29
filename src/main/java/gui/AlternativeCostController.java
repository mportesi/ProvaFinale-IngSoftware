package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * @author Chiara
 * This class represents the controller of the stage "alternative cost".
 *
 */

public class AlternativeCostController {
	@FXML
	private Button otherCost;
	@FXML
	private Button militaryCost;
	
	private BoardController boardController;
	private Stage stage;
	private String type;
	
	@FXML
	public void otherCostAlternative(){
		switch ("type") {
	case "venture1": {
		boardController.putRelativeOnVenture1Alternative(false);
		break;
	}
	case "venture2": {
		boardController.putRelativeOnVenture2Alternative(false);
		break;
	}
	case "venture3": {
		boardController.putRelativeOnVenture3Alternative(false);
		break;
	}
	case "venture4": {
		boardController.putRelativeOnVenture4Alternative(false);
		break;
	}
	}
		stage.close();
	}
	
	
	@FXML
	public void militaryCostAlternative(){
		switch ("type") {
	case "venture1": {
		boardController.putRelativeOnVenture1Alternative(true);
		break;
	}
	case "venture2": {
		boardController.putRelativeOnVenture2Alternative(true);
		break;
	}
	case "venture3": {
		boardController.putRelativeOnVenture3Alternative(true);
		break;
	}
	case "venture4": {
		boardController.putRelativeOnVenture4Alternative(true);
		break;
	}
	}
		stage.close();
	}
	
	
	public void setBoardController(BoardController boardController) {
		this.boardController=boardController;
	}


	public void setStage(Stage stage) {
		this.stage=stage;
	}

	
	public void setType(String string) {
		this.type = string;
	}


}
