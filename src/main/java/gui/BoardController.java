package gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import org.evosuite.shaded.antlr.debug.Event;
import org.json.simple.parser.ParseException;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class BoardController {

	private ClientModel client;
	private Relative relative;
	private Player player;
	private WelcomeController welcomeController;
	private Gui gui;
	private ServerRMIConnectionViewRemote serverStub;

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
	private ImageView councilPalace;
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
	private ImageView harvestRight;
	@FXML
	private ImageView productionLeft;
	@FXML
	private ImageView productionRight;
	@FXML
	private ImageView blackDice;
	@FXML
	private ImageView whiteDice;
	@FXML
	private ImageView orangeDice;
	@FXML
	private Button quit;

	@FXML
	public void chooseWhiteRelative() {
		relative = client.getPlayer().getWhiteRelative();
	}

	@FXML
	public void chooseOrangeRelative() {
		relative = client.getPlayer().getOrangeRelative();
	}

	@FXML
	public void chooseBlackRelative() {
		relative = client.getPlayer().getBlackRelative();
	}

	@FXML
	public void chooseNeutralRelative() {
		relative = client.getPlayer().getNeutralRelative();
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
									String bonus = openPrivilegeCouncil();
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getTerritoryTower(), 0, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getTerritoryTower(), 0, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								territoryTower1.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
									String bonus = openPrivilegeCouncil();
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getTerritoryTower(), 1, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getTerritoryTower(), 1, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								territoryTower2.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
									String bonus = openPrivilegeCouncil();
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getTerritoryTower(), 2, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getTerritoryTower(), 2, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								territoryTower3.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
									String bonus = openPrivilegeCouncil();
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getTerritoryTower(), 3, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getTerritoryTower(), 3, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								territoryTower4.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
								buildingTower1.setImage(null);
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
						relative=null;
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
								buildingTower2.setImage(null);
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
						relative=null;
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
								buildingTower3.setImage(null);
								this.relative = null;
							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
								buildingTower4.setImage(null);
								this.relative = null;
							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
								characterTower1.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
								characterTower2.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
								characterTower3.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
								characterTower1.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
									String bonus = openPrivilegeCouncil();
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
								ventureTower1.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
									String bonus = openPrivilegeCouncil();
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getVentureTower(), 1, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else if (client.getBoard().getVentureTower().getFloor(1).getCard()
										.getAlternativeCost()) {
									boolean military = false; // TODO
									chooseAlternativeCost();
									PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
											client.getPlayer(), client.getVentureTower(), 1, relative, military,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getVentureTower(), 1, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								ventureTower2.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
									String bonus = openPrivilegeCouncil();
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getVentureTower(), 2, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else if (client.getBoard().getVentureTower().getFloor(2).getCard()
										.getAlternativeCost()) {
									boolean military = false; // TODO
									chooseAlternativeCost();
									PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
											client.getPlayer(), client.getVentureTower(), 2, relative, military,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getVentureTower(), 2, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								ventureTower3.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
									String bonus = openPrivilegeCouncil();
									PutRelativeOnTowerPrivilege putRelativeOnTower = new PutRelativeOnTowerPrivilege(
											client.getPlayer(), client.getVentureTower(), 3, relative, bonus,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else if (client.getBoard().getVentureTower().getFloor(3).getCard()
										.getAlternativeCost()) {
									boolean military = false; // TODO
									chooseAlternativeCost();
									PutRelativeOnTowerAltCost putRelativeOnTower = new PutRelativeOnTowerAltCost(
											client.getPlayer(), client.getVentureTower(), 3, relative, military,
											client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								} else {
									PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(client.getPlayer(),
											client.getVentureTower(), 3, relative, client.getMatch());
									serverStub.notifyObserver(putRelativeOnTower);
								}
								ventureTower4.setImage(null);
								this.relative = null;

							} else {
								openMessage("NotEnoughtResourceMessage.fxml");
							}
						} else {
							openMessage("AnotherRelativeInTowerMessage.fxml");
						}
					} else {
						openMessage("NotEnoughtValueMessage.fxml");
						relative=null;
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
					String bonus = openPrivilegeCouncil();// todo
					PutRelativeOnCouncilPalace putRelativeOnCouncilPalace = new PutRelativeOnCouncilPalace(
							client.getPlayer(), relative, client.getBoard().getCouncilPalace(), bonus,
							client.getMatch());
					serverStub.notifyObserver(putRelativeOnCouncilPalace);

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
	public void putRelativeOnMarket1() {
		try {
			if (relative != null) {
				if (relative.getValue() >= client.getMarket(0).getCost()) {
					PutRelativeOnMarket putRelativeOnMarket = new PutRelativeOnMarket(client.getPlayer(), relative,
							client.getMarket(0), client.getMatch());
					serverStub.notifyObserver(putRelativeOnMarket);
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
					String bonus = openPrivilegeCouncil();
					PutRelativeOnMarketPrivilege putRelativeOnMarket = new PutRelativeOnMarketPrivilege(
							client.getPlayer(), relative, client.getMarket(3), bonus, client.getMatch());
					serverStub.notifyObserver(putRelativeOnMarket);
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

					} else {
						openMessage("SpaceOccupiedMessage.fxml");

					}
				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative=null;
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

					} else {
						openMessage("SpaceOccupiedMessage.fxml");

					}
				} else {
					openMessage("NotEnoughValueMessage.fxml");
					relative=null;
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
			PutRelativeOnProductionArea putRelativeOnProductionArea = new PutRelativeOnProductionArea(client.getPlayer(),
					relative, client.getBoard().getProductionArea(), "right", client.getMatch());
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
	public String openPrivilegeCouncil() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrivilegeCouncil.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void initializeBoard(ClientModel client) {
		this.client = client;
		initializeBoard1();
	}

	@FXML
	public void initializeBoard1() {
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

	};

	public void quit() {

	}

	public void setClient(ClientModel clientModel) {
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

		if (player.counter("territory") == 2
				&& player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheThirdCard()) {
			check = false;
			return check;
		}

		if (player.counter("territory") == 3
				&& player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheFourthCard()) {
			check = false;
			return check;
		}
		if (player.counter("territory") == 4
				&& player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheFifthCard()) {
			check = false;
			return check;
		}
		if (player.counter("territory") == 5
				&& player.getMilitaryPoint() < jsonMilitaryPointForTerritory.getForTheSixthCard()) {
			check = false;
			return check;
		}

		if (cardToGive instanceof CharacterCard) {
			if (!isPresentAnyone && ((CharacterCard) cardToGive).getCostCoin() == 0
					|| player.getCoin() >= ((CharacterCard) cardToGive).getCostCoin()) {
				check = true;
			} else if (isPresentAnyone
					&& player.getCoin() >= ((CharacterCard) cardToGive).getCostCoin() + tower.getCost()) {
				check = true;
			} else {
				check = false;
			}
		}
		if (cardToGive instanceof TerritoryCard) {
			if (isPresentAnyone && player.getCoin() >= tower.getCost()) {
				check = true;
			}
			check = false;
			return check;
		}
		if (cardToGive instanceof BuildingCard) {
			if ((!isPresentAnyone && ((BuildingCard) cardToGive).getCostCoin() == 0
					|| player.getCoin() >= ((BuildingCard) cardToGive).getCostCoin())
					|| (isPresentAnyone
							&& player.getCoin() >= ((BuildingCard) cardToGive).getCostCoin() + tower.getCost())) {
				if (((BuildingCard) cardToGive).getCostWood() == 0
						|| player.getWood() >= ((BuildingCard) cardToGive).getCostWood()) {
					if (((BuildingCard) cardToGive).getCostStone() == 0
							|| player.getStone() >= ((BuildingCard) cardToGive).getCostStone()) {
						if (((BuildingCard) cardToGive).getCostServant() == 0
								|| player.getServant() >= ((BuildingCard) cardToGive).getCostServant()) {
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
					|| player.getCoin() >= ((VentureCard) cardToGive).getCostCoin()))
					|| (isPresentAnyone
							&& player.getCoin() >= ((BuildingCard) cardToGive).getCostCoin() + tower.getCost())) {
				if (((VentureCard) cardToGive).getCostWood() == 0
						|| player.getWood() >= ((VentureCard) cardToGive).getCostWood()) {
					if (((VentureCard) cardToGive).getCostStone() == 0
							|| player.getStone() >= ((VentureCard) cardToGive).getCostStone()) {
						if (((VentureCard) cardToGive).getCostServant() == 0
								|| player.getServant() >= ((VentureCard) cardToGive).getCostServant()) {
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
}
