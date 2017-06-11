 package it.polimi.ingsw.actions;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.changes.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.areas.CouncilPalace;
import it.polimi.ingsw.components.Relative;

public class PutRelativeOnCouncilPalace extends Observable<Change> implements PutRelative {

	Relative relative;
	Player player;
	CouncilPalace councilPalace;
	String bonus;
	
	
	public PutRelativeOnCouncilPalace(Player player, Relative relative, CouncilPalace councilPalace, String bonus){
		this.player=player;
		this.relative=relative;
		this.bonus=bonus;
		this.councilPalace=councilPalace;
	}
	
	

	@Override
	public boolean isApplicable() {
		// the required value is 1 to put a relative on the CouncilPalace
		if (relative.getValue() >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//PROBLEMA 
	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			// The player puts a relative on the councilPalace
			play.getBoard().getCouncilPalace().addPlayer(player);
			ChangeCouncilPalace changeCouncilPalace= new ChangeCouncilPalace(relative);
			this.notifyObserver(changeCouncilPalace);
			// The player receive the bonus
			// TODO give player the council privilege bonus choice
			System.out.println(councilPalace);
			councilPalace.applyEffect(player, bonus);
		}

	}

}
