package it.polimi.ingsw.effects;

import it.polimi.ingsw.GC_40.Player;

public class GainStone extends Effect {
	int stone;
	
	public GainStone(int costImmediateEffect){
		this.stone=costImmediateEffect;
	}

	@Override
	public void apply(Player player){
		player.incrementStone(stone);

	}

}