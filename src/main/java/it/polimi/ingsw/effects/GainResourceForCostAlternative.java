package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;

/**
 * @author Chiara
 * This class represents the effect of gaining resources for a card with an alternative cost.
 *
 */

public class GainResourceForCostAlternative extends Effect{
	
	private ArrayList<Effect> payEffect;
	private ArrayList<Effect> gainEffect;
	private ArrayList<Effect> payEffectAlt;
	private ArrayList<Effect> gainEffectAlt;
	private boolean alternative=false;
	
	
	public GainResourceForCostAlternative(ArrayList<Effect> pay, ArrayList<Effect>gain, ArrayList<Effect> payAlt, ArrayList<Effect>gainAlt){
		payEffect=pay;
		gainEffect=gain;
		payEffectAlt=payAlt;
		gainEffectAlt=gainAlt;
	}

	@Override
	public void apply(Player player, Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if(alternative==false){
			for(Effect pay:payEffect){
				pay.apply(player, play);
			}
			for(Effect gain:gainEffect){
				gain.apply(player, play);
			}
		}
		else if(alternative==true){
			for(Effect pay:payEffectAlt){
				pay.apply(player, play);
			}
			for(Effect gain:gainEffectAlt){
				gain.apply(player, play);
			}
		}
		
	}
	
	@Override
	public boolean isApplicable(Player player){
		boolean check=false;
		if(alternative==false){
			for(Effect pay:payEffect){
				check=pay.isApplicable(player);
				if(check==false){
					return check;
				}
			}
			return check;
		}
		else{
			for(Effect pay:payEffectAlt){
				check=pay.isApplicable(player);
				if(check==false){
					return check;
				}
			}
			return check;
		}
	}

	public void chooseAlt(boolean choice){
		alternative=choice;
	}
	
	@Override
	public String toString(){
		return (payEffect + "to" + gainEffect + "or" + payEffectAlt + "to" + gainEffectAlt );
	}

}
