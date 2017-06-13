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
	private Player player;// ??
	private ClientModel client;

	public CommandLineInterface(Player player, ClientModel client) {
		scanner = new Scanner(System.in);
		this.player = player;
		this.client = client;
	}

	public void input() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		String input = "";
		while (!"quit".equals(input)) {
			try {
				chooseTheAction();
				System.out.println("your turn is finished");
				System.out.println("The board now is:" + client);
			} catch (IllegalStateException e) {
				return;
			}
		}

	}

	public void printTheBoard() {
		client.getBoard();
	}

	public PutRelative chooseTheAction() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		System.out.println("Il tuo stato è: " + player);

		Relative relative = chooseTheRelative();

		System.out.println("ho creato un relative" + relative.getValue());

		System.out.println("Choose where you want to put the relative:");
		System.out.println("Tower");
		System.out.println("CouncilPalace");
		System.out.println("Market");
		System.out.println("HarvestArea");
		System.out.println("ProductionArea");
		scanner.nextLine();
		String input = scanner.nextLine();

		PutRelative putRelative = null;
		// System.out.println("sto entrando nello switch");
		switch (input) {
		case "Tower": {
			Tower tower = chooseTower();
			int floor = chooseFloor();
			putRelative = chooseThePutRelativeOnTower(tower, floor, relative);
			break;
		}
		case "CouncilPalace": {
			String bonus = choosePrivilegeCouncil();
			putRelative = new PutRelativeOnCouncilPalace(player, relative, client.getBoard().getCouncilPalace(), bonus); // TODO
			break;
		}
		case "Market": {
			MarketBuilding market = chooseMarket();
			putRelative = chooseThePutRelativeOnMarket(market, relative);
			break;
		}
		case "HarvestArea": {
			String harvestArea = chooseHarvestArea();
			putRelative = new PutRelativeOnHarvestArea(player, relative, client.getBoard().getHarvestArea(),  harvestArea);

			break;
		}
		case "ProductionArea": {
			String productionArea = chooseProductionArea();
			putRelative = new PutRelativeOnProductionArea(player, relative, client.getBoard().getProductionArea(), productionArea);

			break;
		}

		default: {
			System.out.println("Error: insert again");
			putRelative = chooseTheAction();
			break;
		}

		}
		return putRelative;

	}

	//TO FIX
	private PutRelative chooseThePutRelativeOnMarket(MarketBuilding market, Relative relative) {
		System.out.println("Tell me if you want to have the privilege council");
		return null;
	}

	public PutRelative chooseThePutRelativeOnTower(Tower tower, int floor, Relative relative) {
		System.out.println("Choose if the card that you want to take have one of this effect: \n 1) Gain privilege Council \n 2)Gain another card \n 3)It has an alternative cost \n 4) Otherwise");
		PutRelative putRelative=null;
		switch(scanner.nextInt()){
		case 1:{
			String privilegeCouncil=choosePrivilegeCouncil();
			//putRelative= new PutRelativeOnTowerPrivilege(client.getPlayer(), tower, floor, relative, bonus , GainPrivilegeCouncil gain)
			break;
		}
		case 2:{
			Tower tower2 = chooseTower();
			int floor2= chooseFloor();
			putRelative= new PutRelativeOnTowerDoubleCard(client.getPlayer(), tower, floor, relative, tower2, floor2);
			break;
		}
		case 3:{
			boolean choice= chooseAlternativeCost();
			putRelative= new PutRelativeOnTowerAltCost(client.getPlayer(), tower, floor, relative, choice);
			break;
		}
		default:{
			putRelative= new PutRelativeOnTower(client.getPlayer(), tower, floor, relative);
			break;
		}
		}
		return putRelative;
	}

	private boolean chooseAlternativeCost() {
		System.out.println("Choose if you prefer: \n 1)military cost \n 2)the other cost");
		switch(scanner.nextInt()){
		case 1: {
			return true;
		}
		case 2: {
			return false;
		}
		}
		return false;
	}

	public Relative chooseTheRelative() throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		System.out.println(client.getBoard().getBlackDice());

		System.out.println("Choose what relative you want to use: black, white, orange, neutral");
		String input = scanner.nextLine();
		Relative relative = null;
		switch (input) {
		case "black": {
			if(client.getPlayer().getBooleanRelative(client.getPlayer().getBlackRelative())){
				relative = client.getPlayer().getBlackRelative();
			}
			else{
				System.out.println("You cannot use this relative, it is already used");
			}
			break;
		}
		case "white": {
			if(client.getPlayer().getBooleanRelative(client.getPlayer().getWhiteRelative())){
			relative = client.getPlayer().getWhiteRelative();
			}
			else{
				System.out.println("You cannot use this relative, it is already used");
			}
			break;

		}
		case "orange": {
			if(client.getPlayer().getBooleanRelative(client.getPlayer().getOrangeRelative())){
			relative = client.getPlayer().getOrangeRelative();
			}
			else{
				System.out.println("You cannot use this relative, it is already used");
			}
			break;

		}
		case "neutral": {
			if(client.getPlayer().getBooleanRelative(client.getPlayer().getNeutralRelative())){
			relative = client.getPlayer().getNeutralRelative();}
			else{
				System.out.println("You cannot use this relative, it is already used");
			}
			break;
		}
		default: {
			System.out.println("Error: insert again");
			break;
		}
		}
		System.out.println("THE VALUE OF THE RELATIVE IS  " + relative.getValue());
		System.out.println("THE NAME OF THE RELATIVE IS  " + player.getName());
		System.out.println("How many servants do you want to use?");
		boolean legalServant=false; //loop until a legal servant numbers is given
		while(!legalServant){
			int valueServant = scanner.nextInt();
			if(valueServant <= player.getServant()){
				relative.setValueServant(valueServant);
				player.decrementServant(valueServant);
				legalServant=true;
			}
			else{
				System.out.println("Not enough servant, you have only "+player.getServant()+" servant." );
			}
		}
		System.out.println("the value of the relative with servant is  " + relative.getValue());
		return relative;

	}

	public Tower chooseTower() {

		System.out.println("Choose the tower:");
		System.out.println("territoryTower");
		System.out.println("buildingTower");
		System.out.println("characterTower");
		System.out.println("ventureTower");
		String input = scanner.nextLine();
		Tower tower;
		switch (input) {
		case "territoryTower": {
			tower = this.client.getTerritoryTower();
			return tower;
		}
		case "buildingTower": {
			tower = this.client.getBuildingTower();
			return tower;
		}
		case "characterTower": {
			tower = this.client.getCharacterTower();
			return tower;
		}
		case "ventureTower": {
			tower = this.client.getVentureTower();
			return tower;
		}
		default: {
			System.out.println("Error: insert again");
			break;
		}
		}
		return null;

	}

	public int chooseFloor() {
		System.out.println("Choose the number of the floor:");
		int floor = scanner.nextInt();
		return floor;
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

	public MarketBuilding chooseMarket() {

		System.out.println("Choose the market to put your relative:");
		int number = scanner.nextInt();
		MarketBuilding market = null;
		return client.getMarket(number);
	}

	public String chooseHarvestArea() {

		System.out.println("Choose if you want to put your relative on the left or on the right");
		String harvestArea = scanner.nextLine();
		return harvestArea;

	}

	public String chooseProductionArea() {

		System.out.println("Choose if you want to put your relative on the left or on the right");
		String productionArea = scanner.nextLine();
		return productionArea;

	}

}
