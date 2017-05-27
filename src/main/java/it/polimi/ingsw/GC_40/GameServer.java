package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
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
		play.changePeriod();
		play.changeRound();
		
		
	
		
		
		
		
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
