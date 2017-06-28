package gui;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import org.evosuite.shaded.antlr.debug.Event;
import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.actions.PutRelativeOnTower;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.server.Server;
import javafx.fxml.FXML;

public class BoardController {
	
	private ClientModel client;
	private Relative relative;
	private Player player;
	
	public BoardController(){
		
	}
	
	
	
	@FXML
    private Button white;
	@FXML
    private Button neutral;
	@FXML
    private Button orange;
	@FXML
    private Button black;
	
	

	@FXML
    private ImageView territory1;
	@FXML
    private ImageView territory2;
	@FXML
    private ImageView territory3;
	@FXML
    private ImageView territory4;
	@FXML
    private ImageView territory5;
	@FXML
    private ImageView territory6;
	
	@FXML
    private ImageView building1;
	@FXML
    private ImageView building2;
	@FXML
    private ImageView building3;
	@FXML
    private ImageView building4;
	@FXML
    private ImageView building5;
	@FXML
    private ImageView building6;
	
	@FXML
    private ImageView character1;
	@FXML
    private ImageView character2;
	@FXML
    private ImageView character3;
	@FXML
    private ImageView character4;
	@FXML
    private ImageView character5;
	@FXML
    private ImageView character6;
	
	@FXML
    private ImageView venture1;
	@FXML
    private ImageView venture2;
	@FXML
    private ImageView venture3;
	@FXML
    private ImageView venture4;
	@FXML
    private ImageView venture5;
	@FXML
    private ImageView venture6;
	
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
	
	


	@FXML
	public void chooseWhiteRelative(){
		relative = client.getPlayer().getWhiteRelative();
		
	}
	

	@FXML
	public void chooseOrangeRelative(){
		relative = client.getPlayer().getOrangeRelative();
		
		
	}
	

	@FXML
	public void chooseBlackRelative(){
		relative = client.getPlayer().getBlackRelative();
		
		
	}
	

	@FXML
	public void chooseNeutralRelative(){
		relative = client.getPlayer().getNeutralRelative();
		
	}
	
	// ????? per tutte e 4 la torri??????
	@FXML
	public void putRelativeOnTerritory1(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getTerritoryTower(), 1, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnTerritory2(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getTerritoryTower(), 2, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnTerritory3(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getTerritoryTower(), 3, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnTerritory4(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getTerritoryTower(), 4, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnBuilding1(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getBuildingTower(), 1, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnBuilding2(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getBuildingTower(), 2, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnBuilding3(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getBuildingTower(), 3, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnBuilding4(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getBuildingTower(), 4, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnCharacter1(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getCharacterTower(), 1, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnCharacter2(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getCharacterTower(), 2, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnCharacter3(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getCharacterTower(), 3, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnCharacter4(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getCharacterTower(), 4, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnVenture1(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getVentureTower(), 1, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnVenture2(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getVentureTower(), 2, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnVenture3(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getVentureTower(), 3, relative, client.getMatch());	
	}
	@FXML
	public void putRelativeOnVenture4(){
		PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(), client.getVentureTower(), 4, relative, client.getMatch());	
	}
	
	@FXML
	public void initializeBoard(){
		
		String string;
		string = client.getTerritoryTower().getFloor(3).getCard().getName();
		System.out.println(string);
		Image image1 = new Image ("Cards/"+string+".png");
		
		string = client.getTerritoryTower().getFloor(2).getCard().getName();
		Image image2 = new Image ("Cards/"+string+".png");
		
		string = client.getTerritoryTower().getFloor(1).getCard().getName();
		Image image3 = new Image ("Cards/"+string+".png");
		
		string = client.getTerritoryTower().getFloor(0).getCard().getName();
		Image image4 = new Image ("Cards/"+string+".png");
		
		string = client.getBuildingTower().getFloor(3).getCard().getName();
		Image image5 = new Image ("Cards/"+string+".png");
		string = client.getBuildingTower().getFloor(2).getCard().getName();
		Image image6 = new Image ("Cards/"+string+".png");
		string= client.getBuildingTower().getFloor(1).getCard().getName();
		Image image7 = new Image ("Cards/"+string+".png");
		string = client.getBuildingTower().getFloor(0).getCard().getName();
		Image image8 = new Image ("Cards/"+string+".png");
		string = client.getVentureTower().getFloor(3).getCard().getName();
		Image image9 = new Image ("Cards/"+string+".png");
		string = client.getVentureTower().getFloor(2).getCard().getName();
		Image image10 = new Image ("Cards/"+string+".png");
		string = client.getVentureTower().getFloor(1).getCard().getName();
		Image image11 = new Image ("Cards/"+string+".png");
		string = client.getVentureTower().getFloor(0).getCard().getName();
		Image image12 = new Image ("Cards/"+string+".png");
		string = client.getCharacterTower().getFloor(3).getCard().getName();
		Image image13 = new Image ("Cards/"+string+".png");
		string = client.getCharacterTower().getFloor(2).getCard().getName();
		Image image14 = new Image ("Cards/"+string+".png");
		string = client.getCharacterTower().getFloor(1).getCard().getName();
		Image image15 = new Image ("Cards/"+string+".png");
		string = client.getCharacterTower().getFloor(0).getCard().getName();
		Image image16 = new Image ("Cards/"+string+".png");
		
		
		
		
		buildingTower1.setImage(image1);
		
		
		territoryTower3.setImage(image2);
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
		characterTower1.setImage(image16);
		
		
		/*ImageView image = new ImageView(getClass().getResource("plancina3.png").toExternalForm());
		territoryTower1.setImage(image);*/
	};
	
	
	public void quit(){

	}


	public void setClient(ClientModel clientModel) {
		client=clientModel;
		
	}
}
