package gui;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.server.Server;
import javafx.fxml.FXML;

public class BoardController {

	@FXML
    private ImageView territoryTower1;
	@FXML
    private ImageView territoryTower2;
	@FXML
    private ImageView territoryTower3;
	@FXML
    private ImageView territoryTower4;
	@FXML
    private ImageView buildingTower1;
	@FXML
    private ImageView buildingTower2;
	@FXML
    private ImageView buildingTower3;
	@FXML
    private ImageView buildingTower4;
	@FXML
    private ImageView characterTower1;
	@FXML
    private ImageView characterTower2;
	@FXML
    private ImageView characterTower3;
	@FXML
    private ImageView characterTower4;
	@FXML
    private ImageView ventureTower1;
	@FXML
    private ImageView ventureTower2;
	@FXML
    private ImageView ventureTower3;
	@FXML
    private ImageView ventureTower4;
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
		
		Image image = new Image ("coin_1_front.png");
		territoryTower1.setImage(image);
		/*ImageView image = new ImageView(getClass().getResource("plancina3.png").toExternalForm());
		territoryTower1.setImage(image);*/
	};
	
	public void putRelative(){
		
	}
	
	public void quit(){

	}
}
