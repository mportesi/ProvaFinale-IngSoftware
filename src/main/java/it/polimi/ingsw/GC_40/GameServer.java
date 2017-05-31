package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import it.polimi.ingsw.actions.PutRelativeOnCouncilPalace;
import it.polimi.ingsw.actions.PutRelativeOnHarvestArea;
import it.polimi.ingsw.actions.PutRelativeOnMarket;
import it.polimi.ingsw.actions.PutRelativeOnProductionArea;
import it.polimi.ingsw.actions.PutRelativeOnTower;
import it.polimi.ingsw.areas.MarketBuilding;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.Piece;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.points.FaithPoint;
import it.polimi.ingsw.points.MilitaryPoint;
import it.polimi.ingsw.resources.Coin;
import it.polimi.ingsw.resources.Servant;
import it.polimi.ingsw.resources.Stone;
import it.polimi.ingsw.resources.Wood;

import java.util.ArrayList;
//da cambiare
public class GameServer {

	public static ArrayList<Player> players;
	public static List<ColorPlayer> colors;
	public static View view;

	public static void main(String[] args) {
		Board board = new Board();
		Scanner in= new Scanner(System.in);
		
		int numberOfPlayer=view.numberOfPlayer();

		initializePlayer(numberOfPlayer);

		PlayState playState = new PlayState(0, 0, createTurnOrder());

		Player currentPlayer = players.get(0);

		for (int i = 0; i < 3; i++) {
			playState.changePeriod();

			for (int j = 0; j < 2; j++) {

				playState.changeRound();
				for (int k = 0; k < (4 * players.size()); k++) {
					/*if (players.size() < 3) {
						System.out.println(
								"You can't use the right parts of the harvest and production value and you can't use the third and fourth parts of the market");
					} else if (players.size() < 4) {
						System.out.println("You can't use the third and fourth parts of the market");
					}
				}*/
				System.out.println("It's the first player's turn: " + currentPlayer.getColor());
				System.out.println("Values are: \n Black:" + Board.blackDice.getValue() + "\n 2) Orange:"
						+ Board.orangeDice.getValue() + "\n 3) White: " + Board.whiteDice.getValue() + "\n 4) Neutral");
				
				String relative= view.chooseTheRelative();
				int usedServant= view.addValue();
				Relative currentRelative = null;
				switch (relative) {
				case "Black": {
					currentRelative = currentPlayer.blackRelative;
					currentRelative.setValue(usedServant);
					//Modify with the observer/observable
					if (currentPlayer.hasBlackRelative == false) {
						System.out.println("This relative is already used");
					} else
						currentPlayer.hasBlackRelative = false;
					break;
				}
				case "Orange": {
					currentRelative = currentPlayer.orangeRelative;
					currentRelative.setValue(usedServant);
					if (currentPlayer.hasOrangeRelative == false) {
						System.out.println("This relative is already used");
					} else
						currentPlayer.hasOrangeRelative = false;
					break;
				}
				case "White": {
					currentRelative = currentPlayer.whiteRelative;
					currentRelative.setValue(usedServant);
					if (currentPlayer.hasWhiteRelative == false) {
						System.out.println("This relative is already used");
					} else
						currentPlayer.hasWhiteRelative = false;
					break;
				}
				case "Neutral": {
					currentRelative = currentPlayer.neutralRelative;
					currentRelative.setValue(usedServant);
					if (currentPlayer.hasNeutralRelative == false) {
						System.out.println("This relative is already used");
					} else
						currentPlayer.hasNeutralRelative = false;
					break;
				}
				}

				
				String action = view.chooseTheMove();

				switch (action) {
				case "PutRelativeOnTower": {
					System.out.println(
							"Tell me the tower:\n 1)Territory tower\n 2)Building tower\n 3)Character Tower\n 4)Venture tower");
					Tower tower = null;
					switch (in.nextInt()) {
					case 1: {
						tower = Board.territoryTower;
						break;
					}
					case 2: {
						tower = Board.buildingTower;
						break;
					}
					case 3: {
						tower = Board.characterTower;
						break;
					}
					case 4: {
						tower = Board.ventureTower;
						break;
					}
					}
					/*
					 * // divide la stringa in base al separatore passato
					 * String[] array = x.split(";");
					 */
					System.out.println("Tell me the floor");
					int floor = in.nextInt();
					PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(currentPlayer, tower, floor,
							currentRelative);
					putRelativeOnTower.apply();
				}
				case "PutRelativeOnCouncilPalace": {
					PutRelativeOnCouncilPalace putRelativeOnCouncilPalace = new PutRelativeOnCouncilPalace(
							currentPlayer, currentRelative);
					System.out.println("Tell me the piece that you want");
					String piece = in.nextLine();
					switch (piece) {
					case "coin": {
						Coin coin = new Coin();
						putRelativeOnCouncilPalace.setPiece(coin);
						break;
					}
					case "wood": {
						Wood wood = new Wood();
						putRelativeOnCouncilPalace.setPiece(wood);
						break;
					}
					case "stone": {
						Stone stone = new Stone();
						putRelativeOnCouncilPalace.setPiece(stone);
						break;
					}
					case "servant": {
						Servant servant = new Servant();
						putRelativeOnCouncilPalace.setPiece(servant);
						break;
					}
					case "faithPoint": {
						FaithPoint faithPoint = new FaithPoint();
						putRelativeOnCouncilPalace.setPiece(faithPoint);
						break;
					}
					case "militaryPoint": {
						MilitaryPoint militaryPoint = new MilitaryPoint();
						putRelativeOnCouncilPalace.setPiece(militaryPoint);
						break;
					}
					}
				}
				case "PutRelativeOnMarket": {
					PutRelativeOnMarket putRelativeOnMarket = new PutRelativeOnMarket(currentPlayer, currentRelative);
					System.out.println("Tell me what market do you prefer");
					switch (in.nextInt()) {
					case 1: {
						MarketBuilding market = Board.market1;
						putRelativeOnMarket.setMarket(market);
						break;
					}
					case 2: {
						MarketBuilding market = Board.market2;
						putRelativeOnMarket.setMarket(market);
						break;
					}
					case 3: {
						MarketBuilding market = Board.market3;
						putRelativeOnMarket.setMarket(market);
						break;
					}
					case 4: {
						MarketBuilding market = Board.market4;
						putRelativeOnMarket.setMarket(market);
						break;
					}
					}
				}
				case "PutRelativeOnHarvestArea": {
					PutRelativeOnHarvestArea putRelativeOnHarvestArea = new PutRelativeOnHarvestArea(currentPlayer,
							currentRelative);
					break;
				}
				case "PutRelativeOnProductionArea": {
					PutRelativeOnProductionArea putRelativeOnProductionArea = new PutRelativeOnProductionArea(
							currentPlayer, currentRelative);
					break;
				}

				}
				System.out.println("Now your resources are: ");
				System.out.println("coin:" + currentPlayer.getCoin());
				System.out.println("wood:" + currentPlayer.getWood());
				System.out.println("stone:" + currentPlayer.getStone());
				System.out.println("servant:" + currentPlayer.getServant());
				System.out.println("And you have these points:");
				System.out.println("faithPoint:" + currentPlayer.getFaithPoint());
				System.out.println("militaryPoint:" + currentPlayer.getMilitaryPoint());
				System.out.println("victoryPoint:" + currentPlayer.getVictoryPoint());

				playState.changeCurrentPlayer();

			}
		}

		playState.checkWinner();
		}

	}

	public static void initializePlayer(int numberOfPlayer) {
		for (ColorPlayer color : ColorPlayer.values()) {
			colors.add(color);
		}

		for (int i = 0; i < numberOfPlayer; i++) {
			Player player = new Player(colors.get(i));
			players.add(player);
		}

	}

	public static ArrayList<Player> createTurnOrder() {
		Collections.shuffle(players);
		return players;

	}
	
	public static String chooseCost(Player player){
		return view.chooseCostForVentureCards();
	}

}
