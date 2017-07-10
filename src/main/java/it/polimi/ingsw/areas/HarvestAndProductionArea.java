package it.polimi.ingsw.areas;

import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.changes.*;
import it.polimi.ingsw.components.Relative;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

/**
 * @author Sara
 * It is the class for the type of areas that are harvest and production. 
 * Both have two different spaces: one on the left that hasn't cost and one on the right that has a malus
 * on the value of the relative.
 */

public class HarvestAndProductionArea extends Observable<Change> implements Serializable {
	// it is necessary to keep a a leftPlayer because when the first player use
	// this area, there is a penalty for the others
	private Relative leftRelative;
	private ArrayList<Relative> rightRelatives;
	private int valueOfLeftArea;
	private int valueOfRightArea;
	private int malus;
	private String type;

	public HarvestAndProductionArea(String type, int valueOfLeftArea, int valueOfRightArea, int malus) {
		this.type = type;
		this.valueOfLeftArea = valueOfLeftArea;
		this.valueOfRightArea = valueOfRightArea;
		this.malus = malus;
		this.rightRelatives = new ArrayList<Relative>();

	}

	public HarvestAndProductionArea(HarvestAndProductionArea area, Play play) {
		this.type = area.getType();
		this.valueOfLeftArea = area.getValueOfLeftArea();
		this.valueOfRightArea = area.getValueOfRightArea();
		this.malus = area.getMalus();
		this.rightRelatives = new ArrayList<Relative>();
		registerObserver(play);

	}

	public HarvestAndProductionArea(String type, int valueOfLeftArea) {
		this.type = type;
		this.valueOfLeftArea = valueOfLeftArea;

	}

	/**
	 * @author Sara
	 * To know if a player has already a relative on this space, a part from the neutral relative.
	 * If it returns true, the player cannot put another relative here for this round.
	 */
	public boolean isAlreadyPresent(Player player) {
		if (rightRelatives.size() ==  0){
			System.out.println("false");
			return false;
		}
		else {
		for (Relative r : rightRelatives) {
			if (r.getPlayer() == null || !(r.getPlayer() == player && r.getColor() != null)) {
				System.out.println("false");
				return false;
			}
		}
		return true;
		}
	}

	public Relative getLeftRelative() {
		return leftRelative;
	}

	public ArrayList<Relative> getRightRelatives() {
		return rightRelatives;
	}

	public void setLeftRelativeOnHarvest(Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		leftRelative = relative;
	}

	public void setLeftRelativeOnProduction(Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		leftRelative = relative;
	}

	public void setRightRelativeOnHarvest(Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		rightRelatives.add(relative);
	}

	public void setRightRelativeOnProduction(Relative relative)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		rightRelatives.add(relative);
	}

	public int getValueOfLeftArea() {
		return valueOfLeftArea;
	}

	public int getMalus() {
		return malus;
	}

	public String getType() {
		return type;
	}

	public void refresh() {
		leftRelative = null;
		rightRelatives.clear();
	}

	public int getValueOfRightArea() {
		return valueOfRightArea;
	}

	@Override
	public String toString() {
		
		if (valueOfRightArea == 0 && malus == 0) {
			if (leftRelative != null) {
				return ("The harvestAndProductionArea of type: " + type + " is: \n" + "The left value is "
						+ valueOfLeftArea + "  It is occupied by " + leftRelative.getPlayer().getName() + " with the relative "
						+ leftRelative.getColor() + "\n");
			} else {
				return ("The harvestAndProductionArea of type: " + type + " is: \n" + "The left value is "
						+ valueOfLeftArea + "  It is free ");
			}
		} else if (leftRelative != null) {
			for (int i = 0; i < rightRelatives.size(); i++) {
				return ("The harvestAndProductionArea of type: " + type + " is: \n" + "The left value is "
						+ valueOfLeftArea + "  It is occupied by " + leftRelative.getPlayer().getName() + " with the relative "
						+ leftRelative.getColor() + "\n" + "The right value is " + valueOfRightArea + "\n"
						+ "The malus is " + malus + "\n" + "It is occupied by" + rightRelatives.get(i).getPlayer().getName()
						+ " with the relative " + rightRelatives.get(i).getColor());
			}
			return ("The harvestAndProductionArea of type: " + type + " is: \n" + "The left value is " + valueOfLeftArea
					+ "  It is occupied by " + leftRelative.getPlayer().getName() + " with the relative "
					+ leftRelative.getColor() + "\n" + "The right value is " + valueOfRightArea + "\n" + "The malus is "
					+ malus + "\n" + " It is free");
		} else {
			for (int i = 0; i < rightRelatives.size(); i++) {
				return ("The harvestAndProductionArea of type: " + type + " is: \n" + "The left value is "
						+ valueOfLeftArea + " It is free " + "\n" + "The right value is " + valueOfRightArea + "\n"
						+ "The malus is " + malus + "\n" + "It is occupied by" + rightRelatives.get(i).getPlayer().getName()
						+ " with the relative " + rightRelatives.get(i).getColor());
			}
			return ("The harvestAndProductionArea of type: " + type + " is: \n" + "The left value is " + valueOfLeftArea
					+ "  It is free " + "\n" + "The right value is " + valueOfRightArea + "\n" + "The malus is " + malus
					+ "\n" + " It is free");
		}
	}

}
