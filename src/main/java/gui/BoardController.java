package gui;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.evosuite.shaded.antlr.debug.Event;
import org.json.simple.parser.ParseException;

import com.sun.javafx.tk.Toolkit;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.actions.PutRelativeOnCouncilPalace;
import it.polimi.ingsw.actions.PutRelativeOnHarvestArea;
import it.polimi.ingsw.actions.PutRelativeOnMarket;
import it.polimi.ingsw.actions.PutRelativeOnMarketPrivilege;
import it.polimi.ingsw.actions.PutRelativeOnProductionArea;
import it.polimi.ingsw.actions.PutRelativeOnTower;
import it.polimi.ingsw.actions.PutRelativeOnTowerAltCost;
import it.polimi.ingsw.actions.PutRelativeOnTowerPrivilege;
import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.cards.CharacterCard;
import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.json.JsonMilitaryPointForTerritory;
import it.polimi.ingsw.server.Server;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;

public class BoardController {

	private ClientModel client;
	private Relative relative;
	private Player player;
	private WelcomeController welcomeController;
	private Gui gui;
	private ArrayList <Player> currentTurnOrder;
	private ServerRMIConnectionViewRemote serverStub;
	private Image relativeImage;
	private ArrayList<ImageView> councilPalace;
	private ArrayList<ImageView> harvestRight;
	private ArrayList<ImageView> productionRight;
	private int i = 0;
	private int j = 0;
	private int k = 0;
	private ArrayList<ImageView> territoryCard;
	private ArrayList<ImageView> buildingCard;
	private ArrayList<ImageView> ventureCard;
	private ArrayList<ImageView> characterCard;
	private int territory = 0;
	private int venture = 0;
	private int character = 0;
	private int building = 0;
	private Image territoryImage1;
	private Image territoryImage2;
	private Image territoryImage3;
	private Image territoryImage4;
	private Image buildingImage1;
	private Image buildingImage2;
	private Image buildingImage3;
	private Image buildingImage4;
	private Image characterImage1;
	private Image characterImage2;
	private Image characterImage3;
	private Image characterImage4;
	private Image ventureImage1;
	private Image ventureImage2;
	private Image ventureImage3;
	private Image ventureImage4;
	@FXML
	private TextField coin;
	@FXML
	private TextField wood;
	@FXML
	private TextField stone;
	@FXML
	private TextField servant;

	@FXML
	private ImageView councilPalace1;

	@FXML
	private ImageView councilPalace2;

	@FXML
	private ImageView councilPalace3;

	@FXML
	private ImageView councilPalace4;

	@FXML
	private ImageView councilPalace5;

	@FXML
	private Button councilPalaceButton;

	@FXML
	private ImageView productionRight1;

	@FXML
	private ImageView productionRight2;

	@FXML
	private ImageView productionRight3;

	@FXML
	private ImageView productionRight4;

	@FXML
	private ImageView productionRight5;
	@FXML
	private ImageView harvestRight1;

	@FXML
	private ImageView harvestRight2;

	@FXML
	private ImageView harvestRight3;

	@FXML
	private ImageView harvestRight4;

	@FXML
	private ImageView harvestRight5;

	@FXML
	private ImageView councilPalace6;

	@FXML
	private ImageView councilPalace7;

	@FXML
	private ImageView councilPalace8;

	@FXML
	private ImageView councilPalace9;

	@FXML
	private ImageView councilPalace10;

	@FXML
	private ImageView councilPalace11;

	@FXML
	private ImageView councilPalace12;

	@FXML
	private Label nameFxml;
	@FXML
	private Label currentTurnOrderFxml;
	@FXML
	private Label colorFxml;
	@FXML
	private Label currentPlayerFxml;
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
	private ImageView market1;
	@FXML
	private ImageView market2;
	@FXML
	private ImageView market3;
	@FXML
	private ImageView market4;
	@FXML
	private ImageView harvestLeft;

	@FXML
	private ImageView productionLeft;

	
	@FXML
	private TextField valueWithServant;
	@FXML
	private TextField blackDice;
	@FXML
	private TextField whiteDice;
	@FXML
	private TextField orangeDice;
	@FXML
	private Button quit;
	@FXML
	private Button ok;

	@FXML
	public void chooseWhiteRelative() {
		relative = client.getPlayer().getWhiteRelative();
		relativeImage = new Image("Images/" + client.getPlayer().getColor() + "RelativeWhite1.png");
		/*try {
			openServant(relative);
		} catch (Exception e) {
			e.printStackTrace();
		} */

	}

	/*@FXML
	public void openServant(Relative relative){
		try{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HowManyServants.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.show();
		ServantController servantController = fxmlLoader.getController();
		servantController.setBoardController(this);
		servantController.setStage(stage);
		servantController.setRelative(relative);
		servantController.setClientModel(client);
		servantController.setServerRMIConnectionViewRemote(serverStub);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setValueWithServant(Relative relative, String value){
		
		valueWithServant.setText(relative.getValue() + value);
	}
*/
	@FXML
	public void setValueWithServant(){
		
		//
		
		String valueNew = valueWithServant.getText();
		int value = Integer.parseInt(valueNew);
		System.out.println(value);
		System.out.println(this.relative);
		System.out.println(this.client);
		relative.setValueServant(value);
		System.out.println(relative.getValue());

	}
	@FXML
	public void chooseOrangeRelative() {
		this.relative = client.getPlayer().getOrangeRelative();
		relativeImage = new Image("Images/" + client.getPlayer().getColor() + "RelativeOrange1.png");
		/*try {
			openServant(relative);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
	}

	@FXML
	public void chooseBlackRelative() {
		relative = client.getPlayer().getBlackRelative();
		System.out.println("The relative: "+ relative);
		relativeImage = new Image("Images/" + client.getPlayer().getColor() + "RelativeBlack1.png");
		/*try {
			openServant(relative);
		} catch (Exception e) {
			e.printStackTrace();
		} */

	}

	@FXML
	public void chooseNeutralRelative() {
		relative = client.getPlayer().getNeutralRelative();
		
		relativeImage = new Image("Images/" + client.getPlayer().getColor() + "RelativeNeutral1.png");
		/*try {
			openServant(relative);
		} catch (Exception e) {
			e.printStackTrace();
		} */

	}

