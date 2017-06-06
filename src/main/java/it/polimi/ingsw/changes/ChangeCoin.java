package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeCoin implements Change {
	private int coin;
	private ColorPlayer color;

	public ChangeCoin(ColorPlayer color, int coin){
		this.coin=coin;
		this.color=color;
	}

	@Override
	public void applyChange() {
		if(player.getColor().equals(color)){
			player.setCoin(coin);
		}
		
		
	}

}
