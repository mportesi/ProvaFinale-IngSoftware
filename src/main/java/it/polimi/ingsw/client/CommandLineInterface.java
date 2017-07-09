package it.polimi.ingsw.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.GC_40.TimerAction;
import it.polimi.ingsw.actions.*;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;
import it.polimi.ingsw.effects.GainResourceForCost;
import it.polimi.ingsw.effects.GainResourceForCostAlternative;
import it.polimi.ingsw.json.JsonTimeOut;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

/**
 * @author Sara
 * It is the class that handle the command line.
 * It has all the methods to do the different actions and it sends the actions to the server.
 */
public class CommandLineInterface implements Serializable, Runnable {

	private BufferedReader in;
	private ClientModel client;
	private ServerRMIConnectionViewRemote serverStub;
	private Timer timer;
	private ObjectOutputStream socketOut;
	

	public CommandLineInterface(ClientModel client, ServerRMIConnectionViewRemote serverStub, Timer timer) {
		in = new BufferedReader(new InputStreamReader(System.in));
		this.client = client;
		this.serverStub = serverStub;
		this.timer=timer;
	}

	public CommandLineInterface(ClientModel client) {
		in = new BufferedReader(new InputStreamReader(System.in));
		this.client = client;
	}
	
	public CommandLineInterface(ClientModel client, ObjectOutputStream socketOut, Timer timer) {
		in = new BufferedReader(new InputStreamReader(System.in));
		this.client = client;
		this.socketOut=socketOut;
		this.timer=timer;
	}
	
	public void esci() throws FileNotFoundException, NullPointerException, RemoteException, IOException, ParseException, InterruptedException{


	@SuppressWarnings("deprecation")

		ShiftPlayer shiftPlayer = new ShiftPlayer(client.getPlayer().getMatch());
		serverStub.notifyObserver(shiftPlayer);
	
	}
	
	/**
	 * @author Sara
	 * This method is the first method that is done when change the current player.
	 * It asks if the player wants to do an action or prefer to see the board or quit or shift the turn.
	 */
	public void input()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {

		if(client.getCurrentPlayer().getName().equals(client.getPlayer().getName())){
		System.out.println("Your status is: "+client.getPlayer());
		System.out.println("\nChoose: 1)Do an action 2)Print the board 3)Quit \nIf you want to shift your turn press 0.");
		int input = Integer.parseInt(in.readLine());
	
		switch (input) {
		case 1: {
			timer.cancel();
			Relative relative = chooseTheRelative();
			int servant = chooseServants(relative);
			serverStub.notifyObserver(new SetServant(servant, client.getPlayer(), relative, client.getPlayer().getMatch()));
			PutRelative putRelative = chooseTheAction(relative);
			serverStub.notifyObserver(putRelative);
			break;
		}
		case 2: {
			timer.cancel();
			printTheBoard();
			
			break;
		}
		case 0:{
			ShiftPlayer shiftPlayer = new ShiftPlayer(client.getPlayer().getMatch());
			serverStub.notifyObserver(shiftPlayer);
			break;
		}
		case 3: {
			timer.cancel();
			serverStub.notifyObserver(new Quit(client.getPlayer(), client.getPlayer().getMatch()));
			client.setQuit(true);
		
			int input0 = Integer.parseInt(in.readLine());
			
			switch(input0){
			case 0: 
				System.out.println("reconnect");
				serverStub.notifyObserver(new Reconnect(client.getPlayer(), client.getPlayer().getMatch()));
				
			break;
			}
		}
		
		
		}}

	
		}
		
		

	public void printTheBoard() {
		client.getBoard();
	}
	
