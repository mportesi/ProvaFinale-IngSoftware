package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainTerrCardBonus extends Effect {
	int terrBonus;
	
	public GainTerrCardBonus(int terrBonus){
		this.terrBonus=terrBonus;
	}


	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.addTerrCardBonus(terrBonus, play);

	}
	
	@Override
	public String toString(){
		return ("Permanent Effect: gain " + terrBonus + " bonus on Territory card Action"  );
	}

}