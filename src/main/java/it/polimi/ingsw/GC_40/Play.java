package it.polimi.ingsw.GC_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polimi.ingsw.colors.ColorPlayer;

public class Play extends Observable<Notify>
{
	private static ArrayList<Player> players;
	private Player currentPlayer;
	private Board board;
	private PlayState state;
	
	public Play(){
		this.board=new Board();
		this.players=new ArrayList<Player>();
	}
	
	public void initializeGame(ArrayList<Player> players){
		this.players=players;
		ArrayList<Player> currentTurnOrder=createTurnOrder(players);
		initializePlayer(currentTurnOrder);
		this.state = new PlayState(0, 0, currentTurnOrder);
		this.currentPlayer = currentTurnOrder.get(0);
		state.changePeriod();
		state.changeRound();
		
	}
	
	public void giveStartingCoin(ArrayList<Player> currentTurnOrder){
		int coin=5;
		for(Player p:currentTurnOrder){
			p.incrementCoin(coin);
			coin++;
		}
		
	}
	
	public void initializePlayer(ArrayList<Player> currentTurnOrder){
		int i=0;
		for(Player p:currentTurnOrder){
			//TO DO SET E GET, MATTEO
			p.setCoin(0);
			p.setWood(2);
			p.setServant(3);
			p.setStone(2);
			p.setMilitaryPoint(0);
			p.setVictorypoint(0);
			p.setFaithPoint(0);
			i++;
		}
		
		giveStartingCoin(currentTurnOrder);
		
		

	}
	
	public static ArrayList<Player> createTurnOrder(ArrayList<Player> players) {
		Collections.shuffle(players);
		return players;
	}
	
	
	// unire playState e play
	
	
	public void changePlayer(){
		//TO DO MATTEO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NON URLARE
	}
	
	public void changeTurnOrder(){
		
	}
	
	public void changeRound(){
		
	}
	
	
	public void changePeriod(){
		
	}
	
	public void giveFinalPoint(){
		//assegna i punti a ciascun player
	}
	
	public void endGame(){
		//restituisce la classifica e il vincitore
	}
	
	

}
