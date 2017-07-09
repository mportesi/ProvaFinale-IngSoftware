package it.polimi.ingsw.actions;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.HarvestAndProductionArea;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeHarvestLeftArea;
import it.polimi.ingsw.changes.ChangeHarvestRightArea;
import it.polimi.ingsw.changes.ChangeNotApplicable;
import it.polimi.ingsw.changes.ChangeOccupiedRelative;
import it.polimi.ingsw.changes.ChangeProductionLeftArea;
import it.polimi.ingsw.changes.ChangeProductionRightArea;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.Effect;
import it.polimi.ingsw.effects.GainProductionValue;

/**
 * @author Chiara
 * Action invoked when a player puts his relative on the Production Area.
 *
 */

public class PutRelativeOnProductionArea extends Observable<Change> implements PutRelative {
	Relative relative;
	HarvestAndProductionArea productionArea;
	Player player;
	String area; 
	int match;
	ArrayList<Effect> permanentEffect;
	
	public PutRelativeOnProductionArea(Player player, Relative relative, HarvestAndProductionArea productionArea, String area, int match, ArrayList<Effect> permanentEffect){
		this.player = player;
		this.relative=relative;
		this.area = area;
		this.productionArea=productionArea;
		this.match = match;
		this.permanentEffect=permanentEffect;
	}
	
	/**
	 * @author Chiara
	 * Checks if the action is applicable, in particular if the relative has enough value and, in case the chosen Area is the left one, verifies that this space is free. 
	 * In the second case, if the chosen area is the right one, verifies that there are not other relatives that belong to the player (except the neutral one) with the function isAlreadyPresent().
	 *
	 */
	
	@Override
	public boolean isApplicable() {
		
		switch (area){
		case "left" : {
			if (relative.getValue() >= productionArea.getValueOfLeftArea()) {
				if (productionArea.getLeftRelative() == null) {
					if ((!(productionArea.isAlreadyPresent(player)) || relative.getColor() == null)) {
						return true;
					}
				}
			}
			break;
		}
			
		
		
		case "right" : {
			if (relative.getValue() >= (productionArea.getValueOfRightArea()-productionArea.getMalus())) {
				if (!(productionArea.isAlreadyPresent(player)) || relative.getColor() == null) {
					return true;
				}
			}
			break;
			}
		
		}
		return false;
	}

	
	/**
	 * The player puts his/her relative on the left/right area. If the player has some building cards, he/she can activate the permanent effects associated to them.
	 * @author Chiara
	 * 
	 *
	 */

	@Override
	public void apply(Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		if (isApplicable()) {
			
			if (area.equals("left")) {
				productionArea.setLeftRelativeOnProduction(relative);
				play.notifyObserver(new ChangeProductionLeftArea(relative));
				player.setOccupiedRelative(relative);
				play.notifyObserver(new ChangeOccupiedRelative(player, relative));
				GainProductionValue gainProductionValue = new GainProductionValue(relative.getValue()); 
				gainProductionValue.apply(player, play);
				for(Effect effect:permanentEffect){
					effect.apply(player, play);
				}
				System.out.println(player);
			}
			
			else {
				productionArea.setRightRelativeOnProduction(relative);
				play.notifyObserver(new ChangeProductionRightArea(relative));
				player.setOccupiedRelative(relative);
				play.notifyObserver(new ChangeOccupiedRelative(player, relative));
				int malus = play.getBoard().getProductionArea().getMalus();
				relative.setValue(-malus);
				int newValue= relative.getValue();
				GainProductionValue gainProductionValue = new GainProductionValue(newValue); 
				gainProductionValue.apply(player, play);
				for(Effect effect:permanentEffect){
					effect.apply(player, play);
				}
				System.out.println(player);
			}
			play.changeCurrentPlayer();
		}
		else {
			if (relative.getServantsUsed()!=0){
				player.incrementServant(relative.getServantsUsed(), play);
				relative.setValueServant(0);
			}
			play.notifyObserver( new ChangeNotApplicable(player, "you cannot put a relative on production area!"));
		}
		return;
	}

	@Override
	public int getMatch() {
		return match;
	}

	
	
	
}
