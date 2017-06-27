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
	private int match;
	
	public ChangeRound(int round, Board board, int match){
	this.board = board;
	this.round = round;
	this.match=match;
	}

	@Override
	public void applyChange(ClientModel client) {
		System.out.println("c :"+ client.getPlayer().getMatch() + "match: "+ match);
		if(client.getPlayer().getMatch()==match){
		client.setRound(round);
		client.setBoard(board);
		client.getPlayer().getBlackRelative().setValue(board.getBlackDice().getValue());
		client.getPlayer().getWhiteRelative().setValue(board.getWhiteDice().getValue());
		client.getPlayer().getOrangeRelative().setValue(board.getOrangeDice().getValue());
		client.getPlayer().setFreeAllRelatives();
		System.out.println("It's finished the " + (round-1) + " round");
		System.out.println("The new board is: " + client.getBoard());
	}}

}
