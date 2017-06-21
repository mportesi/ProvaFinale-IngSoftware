package gui;


import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.server.Server;
import javafx.fxml.FXML;

public class BoardController {

	@FXML
    private Label territoryTower1;
	@FXML
    private Label territoryTower2;
	@FXML
    private Label territoryTower3;
	@FXML
    private Label territoryTower4;
	@FXML
    private Label buildingTower1;
	@FXML
    private Label buildingTower2;
	@FXML
    private Label buildingTower3;
	@FXML
    private Label buildingTower4;
	@FXML
    private Label characterTower1;
	@FXML
    private Label characterTower2;
	@FXML
    private Label characterTower3;
	@FXML
    private Label characterTower4;
	@FXML
    private Label ventureTower1;
	@FXML
    private Label ventureTower2;
	@FXML
    private Label ventureTower3;
	@FXML
    private Label ventureTower4;
	@FXML
	private Label councilPalace;
	@FXML
	private Label market1;
	@FXML
	private Label market2;
	@FXML
	private Label market3;
	@FXML
	private Label market4;
	@FXML
	private Label harvestLeft;
	@FXML
	private Label harvestRight;
	@FXML
	private Label productionLeft;
	@FXML
	private Label productionRight;
	@FXML
	private Label blackDice;
	@FXML
	private Label whiteDice;
	@FXML
	private Label orangeDice;
	@FXML
	private Button quit;
	
	
	private Gui gui;
	
	public void initializeBoard(){
		
	};
	
	public void putRelative(){
		
	}
	
	public void quit(){
		System.out.println("CIAO");
	}
}
