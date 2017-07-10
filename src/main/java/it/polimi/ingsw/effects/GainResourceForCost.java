package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining resouces associated to a permanent effect.
 *
 */

public class GainResourceForCost extends Effect{
	
	private ArrayList<Effect> payEffect;
	private ArrayList<Effect> gainEffect;
	
	public GainResourceForCost(ArrayList<Effect> pay, ArrayList<Effect>gain){
		payEffect=pay;
		gainEffect=gain;
	}
	
	@Override
	public void apply(Player player, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		for(Effect pay:payEffect){
			pay.apply(player, play);
		}
		for(Effect gain:gainEffect){
			gain.apply(player, play);
		}
	}
	
	@Override
	public boolean isApplicable(Player player){
		boolean check=false;
		for(Effect pay:payEffect){
			check=pay.isApplicable(player);
			if(check==false){
				return check;
			}
		}
		return check;
	}
	@Override
	public String toString(){
		return (payEffect + "to" + gainEffect );
	}

}
