package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainVentCardBonus extends Effect {
	int ventBonus;
	
	public GainVentCardBonus(int ventBonus){
		this.ventBonus=ventBonus;
	}


	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.addTerrCardBonus(ventBonus, play);

	}
	
	@Override
	public String toString(){
		return ("Permanent Effect: gain " + ventBonus + " bonus on Venture card Action"  );
	}

}