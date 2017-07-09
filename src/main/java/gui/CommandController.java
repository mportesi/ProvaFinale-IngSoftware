package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author Chiara
 * This class represents the controller of the stage "command".
 *
 */

public class CommandController {
	private BoardController boardController;
	private Stage stage;
	private String type;
	
	@FXML
	private Text ranking;
	
	public void set(String string){
	ranking.setText(string);
	}
	
	public void setBoardController(BoardController boardController) {
		this.boardController = boardController;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
