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
	private ServerRMIConnectionViewRemote serverStub;
	private Image relativeImage;
	private String bonus;
	private String alternativeCost;
	private Boolean privilegeOpen;
	private boolean alternativeCostBool;
	private ArrayList <ImageView> councilPalace;
	private ArrayList <ImageView> harvestRight;
	private ArrayList <ImageView> productionRight;
	private int i =0;
	private int j = 0;
	private int k =0;
	private ArrayList <ImageView> territoryCard;
	private ArrayList <ImageView> buildingCard;
	private ArrayList <ImageView> ventureCard;
	private ArrayList <ImageView> characterCard;
	private int territory = 0;
	private int venture = 0;
	private int character = 0;
	private int building = 0;
	private Image image1;
	private Image image2;
	private Image image3;
	private Image image4;
	private Image image5;
	private Image image6;
	private Image image7;
	private Image image8;
	private Image image9;
	private Image image10;
	private Image image11;
	private Image image12;
	private Image image13;
	private Image image14;
	private Image image15;
	private Image image16;
	
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
	private TextArea nameFxml;
	@FXML
	private TextArea currentTurnOrderFxml;
	@FXML
	private TextArea colorFxml;
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
	private TextArea servantToUse;
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
	public void chooseWhiteRelative() {
		relative = client.getPlayer().getWhiteRelative();
		relativeImage = new Image("Images/" + client.getPlayer().getColor() + "RelativeWhite1.png");
		try {
			openMessage("HowManyServants.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@FXML
	public void setValueWithServant() {
		String valueNew = servantToUse.getText();
		int value = Integer.parseInt(valueNew);
		relative.setValueServant(value);
		valueWithServant.setText(valueNew);
		
	}
	
	@FXML
	public void chooseOrangeRelative() {
		relative = client.getPlayer().getOrangeRelative();
		relativeImage = new Image("Images/" + client.getPlayer().getColor() + "RelativeOrange1.png");
		try {
			openMessage("HowManyServants.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@FXML
	public void chooseBlackRelative() {
		relative = client.getPlayer().getBlackRelative();
		relativeImage = new Image("Images/" + client.getPlayer().getColor() + "RelativeBlack1.png");
		try {
			openMessage("HowManyServants.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@FXML
	public void chooseNeutralRelative() {
		relative = client.getPlayer().getNeutralRelative();
		relativeImage = new Image("Images/" + client.getPlayer().getColor() + "RelativeNeutral1.png");
		try {
			openMessage("HowManyServants.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@FXML
	public void putRelativeOnTerritory1() {
		boolean isPresentAnyone = false;
		try {
			if (relative != null) {
				if (client.getTerritoryTower().getFloor(0).isFree()) {
					if (relative.getValue() >= client.getTerritoryTower().getFloor(0).getCost()) {
						if (client.getTerritoryTower().isPresent(player) == false) {
							if (client.getTerritoryTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getTerritoryTower(), 0, isPresentAnyone)) {
								if (client.getTerritoryTower().getFloor(0).getCard().getGainPrivilegeCouncil()) {
									openPrivilegeCouncil();
									while (privilegeOpen) {
									}
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getTerritoryTower(), 0, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getTerritoryTower(), 0, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								territoryTower1.setImage(relativeImage);
								setPlayer();
								territoryCard.get(territory).setImage(image4);
								territory++;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnTerritory2() {
		boolean isPresentAnyone = false;
		try {
			if (relative != null) {
				if (client.getTerritoryTower().getFloor(1).isFree()) {
					if (relative.getValue() >= client.getTerritoryTower().getFloor(1).getCost()) {
						if (client.getTerritoryTower().isPresent(player) == false) {
							if (client.getTerritoryTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getTerritoryTower(), 1, isPresentAnyone)) {
								if (client.getTerritoryTower().getFloor(0).getCard().getGainPrivilegeCouncil()) {
									openPrivilegeCouncil();
									while (privilegeOpen) {
									}
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getTerritoryTower(), 1, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getTerritoryTower(), 1, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								territoryTower2.setImage(relativeImage);
								setPlayer();
								territoryCard.get(territory).setImage(image3);
								territory++;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnTerritory3() {
		boolean isPresentAnyone = false;
		try {
			if (relative != null) {
				if (client.getTerritoryTower().getFloor(2).isFree()) {
					if (relative.getValue() >= client.getTerritoryTower().getFloor(2).getCost()) {
						if (client.getTerritoryTower().isPresent(player) == false) {
							if (client.getTerritoryTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getTerritoryTower(), 2, isPresentAnyone)) {
								if (client.getTerritoryTower().getFloor(2).getCard().getGainPrivilegeCouncil()) {
									openPrivilegeCouncil();
									while (privilegeOpen) {
									}
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getTerritoryTower(), 2, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getTerritoryTower(), 2, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								territoryTower3.setImage(relativeImage);
								setPlayer();
								territoryCard.get(territory).setImage(image2);
								territory++;
								this.relative = null;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnTerritory4() {
		boolean isPresentAnyone = false;
		try {
			if (relative != null) {
				if (client.getTerritoryTower().getFloor(3).isFree()) {
					if (relative.getValue() >= client.getTerritoryTower().getFloor(3).getCost()) {
						if (client.getTerritoryTower().isPresent(player) == false) {
							if (client.getTerritoryTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getTerritoryTower(), 3, isPresentAnyone)) {
								if (client.getTerritoryTower().getFloor(1).getCard().getGainPrivilegeCouncil()) {
									openPrivilegeCouncil();
									while (privilegeOpen) {
									}
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getTerritoryTower(), 3, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getTerritoryTower(), 3, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								territoryTower4.setImage(relativeImage);
								setPlayer();
								territoryCard.get(territory).setImage(image1);
								territory++;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnBuilding1() {
		boolean isPresentAnyone = false;
		try {
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
								buildingCard.get(building).setImage(image8);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnBuilding2() {
		boolean isPresentAnyone = false;
		try {
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
								buildingCard.get(building).setImage(image7);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnBuilding3() {
		boolean isPresentAnyone = false;
		try {
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
								buildingCard.get(building).setImage(image6);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnBuilding4() {
		boolean isPresentAnyone = false;
		try {
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
								buildingCard.get(building).setImage(image5);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnCharacter1() {
		boolean isPresentAnyone = false;
		try {
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
								characterCard.get(character).setImage(image16);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnCharacter2() {
		boolean isPresentAnyone = false;
		try {
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
								characterCard.get(character).setImage(image15);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnCharacter3() {
		boolean isPresentAnyone = false;
		try {
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
								characterCard.get(character).setImage(image14);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnCharacter4() {
		boolean isPresentAnyone = false;
		try {
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
								characterCard.get(character).setImage(image13);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnVenture1() {
		boolean isPresentAnyone = false;
		try {
			if (relative != null) {
				if (client.getVentureTower().getFloor(0).isFree()) {
					if (relative.getValue() >= client.getVentureTower().getFloor(0).getCost()) {
						if (client.getVentureTower().isPresent(player) == false) {
							if (client.getVentureTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getVentureTower(), 0, isPresentAnyone)) {
								if (client.getVentureTower().getFloor(0).getCard().getGainPrivilegeCouncil()) {
									openPrivilegeCouncil();
									while (privilegeOpen) {
									}
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getVentureTower(), 0, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else if (client.getBoard().getVentureTower().getFloor(0).getCard()
										.getAlternativeCost()) {
									boolean military = false; // TODO
									chooseAlternativeCost();
									PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
											client.getPlayer(), client.getVentureTower(), 0, relative, military,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getVentureTower(), 0, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								ventureTower1.setImage(relativeImage);
								setPlayer();
								ventureCard.get(venture).setImage(image12);
								venture++;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnVenture2() {
		boolean isPresentAnyone = false;
		try {
			if (relative != null) {
				if (client.getVentureTower().getFloor(1).isFree()) {
					if (relative.getValue() >= client.getVentureTower().getFloor(1).getCost()) {
						if (client.getVentureTower().isPresent(player) == false) {
							if (client.getVentureTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getVentureTower(), 1, isPresentAnyone)) {
								if (client.getVentureTower().getFloor(1).getCard().getGainPrivilegeCouncil()) {
									openPrivilegeCouncil();
									while (privilegeOpen) {
									}
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getVentureTower(), 1, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
									ventureTower2.setImage(relativeImage);
									setPlayer();
									ventureCard.get(venture).setImage(image11);
									venture++;
									this.relative = null;
								} else if (client.getBoard().getVentureTower().getFloor(1).getCard()
										.getAlternativeCost()) {
									boolean military = false; // TODO
									chooseAlternativeCost();
									PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
											client.getPlayer(), client.getVentureTower(), 1, relative, military,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
									ventureTower2.setImage(relativeImage);
									setPlayer();
									ventureCard.get(venture).setImage(image11);
									venture++;
									this.relative = null;
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getVentureTower(), 1, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
									ventureTower2.setImage(relativeImage);
									setPlayer();
									ventureCard.get(venture).setImage(image11);
									venture++;
									this.relative = null;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnVenture3() {
		boolean isPresentAnyone = false;
		try {
			if (relative != null) {
				if (client.getVentureTower().getFloor(2).isFree()) {
					if (relative.getValue() >= client.getVentureTower().getFloor(2).getCost()) {
						if (client.getVentureTower().isPresent(player) == false) {
							if (client.getVentureTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getVentureTower(), 2, isPresentAnyone)) {
								if (client.getVentureTower().getFloor(2).getCard().getGainPrivilegeCouncil()) {
									openPrivilegeCouncil();
									while (privilegeOpen) {
									}
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getVentureTower(), 2, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
									ventureTower3.setImage(relativeImage);
									setPlayer();
									ventureCard.get(venture).setImage(image10);
									venture++;
								} else if (client.getBoard().getVentureTower().getFloor(2).getCard()
										.getAlternativeCost()) {
									boolean military = false; // TODO
									chooseAlternativeCost();
									PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
											client.getPlayer(), client.getVentureTower(), 2, relative, military,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
									ventureTower3.setImage(relativeImage);
									setPlayer();
									ventureCard.get(venture).setImage(image10);
									venture++;
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getVentureTower(), 2, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
									ventureTower3.setImage(relativeImage);
									setPlayer();
									ventureCard.get(venture).setImage(image10);
									venture++;
								}
								
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnVenture4() {
		boolean isPresentAnyone = false;
		try {
			if (relative != null) {
				if (client.getVentureTower().getFloor(3).isFree()) {
					if (relative.getValue() >= client.getVentureTower().getFloor(3).getCost()) {
						if (client.getVentureTower().isPresent(player) == false) {
							if (client.getVentureTower().isPresentAnyone()) {
								isPresentAnyone = true;
							}
							if (checkCardCost(client.getVentureTower(), 3, isPresentAnyone)) {
								if (client.getVentureTower().getFloor(3).getCard().getGainPrivilegeCouncil()) {
									openPrivilegeCouncil();
									while (privilegeOpen) {
									}
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getVentureTower(), 3, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
									ventureTower4.setImage(relativeImage);
									setPlayer();
									ventureCard.get(venture).setImage(image9);
									venture++;
								} else if (client.getBoard().getVentureTower().getFloor(3).getCard()
										.getAlternativeCost()) {
									boolean military = false; // TODO
									chooseAlternativeCost();
									PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
											client.getPlayer(), client.getVentureTower(), 3, relative, military,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
									ventureTower4.setImage(relativeImage);
									setPlayer();
									ventureCard.get(venture).setImage(image9);
									venture++;
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getVentureTower(), 3, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
									ventureTower4.setImage(relativeImage);
									setPlayer();
									ventureCard.get(venture).setImage(image9);
									venture++;
								}
								
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnCouncilPalace() {
		try {
			
			if (relative != null) {
				if (relative.getValue() >= 1) {
					openPrivilegeCouncil();
					while(waitPrivilege()==0){
						Thread.sleep(20);
					};
					if(!privilegeOpen){
						System.out.println("faccio la putRelative");
					PutRelativeOnCouncilPalace putRelativeOnCouncilPalace = new PutRelativeOnCouncilPalace(
							client.getPlayer(), relative, client.getBoard().getCouncilPalace(), bonus,
							client.getMatch());
					serverStub.notifyObserver(putRelativeOnCouncilPalace);
					councilPalace.get(i).setImage(relativeImage);
					setPlayer();
					i++;}

				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative = null;
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int waitPrivilege(){
		if(!privilegeOpen){
			return 1;
		}
		else return 0;
	}
	public void putRelative(Event event){
		
	}

	@FXML
	public void putRelativeOnMarket1() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnMarket2() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnMarket3() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnMarket4() {
		try {
			if (relative != null) {
				if (relative.getValue() >= client.getMarket(3).getCost()) {
					openPrivilegeCouncil();
					PutRelativeOnMarketPrivilege putRelativeOnMarket = new PutRelativeOnMarketPrivilege(
							client.getPlayer(), relative, client.getMarket(3), bonus, client.getMatch());
					serverStub.notifyObserver(putRelativeOnMarket);
					market4.setImage(relativeImage);
				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative = null;
				}
			} else {
				openMessage("ChooseTheRelativeMessage.fxml");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnHarvestLeft() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnHarvestRight() {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	public void putRelativeOnProductionLeft() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void putRelativeOnProductionRight() {
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

	@FXML
	public void openPrivilegeCouncil() {
		setPrivilege(true);
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrivilegeCouncil.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
			PrivilegeController privilegeController = fxmlLoader.getController();
			privilegeController.setBoardController(this);
			while(privilegeOpen){
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPrivilege(boolean open) {
		privilegeOpen = open;
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
		
		territoryCard = new ArrayList <ImageView>();
		territoryCard.add(0, territory1);
		territoryCard.add(1, territory2);
		territoryCard.add(2, territory3);
		territoryCard.add(3, territory4);
		territoryCard.add(4, territory5);
		territoryCard.add(5, territory6);
		
		buildingCard = new ArrayList <ImageView>();
		buildingCard.add(0, building1);
		buildingCard.add(1, building2);
		buildingCard.add(2, building3);
		buildingCard.add(3, building4);
		buildingCard.add(4, building5);
		buildingCard.add(5, building6);
		
		ventureCard = new ArrayList <ImageView>();
		ventureCard.add(0, venture1);
		ventureCard.add(1, venture2);
		ventureCard.add(2, venture3);
		ventureCard.add(3, venture4);
		ventureCard.add(4, venture5);
		ventureCard.add(5, venture6);
		
		characterCard = new ArrayList <ImageView>();
		characterCard.add(0, character1);
		characterCard.add(1, character2);
		characterCard.add(2, character3);
		characterCard.add(3, character4);
		characterCard.add(4, character5);
		characterCard.add(5, character6);
		
		
		
		harvestRight = new ArrayList <ImageView>();
		harvestRight.add(0, harvestRight1);
		harvestRight.add(1, harvestRight2);
		harvestRight.add(2, harvestRight3);
		harvestRight.add(3, harvestRight4);
		harvestRight.add(4, harvestRight5);
		productionRight = new ArrayList <ImageView>();
		productionRight.add(0, productionRight1);
		productionRight.add(1, productionRight2);
		productionRight.add(2, productionRight3);
		productionRight.add(3, productionRight4);
		productionRight.add(4, productionRight5);
		councilPalace = new ArrayList <ImageView>();
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
		System.out.println(string);
		image1 = new Image("Cards/" + string + ".png");
		System.out.println(image1);
		
		string = client.getTerritoryTower().getFloor(2).getCard().getName();
		image2 = new Image("Cards/" + string + ".png");

		string = client.getTerritoryTower().getFloor(1).getCard().getName();
		image3 = new Image("Cards/" + string + ".png");

		string = client.getTerritoryTower().getFloor(0).getCard().getName();
		image4 = new Image("Cards/" + string + ".png");

		string = client.getBuildingTower().getFloor(3).getCard().getName();
		image5 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(2).getCard().getName();
		image6 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(1).getCard().getName();
		image7 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(0).getCard().getName();
		image8 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(3).getCard().getName();
		image9 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(2).getCard().getName();
		image10 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(1).getCard().getName();
		image11 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(0).getCard().getName();
		image12 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(3).getCard().getName();
		image13 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(2).getCard().getName();
		image14 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(1).getCard().getName();
		image15 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(0).getCard().getName();
		image16 = new Image("Cards/" + string + ".png");

		territoryTower4.setImage(image1);
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
		
		//nameFxml.appendText("You are " + client.getPlayer().getName());
		//colorFxml.appendText("Your color is " + client.getPlayer().getColor());
		//currentTurnOrderFxml.appendText("The order is" + client.getCurrentTurnOrder());
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

	public void openMessage(String string) throws Exception {
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

	public void setBonus(String choice) {
		this.bonus = choice;
	}

	public void setPlayer(){
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
		String string;
		string = client.getTerritoryTower().getFloor(3).getCard().getName();
		System.out.println(string);
		Image image1 = new Image("Cards/" + string + ".png");
		System.out.println(image1);
		string = client.getTerritoryTower().getFloor(2).getCard().getName();
		Image image2 = new Image("Cards/" + string + ".png");

		string = client.getTerritoryTower().getFloor(1).getCard().getName();
		Image image3 = new Image("Cards/" + string + ".png");

		string = client.getTerritoryTower().getFloor(0).getCard().getName();
		Image image4 = new Image("Cards/" + string + ".png");

		string = client.getBuildingTower().getFloor(3).getCard().getName();
		Image image5 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(2).getCard().getName();
		Image image6 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(1).getCard().getName();
		Image image7 = new Image("Cards/" + string + ".png");
		string = client.getBuildingTower().getFloor(0).getCard().getName();
		Image image8 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(3).getCard().getName();
		Image image9 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(2).getCard().getName();
		Image image10 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(1).getCard().getName();
		Image image11 = new Image("Cards/" + string + ".png");
		string = client.getVentureTower().getFloor(0).getCard().getName();
		Image image12 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(3).getCard().getName();
		Image image13 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(2).getCard().getName();
		Image image14 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(1).getCard().getName();
		Image image15 = new Image("Cards/" + string + ".png");
		string = client.getCharacterTower().getFloor(0).getCard().getName();
		Image image16 = new Image("Cards/" + string + ".png");

		territoryTower4.setImage(image1);
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
		}case "building": {
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
			}break;
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
			}break;
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
			}break;
		}
		}
	}

	public void setProductionLeftArea(Relative relative2) {
		// TODO Auto-generated method stub
		
	}

	public void setHarvestLeftArea(Relative relative2) {
		// TODO Auto-generated method stub
		
	}

	public void setAlternativeCost(String choice) {
		this.alternativeCost = choice;
		
	}

	public void setAlternativeCostBool(boolean b) {
		this.alternativeCostBool = b;
		
	}
}
