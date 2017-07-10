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


/**
 * @author Chiara
 * Action invoked when a player puts one of his relatives on CouncilPalace
 *
 */

public class PutRelativeOnCouncilPalace extends Observable<Change> implements PutRelative {

	Relative relative;
	Player player;
	CouncilPalace councilPalace;
	String bonus;
	int match;

	public PutRelativeOnCouncilPalace(Player player, Relative relative, CouncilPalace councilPalace, String bonus, int match) {
		this.player = player;
		this.relative = relative;
		this.bonus = bonus;
		this.councilPalace = councilPalace;
		this.match = match;
	}
	
	/**
	 * @author Chiara
	 * Checks if the relative has enough value to do the action
	 *  
	 *
	 */
	
	@Override
	public boolean isApplicable() {
		// the required value is 1 to put a relative on the CouncilPalace
		if (relative.getValue() >= 1) {
			return true;
		}
		return false;

	}
	
	/**
	 * @author Chiara
	 * The action is applied. The relative occupies the area and the effect of it is activated. 
	 * In particular, the player can choose a bonus. The observer are notified of the action.
	 *
	 */
	
	@Override
	public void apply(Play play)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			// The player puts a relative on the councilPalace
			if (!(councilPalace.isAlreadyPresent(player))){
			play.getBoard().getCouncilPalace().addPlayer(player, relative);
			
			}
			play.notifyObserver(new ChangeCouncilPalace(player, relative));
			//Notify the observers that there is a new player in the council palace
			
			councilPalace.getRelatives().add(relative);
			player.setOccupiedRelative(relative);
			play.notifyObserver(new ChangeOccupiedRelative(player, relative));
			// The player receive the bonus
			councilPalace.applyEffect(play, player, bonus);
			play.changeCurrentPlayer();
		} else {
			if (relative.getServantsUsed()!=0){
				player.incrementServant(relative.getServantsUsed(), play);
				relative.setValueServant(0);
			}
			play.notifyObserver( new ChangeNotApplicable(player, "the relative hasn't enough value!"));
		}

	}

	@Override
	public int getMatch() {
		// TODO Auto-generated method stub
		return match;
	}
}
