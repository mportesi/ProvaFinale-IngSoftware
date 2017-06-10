package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.client.ClientModel;

public class ChangeInitializeBoard implements Change {
	private Board board;
	
	public ChangeInitializeBoard(Board board){
		this.board=board;
	}

	@Override
	public void applyChange(ClientModel client) {
		// TODO Auto-generated method stub
		//System.out.println("board");
		client.setBoard(board);
		//System.out.println(client.getBoard());
		
	}

	@Override
	public String toString() {
		return "ChangeInitializeBoard [board=" + board + "]";
	}

}
