package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Components.Relative;

import java.util.ArrayList;

public class GameServer {
	
	
	public static ArrayList<Player> players;
	public static List<ColorPlayer> colors;
	
	
	
	
	
	public static void main(String[] args){
		Board board=new Board();
		
		
		
		Scanner in=new Scanner(System.in);
		System.out.println("Inserisci numero di player: ");
		int numberOfPlayer=in.nextInt();
		
		initializePlayer(numberOfPlayer);
		
		
		Play play= new Play(0,0, createTurnOrder());
		
		Player currentPlayer=players.get(0);
		play.changePeriod();
		play.changeRound();
		
		System.out.println("It's the first player's turn: "+ currentPlayer.getColor());
		System.out.println("Values are: \n Black:" + Board.blackDice.getValue() + "\n 2) Orange:" + Board.orangeDice.getValue() + "\n 3) White: " + Board.whiteDice.getValue() +"\n 4) Neutral");
		System.out.println("Choose a relative to place:\n" + "1) Black\n 2) Orange\n 3) White \n 4) Neutral");
		int relative = in.nextInt();
		
		switch(relative){
		case 1: { Relative currentRelative = currentPlayer.blackRelative;
			break;
		}
		case 2:{ Relative currentRelative = currentPlayer.orangeRelative;
			break;
		}
		case 3:{ Relative currentRelative = currentPlayer.whiteRelative;
		break;
		}
		case 4:{ Relative currentRelative = currentPlayer.neutralRelative;
		break;
		}
		}
		
		
		System.out.println("Choose:\n" +"1) PutRelativeOnTower\n" +"2) PutRelativeOnCouncilPalace\n" +"3) PutRelativeOnMarket\n" +"4) PutRelativeOnHarvestArea\n" +"5) PutRelativeOnProductionArea");
		int action = in.nextInt();
		 switch(action){
		 case 1: {
			 PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(currentPlayer, currentRelative);
			 
		 }
		 }
		
		
	
		
		
		
		
	}
	
	public static void initializePlayer(int numberOfPlayer){
		for (ColorPlayer color : ColorPlayer.values()){
			colors.add(color);
		}

		for(int i=0; i<numberOfPlayer; i++){
			Player player=new Player(colors.get(i));
			players.add(player);	
		}
		
		
	}
	
	public static ArrayList<Player> createTurnOrder(){
		Collections.shuffle(players);
		return players;
		
		
	}
	
	

}
