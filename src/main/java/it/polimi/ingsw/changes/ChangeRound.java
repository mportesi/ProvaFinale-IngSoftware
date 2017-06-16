package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;

public class ChangeRound implements Change {
	private int round;
	private Board board;
	
	public ChangeRound(int round, Board board){
	this.board = board;
	this.round = round;
	}

	@Override
	public void applyChange(ClientModel client) {
		client.setRound(round);
		client.setBoard(board);
		client.getPlayer().getBlackRelative().setValue(board.getBlackDice().getValue());
		client.getPlayer().getWhiteRelative().setValue(board.getWhiteDice().getValue());
		client.getPlayer().getOrangeRelative().setValue(board.getOrangeDice().getValue());
		client.getPlayer().setFreeRelative(client.getPlayer().getBlackRelative());
		client.getPlayer().setFreeRelative(client.getPlayer().getWhiteRelative());
		client.getPlayer().setFreeRelative(client.getPlayer().getOrangeRelative());
		client.getPlayer().setFreeRelative(client.getPlayer().getNeutralRelative());

	}

}
