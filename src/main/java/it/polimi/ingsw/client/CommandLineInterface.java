package it.polimi.ingsw.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.actions.*;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.PutRelativeOnCouncilPalace;
import it.polimi.ingsw.actions.PutRelativeOnHarvestArea;
import it.polimi.ingsw.actions.PutRelativeOnMarket;
import it.polimi.ingsw.actions.PutRelativeOnProductionArea;
import it.polimi.ingsw.actions.PutRelativeOnTower;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

public class CommandLineInterface implements Serializable {

	private Scanner scanner;
	private ClientModel client;
	private boolean firstTime;

	public CommandLineInterface(ClientModel client) {
		scanner = new Scanner(System.in);
		this.client = client;
	}

	public void printTheBoard() {
		client.getBoard();
	}

	public Relative chooseTheRelative()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		System.out.println("Il tuo stato è: " + client.getPlayer());
		System.out.println("La board è: " + client.getBoard());
		System.out.println("Choose what relative you want to use: black, white, orange, neutral");
		String input = scanner.nextLine();
		Relative relative = null;
		switch (input) {
		case "black": {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getBlackRelative())) {
				relative = client.getPlayer().getBlackRelative();
				break;
			} else {
				System.out.println("You cannot use this relative, it is already used");
			}

		}
		case "white": {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getWhiteRelative())) {
				relative = client.getPlayer().getWhiteRelative();
				break;
			} else {
				System.out.println("You cannot use this relative, it is already used");
			}

		}
		case "orange": {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getOrangeRelative())) {
				relative = client.getPlayer().getOrangeRelative();
				break;
			} else {
				System.out.println("You cannot use this relative, it is already used");
			}

		}
		case "neutral": {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getNeutralRelative())) {
				relative = client.getPlayer().getNeutralRelative();
				break;
			} else {
				System.out.println("You cannot use this relative, it is already used");
			}

		}
		default: {
			System.out.println("Error: insert again");
			relative = chooseTheRelative();
			return relative;
			// break;
		}
		}
		System.out.println("THE VALUE OF THE RELATIVE IS  " + relative.getValue());
		System.out.println("THE NAME OF THE RELATIVE IS  " + client.getPlayer().getName());
		System.out.println("How many servants do you want to use?");
		boolean legalServant = false; // loop until a legal servant numbers is
										// given
		while (!legalServant) {
			int valueServant = scanner.nextInt();
			if (valueServant <= client.getPlayer().getServant()) {
				relative.setValueServant(valueServant);
				client.getPlayer().decrementServant(valueServant);
				legalServant = true;
			} else {
				System.out
						.println("Not enough servant, you have only " + client.getPlayer().getServant() + " servant.");
			}
		}
		System.out.println("the value of the relative with servant is  " + relative.getValue());
		return relative;

	}

	public PutRelative chooseTheAction(Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {

		System.out.println("Choose where you want to put the relative:");
		System.out.println("1) Tower");
		System.out.println("2) CouncilPalace");
		System.out.println("3) Market");
		System.out.println("4) HarvestArea");
		System.out.println("5) ProductionArea");
		scanner.nextLine();
		int input = scanner.nextInt();

		PutRelative putRelative = null;
		// System.out.println("sto entrando nello switch");
		switch (input) {
		case 1: {
			Tower tower = chooseTower();
			int floor = chooseFloor();
			putRelative = chooseThePutRelativeOnTower(tower, floor, relative);
			break;
		}
		case 2: {
			String bonus = choosePrivilegeCouncil();
			putRelative = new PutRelativeOnCouncilPalace(client.getPlayer(), relative,
					client.getBoard().getCouncilPalace(), bonus); // TODO
			break;
		}
		case 3: {
			if (client.getBoard().getNumberOfPlayers() == 4) {
				System.out.println(
						"Choose the market to put your relative: \n 1)Gain coin \n 2)Gain servant \n 3)Gain military point and coin \n 4)Gain two different privilege Council");
				int number = scanner.nextInt();
				MarketBuilding market = client.getMarket(number);
				if (number == 4) {
					putRelative = new PutRelativeOnMarketPrivilege(client.getPlayer(), relative, market,
							choosePrivilegeCouncil());
				} else {
					putRelative = new PutRelativeOnMarket(client.getPlayer(), relative, market);
				}
			} else {
				System.out.println("Choose the market to put your relative: \n 1)Gain coin \n 2)Gain servant");
				int number = scanner.nextInt();
				MarketBuilding market = client.getMarket(number);
				putRelative = new PutRelativeOnMarket(client.getPlayer(), relative, market);
			}
			break;
		}
		case 4: {
			String harvestArea = chooseHarvestArea();
			putRelative = new PutRelativeOnHarvestArea(client.getPlayer(), relative, client.getBoard().getHarvestArea(),
					harvestArea);

			break;
		}
		case 5: {
			String productionArea = chooseProductionArea();
			putRelative = new PutRelativeOnProductionArea(client.getPlayer(), relative,
					client.getBoard().getProductionArea(), productionArea);

			break;
		}

		default: {
			System.out.println("Error: insert again");
			putRelative = chooseTheAction(relative);
			break;
		}

		}
		return putRelative;
	}

	public PutRelative chooseThePutRelativeOnTower(Tower tower, int floor, Relative relative) {
		PutRelative putRelative = null;
		switch (tower.getType()) {
		case "territory": {
			if (client.getBoard().getTerritoryTower().getFloor(floor).getCard().getGainPrivilegeCouncil()) {
				putRelative = new PutRelativeOnTowerPrivilege(client.getPlayer(), tower, floor, relative,
						choosePrivilegeCouncil());
			} else {
				putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative);
			}
			break;
		}
		case "building": {
			putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative);
			break;
		}
		case "character": {
			if (client.getBoard().getCharacterTower().getFloor(floor).getCard().getGetCard()) {
				Tower tower2 = chooseTower();
				int floor2 = chooseFloor();
				putRelative = new PutRelativeOnTowerDoubleCard(client.getPlayer(), tower, floor, relative, tower2,
						floor2);
			} else {
				putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative);
			}
			break;
		}
		case "venture": {
			if (client.getBoard().getVentureTower().getFloor(floor).getCard().getAlternativeCost()) {
				putRelative = new PutRelativeOnTowerAltCost(client.getPlayer(), tower, floor, relative,
						chooseAlternativeCost());
			} else if (client.getBoard().getVentureTower().getFloor(floor).getCard().getGainPrivilegeCouncil()) {
				putRelative = new PutRelativeOnTowerPrivilege(client.getPlayer(), tower, floor, relative,
						choosePrivilegeCouncil());
			} else {
				putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative);
			}
			break;
		}
		default: {
			System.out.println("Error: insert again");
			putRelative = chooseThePutRelativeOnTower(tower, floor, relative);
			break;
		}
		}
		return putRelative;
	}

	private boolean chooseAlternativeCost() {
		boolean choice = false;
		System.out.println("Choose if you prefer: \n 1)military cost \n 2)the other cost");
		switch (scanner.nextInt()) {
		case 1: {
			choice = true;
			return choice;
		}
		case 2: {
			choice = false;
			return choice;
		}
		default: {
			System.out.println("Try again!");
			choice = chooseAlternativeCost();
		}
		}
		return choice;
	}

	public Tower chooseTower() {

		System.out.println("Choose the tower:");
		System.out.println("1) Territory tower");
		System.out.println("2) Building tower");
		System.out.println("3) Character tower");
		System.out.println("4) Venture tower");
		int input = scanner.nextInt();
		Tower tower;
		switch (input) {
		case 1: {
			tower = this.client.getTerritoryTower();
			return tower;
		}
		case 2: {
			tower = this.client.getBuildingTower();
			return tower;
		}
		case 3: {
			tower = this.client.getCharacterTower();
			return tower;
		}
		case 4: {
			tower = this.client.getVentureTower();
			return tower;
		}
		default: {
			System.out.println("Error: insert again");
			tower = chooseTower();
			return tower;
			// break;
		}
		}
		// return null;

	}

	public int chooseFloor() {
		System.out.println("Choose the number of the floor:");
		int floor = scanner.nextInt();
		floor -= 1;
		if (floor < 0 || floor > 4) {
			System.out.println("That floor don't exist!");
			floor = chooseFloor();
		}
		return (floor);
	}

	public String choosePrivilegeCouncil() {

		System.out.println("Choose the privilege Council:");
		System.out.println("coin");
		System.out.println("woodAndStone");
		System.out.println("servant");
		System.out.println("faithPoint");
		System.out.println("militaryPoint");

		String resource = scanner.nextLine();
		return resource;
	}

	public String chooseHarvestArea() {
		String harvestArea;
		if (client.getBoard().getNumberOfPlayers() >= 3) {
			if(client.getBoard().getHarvestArea().getLeftRelative()!= null){
				System.out.println("The left area is occupied. You can only put on the right area");
				harvestArea = "right";
			}
			// Choose if you want to place the relative left or right
			System.out.println("Choose if you want to put your relative on the left or on the right");
			harvestArea = scanner.nextLine();
			if (harvestArea != "left" || harvestArea != "right") {
				System.out.println("Try again!");
				harvestArea = chooseHarvestArea();
			}
			return harvestArea;
		} else {
			harvestArea = "left";
			return harvestArea;
		}
	}

	public String chooseProductionArea() {
		String productionArea;
		if (client.getBoard().getNumberOfPlayers() >= 3) {
			if(client.getBoard().getProductionArea().getLeftRelative()!= null){
				System.out.println("The left area is occupied. You can only put on the right area");
				productionArea = "right";
			}
		// Choose if you want to place the relative left or right
		System.out.println("Choose if you want to put your relative on the left or on the right");
		productionArea = scanner.nextLine();
		if (productionArea != "left" || productionArea != "right") {
			System.out.println("Try again!");
			productionArea = chooseProductionArea();
		}
		return productionArea;}
		else {
			productionArea = "left";
			return productionArea;
		}
	}

}
