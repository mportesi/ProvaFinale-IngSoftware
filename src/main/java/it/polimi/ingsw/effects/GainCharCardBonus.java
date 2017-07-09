package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

public class GainCharCardBonus extends Effect {
	int charBonus;
	
	public GainCharCardBonus(int charBonus){
		this.charBonus=charBonus;
	}


	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.addCharCardBonus(charBonus, play);

	}
	
	@Override
	public String toString(){
		return ("Permanent Effect: gain " + charBonus + " bonus on Character card Action"  );
	}

}