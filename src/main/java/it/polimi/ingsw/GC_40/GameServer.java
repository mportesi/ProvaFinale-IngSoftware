package it.polimi.ingsw.GC_40;

import java.util.Scanner;

public class GameServer {
	
	public static void main(String[] args){
		Board board=new Board();
		
		Scanner in=new Scanner(System.in);
		System.out.println("Inserisci numero di player: ");
		int numberOfPlayer=in.nextInt();
		
		initializePlayer(numberOfPlayer);
		
	}
	
	public static void initializePlayer(int numberOfPlayer){
		for(int i=0; i<numberOfPlayer; i++){
			Player player=new Player();
		}
	}

}
