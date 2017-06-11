package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Dice;

public class ChangeInitializeBoard implements Change {
	private Board board;
	private Dice blackDice;
	private Dice orangeDice;
	private Dice whiteDice;
	
	public ChangeInitializeBoard(Board board, Dice blackDice, Dice orangeDice, Dice whiteDice){
		this.board=board;
		this.blackDice=blackDice;
		this.orangeDice = orangeDice;
		this.whiteDice = whiteDice;
	}

	@Override
	public void applyChange(ClientModel client) {
		// TODO Auto-generated method stub
		//System.out.println("board");
		client.setBoard(board);
		
		client.getPlayer().getBlackRelative().setValue(board.getBlackDice().getValue());
		client.getPlayer().getOrangeRelative().setValue(board.getOrangeDice().getValue());
		client.getPlayer().getWhiteRelative().setValue(board.getWhiteDice().getValue());
		
		System.out.println(client.getBoard().getBlackDice().getValue());
		/*client.setBlackDice(blackDice);
		client.setOrangeDice(orangeDice);
		client.setWhiteDice(whiteDice);*/
		
		//System.out.println(client.getBoard());
		
	}

	@Override
	public String toString() {
		return "ChangeInitializeBoard [board=" + board + "]";
	}

}
