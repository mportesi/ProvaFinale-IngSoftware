package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
/**
 * @author Sara
 * To notify every client that another client is disconnected.
 */
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
		if(client.getPlayer().getMatch()==player.getMatch()){
		client.setBoard(board);
		client.setNumberOfPlayer(player);
		
		System.out.println(player.getName() + " has disconnected. Now you are only in " + numberOfPlayers);
		
		if (client.getPlayer().getName().equals(player.getName())){
			System.out.println("Press '0' if you want to reconnect");
		}
		}
		

	}
	}