	/**
	 * @author Sara
	 * This method is the first method (with socket) that is done when change the current player.
	 * It asks if the player wants to do an action or prefer to see the board or quit or shift the turn.
	 */
	public void inputSocket() throws NumberFormatException, IOException, NullPointerException, ParseException, InterruptedException{
		if(client.getCurrentPlayer().getName().equals(client.getPlayer().getName())){
			System.out.println("Your status is: "+client.getPlayer());
			System.out.println("\nChoose: 1)Do an action 2)Print the board 3)Quit \nIf you want to shift your turn press 0.");
			int input = Integer.parseInt(in.readLine());
		
			switch (input) {
			case 1: {
				timer.cancel();
				Relative relative = chooseTheRelative();
				int servant = chooseServants(relative);
				SetServant setServant=new SetServant(servant, client.getPlayer(), relative, client.getPlayer().getMatch());
				socketOut.reset();
				socketOut.writeObject(setServant);
				PutRelative putRelative = chooseTheAction(relative);
				socketOut.reset();
				socketOut.writeObject(putRelative);
				
				break;
			}
			case 2: {
				timer.cancel();
				printTheBoard();
				
				break;
			}
			case 0:{
				ShiftPlayer shiftPlayer = new ShiftPlayer(client.getPlayer().getMatch());
				socketOut.reset();
				socketOut.writeObject(shiftPlayer);
				break;
			}
			case 3: {
				timer.cancel();
				Quit quit=new Quit(client.getPlayer(), client.getPlayer().getMatch());
				socketOut.reset();
				socketOut.writeObject(quit);
				client.setQuit(true);
			
				int input0 = Integer.parseInt(in.readLine());
				
				switch(input0){
				case 0: 
					System.out.println("reconnect");
					Reconnect reconnect =new Reconnect(client.getPlayer(), client.getPlayer().getMatch());
					socketOut.reset();
					socketOut.writeObject(reconnect);
					
				break;
				}
			}
			
			
			}}

		
		
	}

