package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Dice;
import javafx.event.Event;

/**
 * @author Sara
 * To set the board on every client at the beginning of the game.
 */
public class ChangeInitializeBoard implements Change {
	private Board board;
	private Player currentPlayer;
	
	
	public ChangeInitializeBoard(Board board, Player currentPlayer){
		this.board=board;
		this.currentPlayer=currentPlayer;
	}

	@Override
	public void applyChange(ClientModel client) {
		if (currentPlayer.getMatch() == client.getPlayer().getMatch()){
		client.initializeBoard(board);
		client.setCurrentPlayer(currentPlayer);
	}
	}

	@Override
	public String toString() {
		return "ChangeInitializeBoard [board=" + board + "]";
	}

}