	@FXML
	public void putRelativeOnTerritory1() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
					client.getTerritoryTower(), 0, relative, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			territoryTower1.setImage(relativeImage);
			setPlayer();
			territoryCard.get(territory).setImage(territoryImage1);
			territory++;
			this.relative = null;
			}
			else {
				openMessage("NotYorTurn.fxml");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnTerritory2() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
					client.getTerritoryTower(), 1, relative, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			territoryTower2.setImage(relativeImage);
			setPlayer();
			territoryCard.get(territory).setImage(territoryImage2);
			territory++;
			this.relative = null;
			}
			else{
				openMessage("NotYorTurn.fxml");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@FXML
	public void putRelativeOnTerritory3() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
					client.getTerritoryTower(), 2, relative, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			territoryTower3.setImage(relativeImage);
			setPlayer();
			territoryCard.get(territory).setImage(territoryImage3);
			territory++;
			this.relative = null;
			}
			else{
				openMessage("NotYorTurn.fxml");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnTerritory4() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
					client.getTerritoryTower(), 3, relative, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			territoryTower4.setImage(relativeImage);
			setPlayer();
			territoryCard.get(territory).setImage(territoryImage4);
			territory++;
			this.relative = null;
			}
			else{
				openMessage("NotYorTurn.fxml");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void putRelativeOnTerritory1Privilege(String bonus) {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(client.getPlayer(),
					client.getTerritoryTower(), 0, relative, bonus, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			territoryTower1.setImage(relativeImage);
			setPlayer();
			territoryCard.get(territory).setImage(territoryImage1);
			territory++;
			this.relative = null;
			}
			else{
				openMessage("NotYorTurn.fxml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void putRelativeOnTerritory2Privilege(String bonus) {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(client.getPlayer(),
					client.getTerritoryTower(), 1, relative, bonus, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			territoryTower2.setImage(relativeImage);
			setPlayer();
			territoryCard.get(territory).setImage(territoryImage2);
			territory++;
			this.relative = null;
			}
			else{
				openMessage("NotYorTurn.fxml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void putRelativeOnTerritory3Privilege(String bonus) {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(client.getPlayer(),
					client.getTerritoryTower(), 2, relative, bonus, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			territoryTower3.setImage(relativeImage);
			setPlayer();
			territoryCard.get(territory).setImage(territoryImage3);
			territory++;
			this.relative = null;
			}
		
		else{
			openMessage("NotYorTurn.fxml");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void putRelativeOnTerritory4Privilege(String bonus) {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(client.getPlayer(),
					client.getTerritoryTower(), 3, relative, bonus, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			territoryTower4.setImage(relativeImage);
			setPlayer();
			territoryCard.get(territory).setImage(territoryImage4);
			territory++;
			this.relative = null;}

			else{
				openMessage("NotYorTurn.fxml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnBuilding1() {
		boolean isPresentAnyone = false;
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (client.getBuildingTower().getFloor(0).isFree()) {
					if (relative.getValue() >= client.getBuildingTower().getFloor(0).getCost()) {
						if (client.getBuildingTower().isPresent(player) == false) {
							if (client.getBuildingTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getBuildingTower(), 0, isPresentAnyone)) {

								PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
										client.getBuildingTower(), 0, relative, client.getMatch());
								serverStub.notifyObserver(putRelativeOnTower);
								buildingTower1.setImage(relativeImage);
								setPlayer();
								buildingCard.get(building).setImage(buildingImage1);
								building++;
								this.relative = null;
							}

							else {
								openMessage("NotEnoughResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {

				openMessage("ChooseTheRelativeMessage.fxml");

			}
			
		}
			else{
				openMessage("NotYorTurn.fxml");
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnBuilding2() {
		boolean isPresentAnyone = false;
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (client.getBuildingTower().getFloor(1).isFree()) {
					if (relative.getValue() >= client.getBuildingTower().getFloor(1).getCost()) {
						if (client.getBuildingTower().isPresent(player) == false) {
							if (client.getBuildingTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getBuildingTower(), 1, isPresentAnyone)) {

								PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
										client.getBuildingTower(), 1, relative, client.getMatch());
								serverStub.notifyObserver(putRelativeOnTower);
								buildingTower2.setImage(relativeImage);
								setPlayer();
								buildingCard.get(building).setImage(buildingImage2);
								building++;
								this.relative = null;
							}

							else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {

				openMessage("ChooseTheRelativeMessage.fxml");

			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnBuilding3() {
		boolean isPresentAnyone = false;
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (client.getBuildingTower().getFloor(2).isFree()) {
					if (relative.getValue() >= client.getBuildingTower().getFloor(2).getCost()) {
						if (client.getBuildingTower().isPresent(player) == false) {
							if (client.getBuildingTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getBuildingTower(), 2, isPresentAnyone)) {

								PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
										client.getBuildingTower(), 2, relative, client.getMatch());
								serverStub.notifyObserver(putRelativeOnTower);
								buildingTower3.setImage(relativeImage);
								setPlayer();
								buildingCard.get(building).setImage(buildingImage3);
								building++;
								this.relative = null;
							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {

				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnBuilding4() {
		boolean isPresentAnyone = false;
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (client.getBuildingTower().getFloor(3).isFree()) {
					if (relative.getValue() >= client.getBuildingTower().getFloor(3).getCost()) {
						if (client.getBuildingTower().isPresent(player) == false) {
							if (client.getBuildingTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getBuildingTower(), 3, isPresentAnyone)) {

								PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
										client.getBuildingTower(), 3, relative, client.getMatch());
								serverStub.notifyObserver(putRelativeOnTower);
								buildingTower4.setImage(relativeImage);
								setPlayer();
								buildingCard.get(building).setImage(buildingImage4);
								building++;
								this.relative = null;
							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {

				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnCharacter1() {
		boolean isPresentAnyone = false;
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (client.getCharacterTower().getFloor(0).isFree()) {
					if (relative.getValue() >= client.getCharacterTower().getFloor(0).getCost()) {
						if (client.getCharacterTower().isPresent(player) == false) {
							if (client.getCharacterTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getCharacterTower(), 0, isPresentAnyone)) {
								if (client.getCharacterTower().getFloor(0).getCard().getGetCard()) {
									// TODO
									// PutRelativeOnTowerDouble
									// putRelativeOnTower =
									// new PutRelativeOnTowerDouble(
									// client.getPlayer(),
									// client.getCharacterTower(), 1, relative,
									// bonus,
									// client.getMatch());
									// serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getCharacterTower(), 0, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								characterTower1.setImage(relativeImage);
								setPlayer();
								characterCard.get(character).setImage(characterImage1);
								character++;
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {

				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnCharacter2() {
		boolean isPresentAnyone = false;
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (client.getCharacterTower().getFloor(1).isFree()) {
					if (relative.getValue() >= client.getCharacterTower().getFloor(1).getCost()) {
						if (client.getCharacterTower().isPresent(player) == false) {
							if (client.getCharacterTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getCharacterTower(), 1, isPresentAnyone)) {
								if (client.getCharacterTower().getFloor(1).getCard().getGetCard()) {
									// TODO
									// PutRelativeOnTowerDouble
									// putRelativeOnTower =
									// new PutRelativeOnTowerDouble(
									// client.getPlayer(),
									// client.getCharacterTower(), 1, relative,
									// bonus,
									// client.getMatch());
									// serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getCharacterTower(), 1, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								characterTower2.setImage(relativeImage);
								setPlayer();
								characterCard.get(character).setImage(characterImage2);
								character++;
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {

				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnCharacter3() {
		boolean isPresentAnyone = false;
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (client.getCharacterTower().getFloor(2).isFree()) {
					if (relative.getValue() >= client.getCharacterTower().getFloor(2).getCost()) {
						if (client.getCharacterTower().isPresent(player) == false) {
							if (client.getCharacterTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getCharacterTower(), 2, isPresentAnyone)) {
								if (client.getCharacterTower().getFloor(2).getCard().getGetCard()) {
									// TODO
									// PutRelativeOnTowerDouble
									// putRelativeOnTower =
									// new PutRelativeOnTowerDouble(
									// client.getPlayer(),
									// client.getCharacterTower(), 1, relative,
									// bonus,
									// client.getMatch());
									// serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getCharacterTower(), 2, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								characterTower3.setImage(relativeImage);
								setPlayer();
								characterCard.get(character).setImage(characterImage3);
								character++;
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {

				openMessage("ChooseTheRelativeMessage.fxml");

			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnCharacter4() {
		boolean isPresentAnyone = false;
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (client.getCharacterTower().getFloor(3).isFree()) {
					if (relative.getValue() >= client.getCharacterTower().getFloor(3).getCost()) {
						if (client.getCharacterTower().isPresent(player) == false) {
							if (client.getCharacterTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getCharacterTower(), 3, isPresentAnyone)) {
								if (client.getCharacterTower().getFloor(3).getCard().getGetCard()) {
									// TODO
									// PutRelativeOnTowerDouble
									// putRelativeOnTower =
									// new PutRelativeOnTowerDouble(
									// client.getPlayer(),
									// client.getCharacterTower(), 1, relative,
									// bonus,
									// client.getMatch());
									// serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getCharacterTower(), 3, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								characterTower1.setImage(relativeImage);
								setPlayer();
								characterCard.get(character).setImage(characterImage4);
								character++;
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {

				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnVenture1() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
					client.getVentureTower(), 0, relative, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
		ventureTower1.setImage(relativeImage);
		setPlayer();
		ventureCard.get(venture).setImage(ventureImage1);
		venture++;
		this.relative = null;
		} 
		
		else{
			openMessage("NotYorTurn.fxml");
		}
	}
	catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnVenture2() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
					client.getVentureTower(), 1, relative, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			ventureTower2.setImage(relativeImage);
			setPlayer();
			ventureCard.get(venture).setImage(ventureImage2);
			venture++;
			this.relative = null;
		} 

			else{
				openMessage("NotYorTurn.fxml");
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnVenture3() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
					client.getVentureTower(), 2, relative, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			ventureTower3.setImage(relativeImage);
			setPlayer();
			ventureCard.get(venture).setImage(ventureImage3);
			venture++;
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnVenture4() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
					client.getVentureTower(), 3, relative, client.getMatch());
			serverStub.notifyObserver(putRelativeOnTower);
			ventureTower4.setImage(relativeImage);
			setPlayer();
			ventureCard.get(venture).setImage(ventureImage4);
			venture++;
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void putRelativeOnVenture1Privilege(String bonus) {
		try{
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
		PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
				client.getPlayer(), client.getVentureTower(), 0, relative, bonus,
				client.getMatch());
		serverStub.notifyObserver(putRelativeOnTower);
		ventureTower1.setImage(relativeImage);
		setPlayer();
		ventureCard.get(venture).setImage(ventureImage1);
		venture++;}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		
		catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public void putRelativeOnVenture2Privilege(String bonus) {
		try{
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
		PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
				client.getPlayer(), client.getVentureTower(), 1, relative, bonus,
				client.getMatch());
		serverStub.notifyObserver(putRelativeOnTower);
		ventureTower2.setImage(relativeImage);
		setPlayer();
		ventureCard.get(venture).setImage(ventureImage2);
		venture++;}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public void putRelativeOnVenture3Privilege(String bonus) {
		try{
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
		PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
				client.getPlayer(), client.getVentureTower(), 2, relative, bonus,
				client.getMatch());
		serverStub.notifyObserver(putRelativeOnTower);
		ventureTower3.setImage(relativeImage);
		setPlayer();
		ventureCard.get(venture).setImage(ventureImage3);
		venture++;}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public void putRelativeOnVenture4Privilege(String bonus) {
		try{
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
		PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
				client.getPlayer(), client.getVentureTower(), 3, relative, bonus,
				client.getMatch());
		serverStub.notifyObserver(putRelativeOnTower);
		ventureTower4.setImage(relativeImage);
		setPlayer();
		ventureCard.get(venture).setImage(ventureImage4);
		venture++;}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public void putRelativeOnVenture1Alternative(boolean alternativeCost) {
		try{
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
		PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
				client.getPlayer(), client.getVentureTower(), 0, relative, alternativeCost,
				client.getMatch());
		serverStub.notifyObserver(putRelativeOnTower);
		ventureTower1.setImage(relativeImage);
		setPlayer();
		ventureCard.get(venture).setImage(ventureImage1);
		venture++;}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void putRelativeOnVenture2Alternative(boolean alternativeCost) {
		try{
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
		PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
				client.getPlayer(), client.getVentureTower(), 1, relative, alternativeCost,
				client.getMatch());
		serverStub.notifyObserver(putRelativeOnTower);
		ventureTower2.setImage(relativeImage);
		setPlayer();
		ventureCard.get(venture).setImage(ventureImage2);
		venture++;}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void putRelativeOnVenture3Alternative(boolean alternativeCost) {
		try{
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
		PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
				client.getPlayer(), client.getVentureTower(), 2, relative, alternativeCost,
				client.getMatch());
		serverStub.notifyObserver(putRelativeOnTower);
		ventureTower3.setImage(relativeImage);
		setPlayer();
		ventureCard.get(venture).setImage(ventureImage3);
		venture++;}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void putRelativeOnVenture4Alternative(boolean alternativeCost) {
		try{
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
		PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
				client.getPlayer(), client.getVentureTower(), 3, relative, alternativeCost,
				client.getMatch());
		serverStub.notifyObserver(putRelativeOnTower);
		ventureTower4.setImage(relativeImage);
		setPlayer();
		ventureCard.get(venture).setImage(ventureImage4);
		venture++;}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void putRelativeOnCouncilPalace(String bonus) {
		try{
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
						PutRelativeOnCouncilPalace putRelativeOnCouncilPalace = new PutRelativeOnCouncilPalace(
								client.getPlayer(), relative, client.getBoard().getCouncilPalace(), bonus,
								client.getMatch());
						serverStub.notifyObserver(putRelativeOnCouncilPalace);
						councilPalace.get(i).setImage(relativeImage);
						System.out.println("faccio put council");
						setPlayer();
						i++;

		
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnMarket1() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (relative.getValue() >= client.getMarket(0).getCost()) {
					PutRelativeOnMarket putRelativeOnMarket = new PutRelativeOnMarket(client.getPlayer(), relative,
							client.getMarket(0), client.getMatch());
					serverStub.notifyObserver(putRelativeOnMarket);
					market1.setImage(relativeImage);
				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative = null;
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnMarket2() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (relative.getValue() >= client.getMarket(1).getCost()) {
					PutRelativeOnMarket putRelativeOnMarket = new PutRelativeOnMarket(client.getPlayer(), relative,
							client.getMarket(1), client.getMatch());
					serverStub.notifyObserver(putRelativeOnMarket);
					market2.setImage(relativeImage);
					setPlayer();

				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative = null;
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnMarket3() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (relative.getValue() >= client.getMarket(2).getCost()) {
					PutRelativeOnMarket putRelativeOnMarket = new PutRelativeOnMarket(client.getPlayer(), relative,
							client.getMarket(2), client.getMatch());
					serverStub.notifyObserver(putRelativeOnMarket);
					market3.setImage(relativeImage);
				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative = null;
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} else{
			openMessage("NotYorTurn.fxml");
		}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void putRelativeOnMarket4(String bonus) {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
					PutRelativeOnMarketPrivilege putRelativeOnMarket = new PutRelativeOnMarketPrivilege(
							client.getPlayer(), relative, client.getMarket(3), bonus, client.getMatch());
					serverStub.notifyObserver(putRelativeOnMarket);
					market4.setImage(relativeImage);
				
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnHarvestLeft() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (relative.getValue() >= client.getBoard().getHarvestArea().getValueOfLeftArea()) {
					if (client.getBoard().getHarvestArea().getLeftRelative() == null) {
						PutRelativeOnHarvestArea putRelativeOnHarvestArea = new PutRelativeOnHarvestArea(
								client.getPlayer(), relative, client.getBoard().getHarvestArea(), "left",
								client.getMatch());
						serverStub.notifyObserver(putRelativeOnHarvestArea);
						harvestLeft.setImage(relativeImage);

					} else {
						openMessage("SpaceOccupiedMessage.fxml");

					}
				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative = null;
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} 
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnHarvestRight() {
		if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
		if (relative != null) {
			PutRelativeOnHarvestArea putRelativeOnHarvestArea = new PutRelativeOnHarvestArea(client.getPlayer(),
					relative, client.getBoard().getHarvestArea(), "right", client.getMatch());
			harvestRight.get(j).setImage(relativeImage);
			j++;
			try {
				serverStub.notifyObserver(putRelativeOnHarvestArea);
			} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				openMessage("ChooseTheRelativeMessage.fxml");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		else{
			openMessage("NotYorTurn.fxml");
		}}

	@FXML
	public void putRelativeOnProductionLeft() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (relative.getValue() >= client.getBoard().getProductionArea().getValueOfLeftArea()) {
					if (client.getBoard().getProductionArea().getLeftRelative() == null) {
						PutRelativeOnProductionArea putRelativeOnProductionArea = new PutRelativeOnProductionArea(
								client.getPlayer(), relative, client.getBoard().getHarvestArea(), "left",
								client.getMatch());
						serverStub.notifyObserver(putRelativeOnProductionArea);
						productionLeft.setImage(relativeImage);
					} else {
						openMessage("SpaceOccupiedMessage.fxml");

					}
				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative = null;
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");

			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnProductionRight() {
		if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
		if (relative != null) {
			PutRelativeOnProductionArea putRelativeOnProductionArea = new PutRelativeOnProductionArea(
					client.getPlayer(), relative, client.getBoard().getProductionArea(), "right", client.getMatch());
			productionRight.get(k).setImage(relativeImage);
			k++;
			try {
				serverStub.notifyObserver(putRelativeOnProductionArea);
			} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				openMessage("ChooseTheRelativeMessage.fxml");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

		else{
			openMessage("NotYorTurn.fxml");
		}}

	@FXML
	public void openPrivilegeCouncil() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (relative.getValue() >= 1) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrivilegeCouncil.fxml"));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root1));
					stage.show();
					PrivilegeController privilegeController = fxmlLoader.getController();
					privilegeController.setBoardController(this);
					privilegeController.setStage(stage);
					privilegeController.setType("councilPalace");
				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative = null;
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");
			}

		} 
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void openPrivilegeCouncilForMarket4(){
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			if (relative != null) {
				if (relative.getValue() >= client.getMarket(3).getCost()) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrivilegeCouncil.fxml"));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root1));
					stage.show();
					PrivilegeController privilegeController = fxmlLoader.getController();
					privilegeController.setBoardController(this);
					privilegeController.setStage(stage);
					privilegeController.setType("market4");
				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative = null;
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} else{
			openMessage("NotYorTurn.fxml");
		}}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void openPrivilegeCouncilForTerritory1() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			boolean isPresentAnyone = false;
			if (relative != null) {
				if (client.getTerritoryTower().getFloor(0).isFree()) {
					if (relative.getValue() >= client.getTerritoryTower().getFloor(0).getCost()) {
						if (client.getTerritoryTower().isPresent(player) == false) {
							if (client.getTerritoryTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getTerritoryTower(), 0, isPresentAnyone)) {
								if (client.getTerritoryTower().getFloor(0).getCard().getGainPrivilegeCouncil()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("PrivilegeCouncil.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									PrivilegeController privilegeController = fxmlLoader.getController();
									privilegeController.setBoardController(this);
									privilegeController.setStage(stage);
									privilegeController.setType("territory1");
								} else {
									putRelativeOnTerritory1();
								}
							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");
			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (

		Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	public void openPrivilegeCouncilForTerritory2() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			boolean isPresentAnyone = false;
			if (relative != null) {
				if (client.getTerritoryTower().getFloor(1).isFree()) {
					if (relative.getValue() >= client.getTerritoryTower().getFloor(1).getCost()) {
						if (client.getTerritoryTower().isPresent(player) == false) {
							if (client.getTerritoryTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getTerritoryTower(), 1, isPresentAnyone)) {
								if (client.getTerritoryTower().getFloor(1).getCard().getGainPrivilegeCouncil()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("PrivilegeCouncil.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									PrivilegeController privilegeController = fxmlLoader.getController();
									privilegeController.setBoardController(this);
									privilegeController.setStage(stage);
									privilegeController.setType("territory2");
								} else {
									putRelativeOnTerritory2();
								}
							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");
			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}}

		catch (

		Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void openPrivilegeCouncilForTerritory3() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			boolean isPresentAnyone = false;
			if (relative != null) {
				if (client.getTerritoryTower().getFloor(2).isFree()) {
					if (relative.getValue() >= client.getTerritoryTower().getFloor(2).getCost()) {
						if (client.getTerritoryTower().isPresent(player) == false) {
							if (client.getTerritoryTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getTerritoryTower(), 2, isPresentAnyone)) {
								if (client.getTerritoryTower().getFloor(2).getCard().getGainPrivilegeCouncil()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("PrivilegeCouncil.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									PrivilegeController privilegeController = fxmlLoader.getController();
									privilegeController.setBoardController(this);
									privilegeController.setStage(stage);
									privilegeController.setType("territory3");
								} else {
									putRelativeOnTerritory3();
								}
							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");
			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}}

		catch (

		Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	public void openPrivilegeCouncilForTerritory4() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			boolean isPresentAnyone = false;
			if (relative != null) {
				if (client.getTerritoryTower().getFloor(3).isFree()) {
					if (relative.getValue() >= client.getTerritoryTower().getFloor(3).getCost()) {
						if (client.getTerritoryTower().isPresent(player) == false) {
							if (client.getTerritoryTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getTerritoryTower(), 3, isPresentAnyone)) {
								if (client.getTerritoryTower().getFloor(3).getCard().getGainPrivilegeCouncil()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("PrivilegeCouncil.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									PrivilegeController privilegeController = fxmlLoader.getController();
									privilegeController.setBoardController(this);
									privilegeController.setStage(stage);
									privilegeController.setType("territory4");
								} else {
									putRelativeOnTerritory3();
								}
							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");
			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (

		Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	public void openPageForVenture1() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			boolean isPresentAnyone = false;
			if (relative != null) {
				if (client.getVentureTower().getFloor(0).isFree()) {
					if (relative.getValue() >= client.getVentureTower().getFloor(0).getCost()) {
						if (client.getVentureTower().isPresent(player) == false) {
							if (client.getVentureTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getVentureTower(), 0, isPresentAnyone)) {
								if (client.getVentureTower().getFloor(0).getCard().getGainPrivilegeCouncil()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("PrivilegeCouncil.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									PrivilegeController privilegeController = fxmlLoader.getController();
									privilegeController.setBoardController(this);
									privilegeController.setStage(stage);
									privilegeController.setType("venture1");
								} else if (client.getBoard().getVentureTower().getFloor(0).getCard()
										.getAlternativeCost()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("AlternativeCost.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									AlternativeCostController alternativeCostController = fxmlLoader.getController();
									alternativeCostController.setBoardController(this);
									alternativeCostController.setStage(stage);
									alternativeCostController.setType("venture1");
								}else {
									putRelativeOnVenture1();
								}
							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");
			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	

	@FXML
	public void openPageForVenture2() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			boolean isPresentAnyone = false;
			if (relative != null) {
				if (client.getVentureTower().getFloor(1).isFree()) {
					if (relative.getValue() >= client.getVentureTower().getFloor(1).getCost()) {
						if (client.getVentureTower().isPresent(player) == false) {
							if (client.getVentureTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getVentureTower(), 1, isPresentAnyone)) {
								if (client.getVentureTower().getFloor(1).getCard().getGainPrivilegeCouncil()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("PrivilegeCouncil.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									PrivilegeController privilegeController = fxmlLoader.getController();
									privilegeController.setBoardController(this);
									privilegeController.setStage(stage);
									privilegeController.setType("venture2");
								} else if (client.getBoard().getVentureTower().getFloor(1).getCard()
										.getAlternativeCost()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("AlternativeCost.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									AlternativeCostController alternativeCostController = fxmlLoader.getController();
									alternativeCostController.setBoardController(this);
									alternativeCostController.setStage(stage);
									alternativeCostController.setType("venture2");
								}else {
									putRelativeOnVenture2();
								}
							} else {
								openMessage("NotEnoughResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");
			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}}
		catch (

		Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	public void openPageForVenture3() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			boolean isPresentAnyone = false;
			if (relative != null) {
				if (client.getVentureTower().getFloor(2).isFree()) {
					if (relative.getValue() >= client.getVentureTower().getFloor(2).getCost()) {
						if (client.getVentureTower().isPresent(player) == false) {
							if (client.getVentureTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getVentureTower(), 2, isPresentAnyone)) {
								if (client.getVentureTower().getFloor(2).getCard().getGainPrivilegeCouncil()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("PrivilegeCouncil.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									PrivilegeController privilegeController = fxmlLoader.getController();
									privilegeController.setBoardController(this);
									privilegeController.setStage(stage);
									privilegeController.setType("venture3");
								} else if (client.getBoard().getVentureTower().getFloor(2).getCard()
										.getAlternativeCost()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("AlternativeCost.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									AlternativeCostController alternativeCostController = fxmlLoader.getController();
									alternativeCostController.setBoardController(this);
									alternativeCostController.setStage(stage);
									alternativeCostController.setType("venture3");
								}else {
									putRelativeOnVenture3();
								}
							} else {
								openMessage("NotEnoughResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");
			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}}

		catch (

		Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	public void openPageForVenture4() {
		try {
			if (client.getPlayer().getName().equals(client.getCurrentPlayer().getName())){
			boolean isPresentAnyone = false;
			if (relative != null) {
				if (client.getVentureTower().getFloor(3).isFree()) {
					if (relative.getValue() >= client.getVentureTower().getFloor(3).getCost()) {
						if (client.getVentureTower().isPresent(player) == false) {
							if (client.getVentureTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getVentureTower(), 3, isPresentAnyone)) {
								if (client.getVentureTower().getFloor(3).getCard().getGainPrivilegeCouncil()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("PrivilegeCouncil.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									PrivilegeController privilegeController = fxmlLoader.getController();
									privilegeController.setBoardController(this);
									privilegeController.setStage(stage);
									privilegeController.setType("venture4");
								} else if (client.getBoard().getVentureTower().getFloor(3).getCard()
										.getAlternativeCost()) {
									FXMLLoader fxmlLoader = new FXMLLoader(
											getClass().getResource("AlternativeCost.fxml"));
									Parent root1 = (Parent) fxmlLoader.load();
									Stage stage = new Stage();
									stage.setScene(new Scene(root1));
									stage.show();
									AlternativeCostController alternativeCostController = fxmlLoader.getController();
									alternativeCostController.setBoardController(this);
									alternativeCostController.setStage(stage);
									alternativeCostController.setType("venture4");
								}else {
									putRelativeOnVenture4();
								}
							} else {
								openMessage("NotEnoughResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughValueMessage.fxml");
						relative = null;
					}
				} else {
					openMessage("SpaceOccupiedMessage.fxml");
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");
			}
		}
			else{
				openMessage("NotYorTurn.fxml");
			}}


		catch (

		Exception e) {
			e.printStackTrace();
		}

	}
	


	public void initializeBoard(ClientModel client) {
		// this.client = client;
		initializeBoard1();
	}

	@FXML
	public void initializeBoard1() {
		setPlayer();
		String value;
		value = String.valueOf(client.getBoard().getWhiteDice().getValue());
		whiteDice.setText(value);

		value = String.valueOf(client.getBoard().getOrangeDice().getValue());
		orangeDice.setText(value);

		value = String.valueOf(client.getBoard().getBlackDice().getValue());
		blackDice.setText(value);

		territoryCard = new ArrayList<ImageView>();
		territoryCard.add(0, territory1);
		territoryCard.add(1, territory2);
		territoryCard.add(2, territory3);
		territoryCard.add(3, territory4);
		territoryCard.add(4, territory5);
		territoryCard.add(5, territory6);

		buildingCard = new ArrayList<ImageView>();
		buildingCard.add(0, building1);
		buildingCard.add(1, building2);
		buildingCard.add(2, building3);
		buildingCard.add(3, building4);
		buildingCard.add(4, building5);
		buildingCard.add(5, building6);

		ventureCard = new ArrayList<ImageView>();
		ventureCard.add(0, venture1);
		ventureCard.add(1, venture2);
		ventureCard.add(2, venture3);
		ventureCard.add(3, venture4);
		ventureCard.add(4, venture5);
		ventureCard.add(5, venture6);

		characterCard = new ArrayList<ImageView>();
		characterCard.add(0, character1);
		characterCard.add(1, character2);
		characterCard.add(2, character3);
		characterCard.add(3, character4);
		characterCard.add(4, character5);
		characterCard.add(5, character6);

		harvestRight = new ArrayList<ImageView>();
		harvestRight.add(0, harvestRight1);
		harvestRight.add(1, harvestRight2);
		harvestRight.add(2, harvestRight3);
		harvestRight.add(3, harvestRight4);
		harvestRight.add(4, harvestRight5);
		productionRight = new ArrayList<ImageView>();
		productionRight.add(0, productionRight1);
		productionRight.add(1, productionRight2);
		productionRight.add(2, productionRight3);
		productionRight.add(3, productionRight4);
		productionRight.add(4, productionRight5);
		councilPalace = new ArrayList<ImageView>();
		councilPalace.add(0, councilPalace1);
		councilPalace.add(1, councilPalace2);
		councilPalace.add(2, councilPalace3);
		councilPalace.add(3, councilPalace4);
		councilPalace.add(4, councilPalace5);
		councilPalace.add(5, councilPalace6);
		councilPalace.add(6, councilPalace7);
		councilPalace.add(7, councilPalace8);
		councilPalace.add(8, councilPalace9);
		councilPalace.add(9, councilPalace10);
		councilPalace.add(10, councilPalace11);
		councilPalace.add(11, councilPalace12);

		String string;
		string = client.getTerritoryTower().getFloor(3).getCard().getName();

		territoryImage4 = new Image("Cards/" + string + ".png");

		string = client.getTerritoryTower().getFloor(2).getCard().getName();
		territoryImage3 = new Image("Cards/" + string + ".png");

		string = client.getTerritoryTower().getFloor(1).getCard().getName();
		territoryImage2 = new Image("Cards/" + string + ".png");

		string = client.getTerritoryTower().getFloor(0).getCard().getName();
		territoryImage1 = new Image("Cards/" + string + ".png");

		string = client.getBuildingTower().getFloor(3).getCard().getName();
		buildingImage4 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(2).getCard().getName();
		buildingImage3 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(1).getCard().getName();
		buildingImage2 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(0).getCard().getName();
		buildingImage1 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(3).getCard().getName();
		ventureImage4 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(2).getCard().getName();
		ventureImage3 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(1).getCard().getName();
		ventureImage2 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(0).getCard().getName();
		ventureImage1 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(3).getCard().getName();
		characterImage4 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(2).getCard().getName();
		characterImage3 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(1).getCard().getName();
		characterImage2 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(0).getCard().getName();
		characterImage1 = new Image("Cards/" + string + ".png");

		territoryTower4.setImage(territoryImage4);
		territoryTower3.setImage(territoryImage3);
		territoryTower2.setImage(territoryImage2);
		territoryTower1.setImage(territoryImage1);
		buildingTower4.setImage(buildingImage4);
		buildingTower3.setImage(buildingImage3);
		buildingTower2.setImage(buildingImage2);
		buildingTower1.setImage(buildingImage1);
		ventureTower4.setImage(ventureImage4);
		ventureTower3.setImage(ventureImage3);
		ventureTower2.setImage(ventureImage2);
		ventureTower1.setImage(ventureImage1);
		characterTower4.setImage(characterImage4);
		characterTower3.setImage(characterImage3);
		characterTower2.setImage(characterImage2);
		characterTower1.setImage(characterImage1);

	};

	public void quit() {

	}

	public void setClient(ClientModel clientModel) {
		this.client = clientModel;
	}

	public void setWelcomeController(WelcomeController welcomeController) {
	}

	public void setServerStub(ServerRMIConnectionViewRemote serverStub) {
		this.serverStub = serverStub;
	}

	public void openMessage(String string) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(string));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkCardCost(Tower tower, int i, boolean isPresentAnyone)
			throws FileNotFoundException, IOException, ParseException {
		Card cardToGive = null;
		switch (tower.getType()) {
		case "territory": {
			cardToGive = client.getTerritoryTower().getFloor(i).getCard();
		}
		case "building": {
			cardToGive = client.getBuildingTower().getFloor(i).getCard();
		}
		case "venture": {
			cardToGive = client.getVentureTower().getFloor(i).getCard();
		}
		case "character": {
			cardToGive = client.getCharacterTower().getFloor(i).getCard();
		}
		}

		boolean check = false;
		JsonMilitaryPointForTerritory jsonMilitaryPointForTerritory = new JsonMilitaryPointForTerritory();
		jsonMilitaryPointForTerritory.importMilitaryPointForTerritory();

		if (client.getPlayer().counter("territory") == 2
				&& player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheThirdCard()) {
			check = false;
			return check;
		}

		if (client.getPlayer().counter("territory") == 3
				&& player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheFourthCard()) {
			check = false;
			return check;
		}
		if (client.getPlayer().counter("territory") == 4
				&& player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheFifthCard()) {
			check = false;
			return check;
		}
		if (client.getPlayer().counter("territory") == 5
				&& player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheSixthCard()) {
			check = false;
			return check;
		}

		if (cardToGive instanceof CharacterCard) {
			if (!isPresentAnyone && ((CharacterCard) cardToGive).getCostCoin() == 0
					|| client.getPlayer().getCoin() >= ((CharacterCard) cardToGive).getCostCoin()) {
				check = true;
			} else if (isPresentAnyone
					&& client.getPlayer().getCoin() >= ((CharacterCard) cardToGive).getCostCoin() + tower.getCost()) {
				check = true;
			} else {
				check = false;
			}
		}
		if (cardToGive instanceof TerritoryCard) {
			if (isPresentAnyone && client.getPlayer().getCoin() >= tower.getCost()) {
				check = true;
			}
			check = false;
			return check;
		}
		if (cardToGive instanceof BuildingCard) {
			if ((!isPresentAnyone && ((BuildingCard) cardToGive).getCostCoin() == 0
					|| client.getPlayer().getCoin() >= ((BuildingCard) cardToGive).getCostCoin())
					|| (isPresentAnyone && client.getPlayer().getCoin() >= ((BuildingCard) cardToGive).getCostCoin()
							+ tower.getCost())) {
				if (((BuildingCard) cardToGive).getCostWood() == 0
						|| client.getPlayer().getWood() >= ((BuildingCard) cardToGive).getCostWood()) {
					if (((BuildingCard) cardToGive).getCostStone() == 0
							|| client.getPlayer().getStone() >= ((BuildingCard) cardToGive).getCostStone()) {
						if (((BuildingCard) cardToGive).getCostServant() == 0
								|| client.getPlayer().getServant() >= ((BuildingCard) cardToGive).getCostServant()) {
							check = true;
						}
					}
				}
			} else {
				check = false;
			}
			return check;
		}
		if (cardToGive instanceof VentureCard) {
			if ((!isPresentAnyone && (((VentureCard) cardToGive).getCostCoin() == 0
					|| client.getPlayer().getCoin() >= ((VentureCard) cardToGive).getCostCoin()))
					|| (isPresentAnyone && client.getPlayer().getCoin() >= ((BuildingCard) cardToGive).getCostCoin()
							+ tower.getCost())) {
				if (((VentureCard) cardToGive).getCostWood() == 0
						|| client.getPlayer().getWood() >= ((VentureCard) cardToGive).getCostWood()) {
					if (((VentureCard) cardToGive).getCostStone() == 0
							|| client.getPlayer().getStone() >= ((VentureCard) cardToGive).getCostStone()) {
						if (((VentureCard) cardToGive).getCostServant() == 0
								|| client.getPlayer().getServant() >= ((VentureCard) cardToGive).getCostServant()) {
							check = true;
						}
					}
				}
			} else {
				check = false;
			}
			return check;
		}
		return check;
	}

	@FXML
	private void chooseAlternativeCost() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlternativeCost.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	

	public void setPlayer() {
		String value;
		value = String.valueOf(client.getPlayer().getCoin());
		coin.setText(value);
		value = String.valueOf(client.getPlayer().getWood());
		wood.setText(value);
		value = String.valueOf(client.getPlayer().getStone());
		stone.setText(value);
		value = String.valueOf(client.getPlayer().getServant());
		servant.setText(value);
	}

	public void setBoard() {
		String value;
		value = String.valueOf(client.getBoard().getWhiteDice().getValue());
		whiteDice.setText(value);

		value = String.valueOf(client.getBoard().getOrangeDice().getValue());
		orangeDice.setText(value);

		value = String.valueOf(client.getBoard().getBlackDice().getValue());
		blackDice.setText(value);

		territoryCard = new ArrayList<ImageView>();
		territoryCard.add(0, territory1);
		territoryCard.add(1, territory2);
		territoryCard.add(2, territory3);
		territoryCard.add(3, territory4);
		territoryCard.add(4, territory5);
		territoryCard.add(5, territory6);

		buildingCard = new ArrayList<ImageView>();
		buildingCard.add(0, building1);
		buildingCard.add(1, building2);
		buildingCard.add(2, building3);
		buildingCard.add(3, building4);
		buildingCard.add(4, building5);
		buildingCard.add(5, building6);

		ventureCard = new ArrayList<ImageView>();
		ventureCard.add(0, venture1);
		ventureCard.add(1, venture2);
		ventureCard.add(2, venture3);
		ventureCard.add(3, venture4);
		ventureCard.add(4, venture5);
		ventureCard.add(5, venture6);

		characterCard = new ArrayList<ImageView>();
		characterCard.add(0, character1);
		characterCard.add(1, character2);
		characterCard.add(2, character3);
		characterCard.add(3, character4);
		characterCard.add(4, character5);
		characterCard.add(5, character6);

		harvestRight = new ArrayList<ImageView>();
		harvestRight.add(0, harvestRight1);
		harvestRight.add(1, harvestRight2);
		harvestRight.add(2, harvestRight3);
		harvestRight.add(3, harvestRight4);
		harvestRight.add(4, harvestRight5);
		productionRight = new ArrayList<ImageView>();
		productionRight.add(0, productionRight1);
		productionRight.add(1, productionRight2);
		productionRight.add(2, productionRight3);
		productionRight.add(3, productionRight4);
		productionRight.add(4, productionRight5);
		councilPalace = new ArrayList<ImageView>();
		councilPalace.add(0, councilPalace1);
		councilPalace.add(1, councilPalace2);
		councilPalace.add(2, councilPalace3);
		councilPalace.add(3, councilPalace4);
		councilPalace.add(4, councilPalace5);
		councilPalace.add(5, councilPalace6);
		councilPalace.add(6, councilPalace7);
		councilPalace.add(7, councilPalace8);
		councilPalace.add(8, councilPalace9);
		councilPalace.add(9, councilPalace10);
		councilPalace.add(10, councilPalace11);
		councilPalace.add(11, councilPalace12);

		String string;
		string = client.getTerritoryTower().getFloor(3).getCard().getName();

		territoryImage4 = new Image("Cards/" + string + ".png");

		string = client.getTerritoryTower().getFloor(2).getCard().getName();
		territoryImage3 = new Image("Cards/" + string + ".png");

		string = client.getTerritoryTower().getFloor(1).getCard().getName();
		territoryImage2 = new Image("Cards/" + string + ".png");

		string = client.getTerritoryTower().getFloor(0).getCard().getName();
		territoryImage1 = new Image("Cards/" + string + ".png");

		string = client.getBuildingTower().getFloor(3).getCard().getName();
		buildingImage4 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(2).getCard().getName();
		buildingImage3 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(1).getCard().getName();
		buildingImage2 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(0).getCard().getName();
		buildingImage1 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(3).getCard().getName();
		ventureImage4 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(2).getCard().getName();
		ventureImage3 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(1).getCard().getName();
		ventureImage2 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(0).getCard().getName();
		ventureImage1 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(3).getCard().getName();
		characterImage4 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(2).getCard().getName();
		characterImage3 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(1).getCard().getName();
		characterImage2 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(0).getCard().getName();
		characterImage1 = new Image("Cards/" + string + ".png");

		territoryTower4.setImage(territoryImage4);
		territoryTower3.setImage(territoryImage3);
		territoryTower2.setImage(territoryImage2);
		territoryTower1.setImage(territoryImage1);
		buildingTower4.setImage(buildingImage4);
		buildingTower3.setImage(buildingImage3);
		buildingTower2.setImage(buildingImage2);
		buildingTower1.setImage(buildingImage1);
		ventureTower4.setImage(ventureImage4);
		ventureTower3.setImage(ventureImage3);
		ventureTower2.setImage(ventureImage2);
		ventureTower1.setImage(ventureImage1);
		characterTower4.setImage(characterImage4);
		characterTower3.setImage(characterImage3);
		characterTower2.setImage(characterImage2);
		characterTower1.setImage(characterImage1);
	}

	public void setMarket(MarketBuilding market, Player player2, Relative relative2) {
		String relativeColor;
		switch (relative2.getColor()) {
		case ORANGE: {
			relativeColor = "RelativeOrange";
			break;
		}
		case WHITE: {
			relativeColor = "RelativeWhite";
			break;
		}
		case BLACK: {
			relativeColor = "RelativeBlack";
			break;
		}
		default: {
			relativeColor = "RelativeNeutral";
			break;
		}

		}
		Image marketImage = new Image("Images/" + player2.getColor() + relativeColor + "1.png");
		switch (market.getType()) {
		case "1": {
			market1.setImage(marketImage);
			break;
		}
		case "2": {
			market2.setImage(marketImage);
			break;
		}
		case "3": {
			market3.setImage(marketImage);
			break;
		}
		case "4": {
			market4.setImage(marketImage);
			break;
		}
		}
	}

	public void setTower(Tower tower, int floor, Player player2, Relative relative2) {
		String relativeColor;
		switch (relative2.getColor()) {
		case ORANGE: {
			relativeColor = "RelativeOrange";
			break;
		}
		case WHITE: {
			relativeColor = "RelativeWhite";
			break;
		}
		case BLACK: {
			relativeColor = "RelativeBlack";
			break;
		}
		default: {
			relativeColor = "RelativeNeutral";
			break;
		}

		}
		Image towerImage = new Image("Images/" + player2.getColor() + relativeColor + "1.png");
		System.out.println(tower.getType());
		switch (tower.getType()) {
		case "territory": {
			switch (floor) {
			case 0: {
				territoryTower1.setImage(towerImage);
				System.out.println("sono qui");
				break;
			}
			case 1: {
				territoryTower2.setImage(towerImage);
				System.out.println("sono quiT2");
				break;
			}
			case 3: {
				territoryTower3.setImage(towerImage);
				System.out.println("sono quit3");
				break;
			}
			case 4: {
				territoryTower4.setImage(towerImage);
				System.out.println("sono quit4");
				break;
			}
			}
			break;
		}
		case "building": {
			switch (floor) {
			case 0: {
				buildingTower1.setImage(towerImage);
				System.out.println("sono quib1");
				break;
			}
			case 1: {
				buildingTower2.setImage(towerImage);
				break;
			}
			case 3: {
				buildingTower3.setImage(towerImage);
				break;
			}
			case 4: {
				buildingTower4.setImage(towerImage);
				break;
			}
			}
			break;
		}
		case "character": {
			switch (floor) {
			case 0: {
				characterTower1.setImage(towerImage);
				break;
			}
			case 1: {
				characterTower2.setImage(towerImage);
				break;
			}
			case 3: {
				characterTower3.setImage(towerImage);
				break;
			}
			case 4: {
				characterTower4.setImage(towerImage);
				break;
			}
			}
			break;
		}
		case "venture": {
			switch (floor) {
			case 0: {
				ventureTower1.setImage(towerImage);
				break;
			}
			case 1: {
				ventureTower2.setImage(towerImage);
				break;
			}
			case 3: {
				ventureTower3.setImage(towerImage);
				break;
			}
			case 4: {
				ventureTower4.setImage(towerImage);
				break;
			}
			}
			break;
		}
		}
	}

	public void setProductionLeftArea(Relative relative2) {
		// TODO Auto-generated method stub

	}

	public void setHarvestLeftArea(Relative relative2) {
		// TODO Auto-generated method stub

	}
	
	
	public ClientModel getClient() {
		return client;
	}

	public void giveCurrentTurnOrder(ArrayList <Player> currentTurnOrder) {
		currentTurnOrder = new ArrayList<Player>();
		this.currentTurnOrder = currentTurnOrder;
		
	}
}