	/**
	 * @author Sara
	 * This is the method that asks what relative the player wants.
	 */
	public Relative chooseTheRelative()
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		System.out.println("\n\nLa board è: \n" + client.getBoard());
		System.out.println("Il tuo stato è: \n" + client.getPlayer());
		System.out.println("\n Choose what relative you want to use: \n 1) black \n 2) white \n 3) orange \n 4) neutral");
		Relative relative = null;
		int input = Integer.parseInt(in.readLine());
		switch (input) {
		
		case 1: {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getBlackRelative())) {
				relative = client.getPlayer().getBlackRelative();
				break;
			} else {
				System.out.println("\nYou cannot use this relative, it is already used");
				relative = chooseTheRelative();
				break;
			}

		}
		case 2: {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getWhiteRelative())) {
				relative = client.getPlayer().getWhiteRelative();
				break;
			} else {
				System.out.println("\nYou cannot use this relative, it is already used");
				relative = chooseTheRelative();
				break;
			}

		}
		case 3: {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getOrangeRelative())) {
				relative = client.getPlayer().getOrangeRelative();
				break;
			} else {
				System.out.println("\nYou cannot use this relative, it is already used");
				relative = chooseTheRelative();
				break;
			}

		}
		case 4: {
			if (client.getPlayer().getBooleanRelative(client.getPlayer().getNeutralRelative())) {
				relative = client.getPlayer().getNeutralRelative();
				break;
			} else {
				System.out.println("\nYou cannot use this relative, it is already used");
				relative = chooseTheRelative();
				break;
			}

		}
		
		default: {
			System.out.println("\nError: insert again");
			relative = chooseTheRelative();
			break;
		}
		}
		
		return relative;
	}

	/**
	 * @author Sara
	 * If the player wants to add value to his relatives, he can use servants.
	 */
	public int chooseServants(Relative relative) throws IOException {
		System.out.println("\nHow many servants do you want to use?");
		boolean legalServant = false; // loop until a legal servant numbers is
										// given
		int valueServant = 0;
		while (!legalServant) {
			valueServant = Integer.parseInt(in.readLine());
			
			if (valueServant <= client.getPlayer().getServant()) {
				relative.setValueServant(valueServant);
				legalServant = true;
			} else {
				System.out.println(
						"\nNot enough servant, you have only " + client.getPlayer().getServant() + " servant.");
			}
		}
		System.out.println("\nThe value of the relative with servant is  " + relative.getValue());
		return valueServant;
	}

	/**
	 * @author Sara
	 * This method is the main method to choose the action.
	 * Based on the action spaces other methods are invoked.
	 */
	public PutRelative chooseTheAction(Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {

		System.out.println("\nChoose where you want to put the relative:");
		System.out.println("1) Tower");
		System.out.println("2) CouncilPalace");
		System.out.println("3) Market");
		System.out.println("4) HarvestArea");
		System.out.println("5) ProductionArea");

		PutRelative putRelative = null;
		int input = Integer.parseInt(in.readLine());
		switch (input) {
		
		case 1: {
			Tower tower = chooseTower();
			int floor = chooseFloor();
			//check and apply the bonus from the character card
			switch(tower.getType()) {
			case "territory" :{
				relative.addValue(client.getPlayer().getTerrCardBonus());
				break;
			}
			case "building" :{
				relative.addValue(client.getPlayer().getBuildCardBonus());
				break;
			}
			case "character" :{
				relative.addValue(client.getPlayer().getCharCardBonus());
				break;
			}
			case "venture" :{
				relative.addValue(client.getPlayer().getVentCardBonus());
				break;
			}
			default:{
				break;
			}
			}
			putRelative = chooseThePutRelativeOnTower(tower, floor, relative);
			break;
		}
		case 2: {
			String bonus = choosePrivilegeCouncil();
			putRelative = new PutRelativeOnCouncilPalace(client.getPlayer(), relative,
					client.getBoard().getCouncilPalace(), bonus, client.getPlayer().getMatch());
			break;
		}
		case 3: {
			if (client.getBoard().getNumberOfPlayers() == 4) {
				System.out.println(
						"\nChoose the market to put your relative: \n 1)Gain coin \n 2)Gain servant \n 3)Gain military point and coin \n 4)Gain two different privilege Council");
				int number = Integer.parseInt(in.readLine());
				MarketBuilding market = client.getMarket(number);
				if (number == 4) {
					putRelative = new PutRelativeOnMarketPrivilege(client.getPlayer(), relative, market,
							choosePrivilegeCouncil(), client.getPlayer().getMatch());
				} else {
					putRelative = new PutRelativeOnMarket(client.getPlayer(), relative, market, client.getPlayer().getMatch());
				}
			} else {
				System.out.println("\nChoose the market to put your relative: \n 1)Gain coin \n 2)Gain servant");
				int number = Integer.parseInt(in.readLine());
				MarketBuilding market = client.getMarket(number - 1);
				putRelative = new PutRelativeOnMarket(client.getPlayer(), relative, market, client.getPlayer().getMatch());
			}
			break;
		}
		case 4: {
			String harvestArea = chooseHarvestArea();
			relative.addValue(client.getPlayer().getHarvestBonus());
			putRelative = new PutRelativeOnHarvestArea(client.getPlayer(), relative, client.getBoard().getHarvestArea(),
					harvestArea, client.getPlayer().getMatch());

			break;
		}
		case 5: {
			String productionArea = chooseProductionArea();
			relative.addValue(client.getPlayer().getProductionBonus());
			ArrayList<Effect> permanentEffect=chooseBuildingPermanentEff(client.getPlayer(), relative);
			putRelative = new PutRelativeOnProductionArea(client.getPlayer(), relative,
					client.getBoard().getProductionArea(), productionArea, client.getPlayer().getMatch(), permanentEffect);

			break;
		}
		default: {
			System.out.println("Try again");
			putRelative = chooseTheAction(relative);
		}
		}
		

		return putRelative;
	}

	/**
	 * @author Sara
	 * This method is an auxiliary method that is used to understand what specific action has to be applied based on the card
	 * on the chosen tower and the chosen floor 
	 */
	public PutRelative chooseThePutRelativeOnTower(Tower tower, int floor, Relative relative) throws IOException {
		PutRelative putRelative = null;
		switch (tower.getType()) {
		case "territory": {
			if (client.getBoard().getTerritoryTower().getFloor(floor).getCard() != null) {
				if (client.getBoard().getTerritoryTower().getFloor(floor).getCard().getGainPrivilegeCouncil()) {
					String bonus = choosePrivilegeCouncil();
					putRelative = new PutRelativeOnTowerPrivilege(client.getPlayer(), tower, floor, relative, bonus, client.getPlayer().getMatch());
				} else {
					putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative, client.getPlayer().getMatch());
				}
			} else {
				System.out.println("It is occupied by another player. Choose again!");
				try {
					chooseTheAction(relative);
				} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		case "building": {
			putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative, client.getPlayer().getMatch());
			break;
		}
		case "character": {
			if (client.getBoard().getCharacterTower().getFloor(floor).getCard()!=null) {
				if(client.getBoard().getCharacterTower().getFloor(floor).getCard().getGainPrivilegeCouncil()){
					String bonus = choosePrivilegeCouncil();
					if(client.getBoard().getCharacterTower().getFloor(floor).getCard().getGetCard()){
						System.out.println("You can take another card");
						Tower tower2 = chooseTower();
						int floor2 = chooseFloor();
						if(tower2.getFloor(floor2).getCard().getGainPrivilegeCouncil()){
							String bonus2 = choosePrivilegeCouncil();
							putRelative = new PutRelativeOnTowerDoublePrivilegeDoubleCard(client.getPlayer(), tower, floor, relative, tower2, floor2, bonus, bonus2,client.getPlayer().getMatch());
							break;
						}else{
							putRelative = new PutRelativeOnTowerPrivilegeDoubleCard(client.getPlayer(), tower, floor, relative, tower2, floor2, bonus, client.getPlayer().getMatch());
							break;
						}
						
					}else{
						putRelative = new PutRelativeOnTowerPrivilege(client.getPlayer(), tower, floor, relative, bonus, client.getPlayer().getMatch());
						break;
					}
				}else{
					if(client.getBoard().getCharacterTower().getFloor(floor).getCard().getGetCard()){
						System.out.println("You can take another card");
						Tower tower2 = chooseTower();
						int floor2 = chooseFloor();
						if(tower2.getFloor(floor2).getCard().getGainPrivilegeCouncil()){
							String bonus = choosePrivilegeCouncil();
							putRelative = new PutRelativeOnTowerDoubleCardHasPrivilege(client.getPlayer(), tower, floor, relative, tower2, floor2, bonus, client.getPlayer().getMatch());
							break;
						}else{
							putRelative = new PutRelativeOnTowerDoubleCard(client.getPlayer(), tower, floor, relative, tower2, floor2, client.getPlayer().getMatch());
							break;
						}
					}else{
						putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative, client.getPlayer().getMatch());
						break;
					}
				}
			}
			break;
		}
		case "venture": {
			if (client.getBoard().getVentureTower().getFloor(floor).getCard().getAlternativeCost()) {
				putRelative = new PutRelativeOnTowerAltCost(client.getPlayer(), tower, floor, relative,
						chooseAlternativeCost(), client.getPlayer().getMatch());
			} else if (client.getBoard().getVentureTower().getFloor(floor).getCard().getGainPrivilegeCouncil()) {
				String bonus = choosePrivilegeCouncil();
				putRelative = new PutRelativeOnTowerPrivilege(client.getPlayer(), tower, floor, relative, bonus, client.getPlayer().getMatch());
			} else {
				putRelative = new PutRelativeOnTower(client.getPlayer(), tower, floor, relative, client.getPlayer().getMatch());
			}
			break;
		}
		}
		return putRelative;
	}

	/**
	 * @author Sara
	 * This method is necessary to choose the aletrnative cost of the venture cards
	 */
	private boolean chooseAlternativeCost() throws IOException {
		boolean choice = false;
		System.out.println("\nChoose if you prefer: \n 1)military cost \n 2)the other cost");

		int input = Integer.parseInt(in.readLine());
		switch (input) {
		
		case 1: {
			choice = true;
			return choice;
		}
		case 2: {
			choice = false;
			return choice;
		}
		default: {
			System.out.println("\nError: insert again");
			choice = chooseAlternativeCost();
		}
		}
		
		return choice;
	}

	/**
	 * @author Sara
	 * To choose the tower
	 */
	public Tower chooseTower() throws IOException {

		System.out.println("\nChoose the tower:");
		System.out.println("1) Territory tower");
		System.out.println("2) Building tower");
		System.out.println("3) Character tower");
		System.out.println("4) Venture tower");
	
		int input = Integer.parseInt(in.readLine());
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
			System.out.println("\nError: insert again");
			tower = chooseTower();
			return tower;
		}
		}
		
	}
	/**
	 * @author Sara
	 * To choose the floor
	 */
	public int chooseFloor() throws IOException {
		System.out.println("\nChoose the number of the floor:");
		int floor;
		floor = Integer.parseInt(in.readLine());
		floor -= 1;
		
		if (floor < 0 || floor > 4){
			System.out.println("\nThat floor don't exist!");
			floor = chooseFloor();
		}
	

		return (floor);
	}

	/**
	 * @author Sara
	 * To choose the bonus when there is an effect of the type gain  privilege council
	 */
	public String choosePrivilegeCouncil() {

		System.out.println("\nChoose the privilege Council:");
		System.out.println("1) 2 coin");
		System.out.println("2) 1 wood and 1 Stone");
		System.out.println("3) 1 servant");
		System.out.println("4) 1 faithPoint");
		System.out.println("5) 2 militaryPoint");
		String resource = null;
		int choice = 0;
		
		try {
			choice = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch (choice) {
	
		case 1: {
			resource = "coin";
			break;
		}
		case 2: {
			resource = "woodAndStone";
			break;
		}
		case 3: {
			resource = "servant";
			break;
		}
		case 4: {
			resource = "faithPoint";
			break;
		}
		case 5: {
			resource = "militaryPoint";
			break;
		}
		}
		if (choice < 1 || choice > 5) {
			System.out.println("\nError: insert again");
			choosePrivilegeCouncil();
		}

		return resource;
	}

	/**
	 * @author Sara
	 * To choose if he wants to put a relative on the right or on the left of the harvest area
	 */
	public String chooseHarvestArea() {
		String harvestArea = null;
		int choice = 0;
		if (client.getBoard().getNumberOfPlayers() >= 3) {
			System.out.println("sono entrato nell'if");
			if (client.getBoard().getHarvestArea().getLeftRelative() != null) {
				System.out.println("\nThe left area is occupied. You can only put on the right area");
				harvestArea = "right";
			}
			// Choose if you want to place the relative left or right
			System.out.println("\nChoose where you want to put your relative: \n1) left \n2) right");
			try {
				choice = Integer.parseInt(in.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (choice < 1 || choice > 2) {
				System.out.println("\nError: insert again");
				chooseHarvestArea();
			}
			switch (choice) {
			case 1: {
				harvestArea = "left";
				break;
			}
			case 2: {
				harvestArea = "right";
			}
			}
			return harvestArea;
		} else {
			harvestArea = "left";
			return harvestArea;
		}
	}

	/**
	 * @author Sara
	 * To choose if he wants to put a relative on the right or on the left of the production area
	 */
	public String chooseProductionArea() {
		String productionArea = null;
		int choice = 0;
		if (client.getBoard().getNumberOfPlayers() >= 3) {
			if (client.getBoard().getProductionArea().getLeftRelative() != null) {
				System.out.println("\nThe left area is occupied. You can only put on the right area");
				productionArea = "right";
			}
			// Choose if you want to place the relative left or right
			System.out.println("\nChoose where you want to put your relative: \n1) left \n2) right");
			try {
				choice = Integer.parseInt(in.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (choice < 1 || choice > 2) {
				System.out.println("\nError: insert again");
				chooseProductionArea();
			}
			switch (choice) {
			case 1: {
				productionArea = "left";
				break;
			}
			case 2: {
				productionArea = "right";
			}
			}
			return productionArea;
		} else {
			productionArea = "left";
			return productionArea;
		}
	}

	@Override
	public void run() {
		
	}


	/**
	 * @author Sara
	 * To choose the permanent effect of the building cards.
	 */
	public ArrayList<Effect> chooseBuildingPermanentEff(Player player, Relative relative){
		ArrayList<Effect> chosenEffect=new ArrayList<Effect>();
		try {
		for(BuildingCard card:player.getBuilding() ){
			if(relative.getValue()>=card.getPermanentCost()){
				for(Effect currentEffect:card.getPermanentEffect()){
					System.out.println("Do you want to use this effect? ");
					System.out.println(currentEffect.toString());
					System.out.println("1) Yes\n 2) No");
					int input;
					
						input = Integer.parseInt(in.readLine());
					
					if(input==1){
						
						if(currentEffect instanceof GainResourceForCostAlternative){
							System.out.print("Do you want to use the 1)first or 2)second?");
							int choice=Integer.parseInt(in.readLine());
							if(choice==1){
								((GainResourceForCostAlternative) currentEffect).chooseAlt(false);
							}
							else{
								((GainResourceForCostAlternative) currentEffect).chooseAlt(true);
							}
							if(currentEffect.isApplicable(player)){
								chosenEffect.add(currentEffect);
							}
							else{
								System.out.println("You dont have enough resource!");
							}
						}
						
						else if(currentEffect instanceof GainResourceForCost){
							if(currentEffect.isApplicable(player)){
								chosenEffect.add(currentEffect);
							}
							else{
								System.out.println("You dont have enough resource!");
							}
						}
						
						else{
							chosenEffect.add(currentEffect);
						}
						
					}
				}
			}
		}
		
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return chosenEffect;
		
	}
	

	
	


}
