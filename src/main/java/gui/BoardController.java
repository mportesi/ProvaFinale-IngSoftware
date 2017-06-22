package gui;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.server.Server;
import javafx.fxml.FXML;

public class BoardController {
	
	private ClientModel client;

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
		
		String string;
		//string = client.getTerritoryTower().getFloor(4).getCard().getName();
		Image image1 = new Image ("ImagesModified/"+"devcards_f_en_c_2"+".png");
		
	/*	string = client.getTerritoryTower().getFloor(3).getCard().getName();
		Image image2 = new Image ("ImagesModified/"+string+".png");
		
		string = client.getTerritoryTower().getFloor(2).getCard().getName();
		Image image3 = new Image ("ImagesModified/"+string+".png");
		
		string = client.getTerritoryTower().getFloor(1).getCard().getName();
		Image image4 = new Image ("ImagesModified/"+string+".png");
		
		string = client.getBuildingTower().getFloor(4).getCard().getName();
		Image image5 = new Image ("ImagesModified/"+string+".png");
		string = client.getBuildingTower().getFloor(3).getCard().getName();
		Image image6 = new Image ("ImagesModified/"+string+".png");
		string= client.getBuildingTower().getFloor(2).getCard().getName();
		Image image7 = new Image ("ImagesModified/"+string+".png");
		string = client.getBuildingTower().getFloor(1).getCard().getName();
		Image image8 = new Image ("ImagesModified/"+string+".png");
		string = client.getVentureTower().getFloor(4).getCard().getName();
		Image image9 = new Image ("ImagesModified/"+string+".png");
		string = client.getVentureTower().getFloor(3).getCard().getName();
		Image image10 = new Image ("ImagesModified/"+string+".png");
		string = client.getVentureTower().getFloor(2).getCard().getName();
		Image image11 = new Image ("ImagesModified/"+string+".png");
		string = client.getVentureTower().getFloor(1).getCard().getName();
		Image image12 = new Image ("ImagesModified/"+string+".png");
		string = client.getCharacterTower().getFloor(4).getCard().getName();
		Image image13 = new Image ("ImagesModified/"+string+".png");
		string = client.getCharacterTower().getFloor(3).getCard().getName();
		Image image14 = new Image ("ImagesModified/"+string+".png");
		string = client.getCharacterTower().getFloor(2).getCard().getName();
		Image image15 = new Image ("ImagesModified/"+string+".png");
		string = client.getCharacterTower().getFloor(1).getCard().getName();
		Image image16 = new Image ("ImagesModified/"+string+".png");
		*/
		
		
		
		buildingTower1.setImage(image1);
	/*	territoryTower3.setImage(image2);
		territoryTower2.setImage(image3);
		territoryTower1.setImage(image4);
		buildingTower4.setImage(image5);
		buildingTower3.setImage(image6);
		buildingTower2.setImage(image7);
		buildingTower1.setImage(image8);
		ventureTower4.setImage(image9);
		ventureTower3.setImage(image10);
		ventureTower2.setImage(image11);
		ventureTower1.setImage(image12);
		characterTower4.setImage(image13);
		characterTower3.setImage(image14);
		characterTower2.setImage(image15);
		characterTower1.setImage(image16);*/
		
		
		/*ImageView image = new ImageView(getClass().getResource("plancina3.png").toExternalForm());
		territoryTower1.setImage(image);*/
	};
	
	public void putRelative(){
		
	}
	
	public void quit(){

	}
}
