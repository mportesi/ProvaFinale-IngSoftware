package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Actions.PutRelativeOnCouncilPalace;
import Actions.PutRelativeOnHarvestArea;
import Actions.PutRelativeOnMarket;
import Actions.PutRelativeOnProductionArea;
import Actions.PutRelativeOnTower;
import Components.Coin;
import Components.FaithPoint;
import Components.MarketBuilding;
import Components.MilitaryPoint;
import Components.Piece;
import Components.Relative;
import Components.Servant;
import Components.Stone;
import Components.Tower;
import Components.Wood;

import java.util.ArrayList;

public class GameServer {

	public static ArrayList<Player> players;
	public static List<ColorPlayer> colors;

	public static void main(String[] args) {
		Board board = new Board();

		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci numero di player: ");
		int numberOfPlayer = in.nextInt();

		initializePlayer(numberOfPlayer);

		Play play = new Play(0, 0, createTurnOrder());

		Player currentPlayer = players.get(0);

		for (int i = 0; i < 3; i++) {
			play.changePeriod();

			for (int j = 0; j < 2; j++) {

				play.changeRound();
				for (int k = 0; k < (4 * players.size()); k++) {
					if (players.size() < 3) {
						System.out.println(
								"You can't use the right parts of the harvest and production value and you can't use the third and fourth parts of the market");
					} else if (players.size() < 4) {
						System.out.println("You can't use the third and fourth parts of the market");
					}
				}
				System.out.println("It's the first player's turn: " + currentPlayer.getColor());
				System.out.println("Values are: \n Black:" + Board.blackDice.getValue() + "\n 2) Orange:"
						+ Board.orangeDice.getValue() + "\n 3) White: " + Board.whiteDice.getValue() + "\n 4) Neutral");
				System.out.println("Choose a relative to place:\n" + "1) Black\n 2) Orange\n 3) White \n 4) Neutral");
				int relative = in.nextInt();
				System.out.println("Tell me if you want to use servants to give more value to the relative");
				int usedServant = in.nextInt();
				Relative currentRelative = null;
				switch (relative) {
				case 1: {
					currentRelative = currentPlayer.blackRelative;
					currentRelative.setValue(usedServant);
					if (currentPlayer.hasBlackRelative == false) {
						System.out.println("This relative is already used");
					} else
						currentPlayer.hasBlackRelative = false;

					break;
				}
				case 2: {
					currentRelative = currentPlayer.orangeRelative;
					currentRelative.setValue(usedServant);
					if (currentPlayer.hasOrangeRelative == false) {
						System.out.println("This relative is already used");
					} else
						currentPlayer.hasOrangeRelative = false;
					break;
				}
				case 3: {
					currentRelative = currentPlayer.whiteRelative;
					currentRelative.setValue(usedServant);
					if (currentPlayer.hasWhiteRelative == false) {
						System.out.println("This relative is already used");
					} else
						currentPlayer.hasWhiteRelative = false;
					break;
				}
				case 4: {
					currentRelative = currentPlayer.neutralRelative;
					currentRelative.setValue(usedServant);
					if (currentPlayer.hasNeutralRelative == false) {
						System.out.println("This relative is already used");
					} else
						currentPlayer.hasNeutralRelative = false;
					break;
				}
				}

				System.out.println("Choose:\n" + "1) PutRelativeOnTower\n" + "2) PutRelativeOnCouncilPalace\n"
						+ "3) PutRelativeOnMarket\n" + "4) PutRelativeOnHarvestArea\n"
						+ "5) PutRelativeOnProductionArea");
				int action = in.nextInt();

				switch (action) {
				case 1: {
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
				case 2: {
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
				case 3: {
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
				case 4: {
					PutRelativeOnHarvestArea putRelativeOnHarvestArea = new PutRelativeOnHarvestArea(currentPlayer,
							currentRelative);
				}
				case 5: {
					PutRelativeOnProductionArea putRelativeOnProductionArea = new PutRelativeOnProductionArea(
							currentPlayer, currentRelative);
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

				play.changeCurrentPlayer();

			}
		}

		play.checkWinner();

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

}
