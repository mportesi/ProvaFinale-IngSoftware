package it.polimi.ingsw.effects;

import it.polimi.ingsw.GC_40.Player;

public abstract class Effect {
	
	public abstract void apply(Player player);

	public void apply(Player player, String resource);
	
}
