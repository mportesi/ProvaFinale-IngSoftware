package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.client.ClientModel;

public class ChangeInitialize implements Change {
	private Board board;
	
	public ChangeInitialize(Board board){
		this.board=board;
	}

	@Override
	public void applyChange(ClientModel client) {
		// TODO Auto-generated method stub
		System.out.println("board");
		client.setBoard(board);
		
	}

}
