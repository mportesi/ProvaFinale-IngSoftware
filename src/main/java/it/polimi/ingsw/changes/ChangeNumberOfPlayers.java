package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangeNumberOfPlayers implements Change {
	private int numberOfPlayers;
	private Player player;
	private Board board;
	
	public ChangeNumberOfPlayers(int numberOfPlayers, Player player, Board board){
		this.numberOfPlayers=numberOfPlayers;
		this.player=player;
		this.board=board;
	}

	@Override
	public void applyChange(ClientModel client)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		client.setBoard(board);
		if(numberOfPlayers>=2){
		System.out.println(player.getName() + " has disconnected. Now you are only in " + numberOfPlayers);}
		else{
			System.out.println(player.getName() + " has disconnected. You won");
		}
		

	}

}
